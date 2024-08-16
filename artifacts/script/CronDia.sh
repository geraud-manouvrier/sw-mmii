#!/bin/bash

# Definir las rutas de los directorios de origen y destino
SOURCE_DIR="/qye"  # Sin barra al final para incluir el directorio en la copia
APP_DIR="${SOURCE_DIR}/qande-mmii-proteccion"
BACKUP_DIR="/mnt/qande-mmii-files"
BACKUP_APP_DIR="${BACKUP_DIR}/app-backup"  # Sin barra al final
BACKUP_BD_DIR="${BACKUP_DIR}/bd-backup"  # Sin barra al final

FILE_PROPER="${APP_DIR}/environment.properties"
FILE_SECRETS="${APP_DIR}/secrets.properties"

# Configuración para el servidor a respaldar
REGEX_BD="jdbc:postgresql://([^:/]+):([0-9]+)/([^?]+)"
BD_STRING=""
BD_HOST=""
BD_PORT=5432
BD_DB=""
BD_USER=""
BD_PASSWORD=""
# Archivos de log y volcado
LOG_DIR="/var/log"
TIMESTAMP="$(date '+%Y-%m-%d')"
LOG_FILE_BACKUP="${LOG_DIR}/qye-app-backup_${TIMESTAMP}.log"
#LOG_FILE_BD="${LOG_DIR}/qye-app-bd_${TIMESTAMP}.log"
#DUMP_FILE="${BACKUP_BD_DIR}/DatabaseBackup_${TIMESTAMP}.dump"
DUMP_FILE_ZIP="${BACKUP_BD_DIR}/DatabaseBackup_${TIMESTAMP}.xz"

# Otras variables y parámetros
REQUIRED_PG_VERSION="16"
START_TIME=$(date +%s)


# ------------------------------------------------------
# Función para mostrar mensajes de error y salir
_fn_error_exit() {
    echo "Error: $1"
    exit 1
}

# ------------------------------------------------------
# Función para mensajes de log con marca de tiempo
_fn_echo_log() {
    local message="$1"
    echo "$(date '+%Y-%m-%d %H:%M:%S') $message"
}

# ------------------------------------------------------
# Función para verificar requisitos
_fn_check_env() {
    _fn_echo_log "Verificandor equisitos ambiente..."
    
    # Verificar y crear el directorio de logs si no existe
    if [ ! -d "$LOG_DIR" ]; then
        mkdir -p "$LOG_DIR" || {
            _fn_error_exit "Error: No se pudo crear el directorio de logs en '$LOG_DIR'."
        }
        _fn_echo_log "Directorio de logs creado (no existía): $LOG_DIR"
    fi

    # Verificar y crear el directorio de backups si no existe
    if [ ! -d "$BACKUP_BD_DIR" ]; then
        mkdir -p "$BACKUP_BD_DIR" || {
            _fn_error_exit "Error: No se pudo crear el directorio de backups en '$BACKUP_BD_DIR'."
        }
        _fn_echo_log "Directorio de backups creado (no existía): $BACKUP_BD_DIR"
    fi

    # Verificar la existencia del archivo de propiedades
    if [ ! -f "$FILE_PROPER" ]; then
        _fn_echo_log "No se encontró el archivo $FILE_PROPER"
        _fn_error_exit "No se encontró el archivo $FILE_PROPER"
    fi
    # Verificar la existencia del archivo de secrets
    if [ ! -f "$FILE_SECRETS" ]; then
        _fn_echo_log "No se encontró el archivo $FILE_SECRETS"
        _fn_error_exit "No se encontró el archivo $FILE_SECRETS"
    fi
    # Verificar la existencia de los comandos necesarios
    for cmd in rsync pg_dump xz; do
        if ! command -v $cmd &> /dev/null; then
            _fn_error_exit "$cmd no está instalado. Instálelo para continuar."
        fi
    done
    # Verificar versión de pg_dump (debe ser la misma del servidor de BD)
    # Obtiene la versión de pg_dump y verifica que sea la requerida
    PG_DUMP_MAJOR_VERSION=$(pg_dump --version | grep -oP '\d+' | head -1)
    if [[ $PG_DUMP_MAJOR_VERSION != "$REQUIRED_PG_VERSION" ]]; then
        _fn_error_exit "pg_dump versión $(pg_dump --version) no es compatible. Se requiere la versión $REQUIRED_PG_VERSION."
    fi

    _fn_echo_log "Todo ok en ambiente, continuando script..."
}

# ------------------------------------------------------
# Función para respaldo RSYNC
_fn_backup_app() {
    # Comando de backup con rsync
    _fn_echo_log "Iniciando respaldo rsync..."
    APP_START_TIME=$(date +%s)
    rsync -av --no-perms --no-times --temp-dir=/tmp --no-owner --no-group --delete "${SOURCE_DIR}" "${BACKUP_APP_DIR}" >> "${LOG_FILE_BACKUP}" 2>&1
    # Verificar el código de salida de rsync
    RSYNC_EXIT_CODE=$?
    APP_END_TIME=$(date +%s)
    APP_DURATION=$((APP_END_TIME - APP_START_TIME))
    if [ $RSYNC_EXIT_CODE -ne 0 ]; then
        _fn_echo_log "Respaldo rsync falló"
        echo "Error: rsync ha fallado con el código de salida $RSYNC_EXIT_CODE." >&2
        echo "COD:$RSYNC_EXIT_CODE" >> "${LOG_FILE_BACKUP}"
        exit $RSYNC_EXIT_CODE
    else
        echo "COD:0" >> "${LOG_FILE_BACKUP}"
        _fn_echo_log "Respaldo rsync OK ($APP_DURATION segundos)"
    fi
}

# ------------------------------------------------------
# Función para respaldo BD
_fn_backup_bd() {
    _fn_echo_log "Iniciando respaldo BD..."
    BD_START_TIME=$(date +%s)
    export PGPASSWORD=$BD_PASSWORD
    #pg_dump -h "$BD_HOST" -p "$BD_PORT" -U "$BD_USER" -d "$BD_DB" -F c -b -v --data-only -f "$DUMP_FILE"
    pg_dump -h "$BD_HOST" -p "$BD_PORT" -U "$BD_USER" -d "$BD_DB" -F c -b -v --data-only | xz > "$DUMP_FILE_ZIP"

    # Verificar código de salida de pg_dump
    PGDUMP_EXIT_CODE=$?
    unset PGPASSWORD
    BD_END_TIME=$(date +%s)
    BD_DURATION=$((BD_END_TIME - BD_START_TIME))
    BACKUP_FILE_SIZE=$(du -sh "$DUMP_FILE_ZIP" | cut -f1)
    if [ $PGDUMP_EXIT_CODE -ne 0 ]; then
        _fn_echo_log "Respaldo BD falló"
        echo "Error: pg_dump ha fallado con el código de salida $PGDUMP_EXIT_CODE." >&2
        exit $PGDUMP_EXIT_CODE
    else
        _fn_echo_log "Respaldo BD OK ($BD_DURATION segundos; tamaño $BACKUP_FILE_SIZE)"
    fi
}

# ------------------------------------------------------
# Función para obtener datos de conexión
_fn_initd_bd_params() {
    # Obtener el datos server
    BD_STRING=$(grep "^app\.properties\.datasource\.dbcore\.url=" "$FILE_PROPER" | cut -d "=" -f 2)

    if [[ $BD_STRING =~ $REGEX_BD ]]; then
        BD_HOST="${BASH_REMATCH[1]}"
        BD_PORT="${BASH_REMATCH[2]}"
        BD_DB="${BASH_REMATCH[3]}"
        _fn_echo_log "Datos de BD server obtenidos: (Host: $BD_HOST, Port: $BD_PORT, Database: $BD_DB)"
    else
        _fn_echo_log "No se pudo extraer el servidor, puerto y nombre de la base de datos desde el string JDBC."
        _fn_error_exit "No se pudo extraer el servidor, puerto y nombre de la base de datos desde el string JDBC."
    fi

    # Obtener el credenciales
    BD_USER=$(grep "^app\.properties\.datasource\.dbcore\.username=" "$FILE_SECRETS" | cut -d "=" -f 2)
    BD_PASSWORD=$(grep "^app\.properties\.datasource\.dbcore\.password=" "$FILE_SECRETS" | cut -d "=" -f 2)
    _fn_echo_log "Credenciales BD obtenidas"
}

# ------------------------------------------------------
# Función para obtener datos de conexión
_fn_show_statistics() {
    END_TIME=$(date +%s)
    TOTAL_DURATION=$((END_TIME - START_TIME))
    TOTAL_DURATION_MINUTES=$((TOTAL_DURATION / 60))
    REMAINING_SECONDS=$((TOTAL_DURATION % 60))

    # Mostrar estadísticas
    echo "Tamaño del archivo de backup de BD: $BACKUP_FILE_SIZE"
    echo "Duración del backup de BD: $BD_DURATION segundos"
    echo "Duración del backup de la app: $APP_DURATION segundos"
    echo "Duración total del script: $TOTAL_DURATION segundos ($TOTAL_DURATION_MINUTES min $REMAINING_SECONDS seg)"


}

# ------------------------------------------------------
# Ejecución del script

_fn_echo_log "Iniciando script; inicializando variables..."
_fn_check_env
_fn_initd_bd_params
_fn_backup_bd
_fn_backup_app
_fn_echo_log "Script finalizado, saliendo."
_fn_show_statistics

exit 0