#!/bin/bash

# Definir variables globales
DIR="$(dirname "${BASH_SOURCE[0]}")"
WORK_DIR="$(realpath "${DIR}")"
PID_FILE=docker.pid
SEM_VER_FILE=semver.pid
IMAGE_NAME=mytomcat:v1
WAR_NAME=core-web-col-web
WAR_FILE="${WAR_NAME}.war"
HOST_NAME="mmii-proteccion-dev.qande.cl"
DEFAULT_TIME_LOGS=30
# Dir base
ROOT_HOST_DIR=/qye
BASE_HOST_DIR="${ROOT_HOST_DIR}/qande-mmii-proteccion"
BASE_DOCKER_DIR=/qande-mmii-proteccion
# Dir lets encrypts
CERT_HOST_DIR=/etc/letsencrypt
CERT_DOCKER_DIR="${CERT_HOST_DIR}"

FULL_PATH_TO_WAR_FILE="${ROOT_HOST_DIR}/${WAR_FILE}"
CONT_ID=""
RELEASE_VERSION=""



# Función para obtener PID del contenedor
_fn_get_docker_pid() {
    # Obtenemos pid
    CONT_ID=$(head -n 1 "$PID_FILE")
    echo "Container ID $CONT_ID"
}

# Función para iniciar el contenedor
_fn_start_container() {
    echo "Iniciando contenedor..."
    docker build -t $IMAGE_NAME .
    docker run -d -v $BASE_HOST_DIR:$BASE_DOCKER_DIR -v $CERT_HOST_DIR:$CERT_DOCKER_DIR -p 80:8080 -p 443:8443 $IMAGE_NAME > $PID_FILE
    _fn_get_docker_pid
    docker cp $FULL_PATH_TO_WAR_FILE "$CONT_ID":/usr/local/tomcat/webapps
}

# Función para detener el contenedor
_fn_stop_container() {
    echo "Deteniendo contenedor..."
    docker stop "$CONT_ID"
    docker rm "$CONT_ID"
    echo "" > $PID_FILE
    docker image prune -a -f && docker system prune -a -f
}

# Función para ver los logs del contenedor
_fn_view_logs() {
    echo "Mostrando logs del contenedor..."
    if [ $# -eq 1 ]; then
        timeout "$1"s docker logs -f "$CONT_ID"
    else
        docker logs -f "$CONT_ID"
    fi
}

# Función para ingresar al contenedor
_fn_enter_container() {
    echo "Ingresando al contenedor..."
    docker exec -it "$CONT_ID" /bin/bash
}

# Función para obtener el nombre del directorio del release
_fn_get_release_dir() {
    RELEASE_DIR=$(find ${ROOT_HOST_DIR}/releases -maxdepth 1 -type d -name "${RELEASE_VERSION}-*" | sort -r | head -n 1)
    if [ -z "$RELEASE_DIR" ]; then
        echo "No se encontró el directorio para el release ${RELEASE_VERSION}"
        exit 1
    fi
    echo "Directorio del release encontrado: $RELEASE_DIR"
}

# Función para realizar los pasos previos al inicio del contenedor
_fn_pre_start_actions() {
    # Mostrando datos del release
    echo "Versión del release: $RELEASE_VERSION"

    _fn_get_release_dir

    echo "Realizando pasos previos al inicio del contenedor..."
    cd $ROOT_HOST_DIR || { echo "Directorio no existe $ROOT_HOST_DIR"; exit 1; }
    cp -a "${WAR_FILE}" "${WAR_FILE}_ROLLBACK"
    cp -a "${RELEASE_DIR}/${WAR_NAME}-${RELEASE_VERSION}.war" "./${WAR_FILE}"
    echo "${RELEASE_VERSION}" > $SEM_VER_FILE
    cd "${WORK_DIR}" || { echo "Directorio no existe $WORK_DIR"; exit 1; }
}

# Función para liberar nuevo release
_fn_new_deploy() {
    _fn_pre_start_actions
    _fn_stop_container
    _fn_start_container
    _fn_view_logs "$DEFAULT_TIME_LOGS"
}

# Función para hacer rollback
_fn_rollback() {
    echo "Ejecutando rollback..."
    cd $ROOT_HOST_DIR || { echo "Directorio no existe $ROOT_HOST_DIR"; exit 1; }
    cp -a "${WAR_FILE}_ROLLBACK" "${WAR_FILE}"
    cd "${WORK_DIR}" || { echo "Directorio no existe $WORK_DIR"; exit 1; }
    _fn_stop_container
    _fn_start_container
    _fn_view_logs "$DEFAULT_TIME_LOGS"
}

# Función para manejar variables de entorno para pasar valores a archivos docker
_fn_export_values() {
    # TODO: Revisar todas las variables necesarias y exportar; luego modificar docker-compsoe
    export DEPLOY_WORK_DIR="$WORK_DIR"
    export DEPLOY_CERT_HOST_DIR="$CERT_HOST_DIR"
}

# Función para crear certificado
_fn_new_cert() {
    # Mostrar mensaje de confirmación
    echo "***************************************************"
    echo "* Se le pedirá la contraseña de root              *"
    echo "* Creará certificado SSL para:                    *"
    echo "*                                                 *"
    echo "${HOST_NAME}"
    echo "*                                                 *"
    echo "***************************************************"
    echo "Presione Enter para continuar o Ctrl+C para cancelar."

    # Esperar a que el usuario presione Enter
    read -n 1 -r -s -p "Presione Enter para continuar..."
    echo ""  # Añadir una nueva línea después de la entrada del usuario
    sudo certbot certonly --manual --manual-auth-hook "${ROOT_HOST_DIR}/acme-dns-auth.py" --preferred-challenges dns --debug-challenges -d "${HOST_NAME}"
    _fn_stop_container
    _fn_start_container
    _fn_view_logs "$DEFAULT_TIME_LOGS"
}

# Función para renovar certificado
_fn_renew_cert() {
    # Mostrar mensaje de confirmación
    echo "***************************************************"
    echo "* Debe abrir los puertos 80/443 en el firewall    *"
    echo "* Además, se le pedirá la contraseña de root      *"
    echo "***************************************************"
    echo "Presione Enter para continuar o Ctrl+C para cancelar."

    # Esperar a que el usuario presione Enter
    read -n 1 -r -s -p "Presione Enter para continuar..."
    echo ""  # Añadir una nueva línea después de la entrada del usuario
    sudo certbot renew
    _fn_stop_container
    _fn_start_container
    _fn_view_logs "$DEFAULT_TIME_LOGS"
}

# Función de ayuda
_fn_help() {
    echo ""
    echo "Uso: deploy.sh [OPCIÓN]"
    echo "Despliega y administra la aplicación Q&E MMII."
    echo ""
    echo "Uso:"
    echo "deploy <versión> <fecha>"
    echo "[start|stop|logs]"
    echo "rollback | help | newcert | renew | enter"
    echo ""
    echo "OPCIONES:"
    echo "  deploy <versión>    Despliega una nueva versión de la aplicación."
    echo "  start          Inicia el contenedor de la aplicación."
    echo "  stop           Detiene el contenedor de la aplicación."
    echo "  logs           Muestra los logs del contenedor de la aplicación."
    echo "  enter          Ingresa al contenedor de la aplicación."
    echo "  rollback       Realiza un rollback a la versión anterior de la aplicación."
    echo "  newcert        Crea certificado SSL con certbot"
    echo "  renew          Renueva certificados SSL con certbot"
    echo "  help           Muestra esta ayuda."
    echo ""
    echo "EJEMPLO PARA DEPLOY:"
    echo "  deploy v7.0.0-RC"
    echo "    Despliega la versión v7.0.0-RC"
    echo ""
    echo "NOTAS:"
    echo "  - Las opciones 'deploy', 'rollback', 'help', 'newcert', 'renew' y 'enter' deben ejecutarse solas."
    echo "  - Las opciones 'start', 'stop' y 'logs' pueden ejecutarse solas o en conjunto."
    echo "  - Si se usan varias opciones, 'logs' debe ir al final."
    echo ""
}

# Valida opciones
_fn_validate_options() {
    # Verificar que se hayan proporcionado opciones
    if [ $# -eq 0 ]; then
        echo "Por favor, proporciona al menos una acción para ejecutar."
        return 1
    fi
    # Definir las expresiones regulares para los formatos
    local solo_opciones_regex='^(rollback|help|newcert|renew|enter)$'
    local despliegue_regex='^deploy [^ ]+$'
    local combinables_regex='^(stop )?(start)( logs)?$|^stop$|^logs$'

    # Unir todos los argumentos en una sola cadena para la validación
    local input_string="$*"

    # Validar según los formatos definidos
    if [[ $input_string =~ $solo_opciones_regex ]]; then
        return 0
    elif [[ $input_string =~ $despliegue_regex ]]; then
        return 0
    elif [[ $input_string =~ $combinables_regex ]]; then
        return 0
    else
        echo "Error: Las opciones proporcionadas no son válidas ($*)"
        return 1
    fi

}

echo "Parámetros de llamada: [$*]"


# Validamos llamado
if ! _fn_validate_options "$@"; then
    _fn_help
    exit 1
fi

cd "$WORK_DIR" || { echo "Directorio no existe $WORK_DIR"; exit 1; }
docker ps
_fn_get_docker_pid



# Procesar cada argumento
for arg in "$@"; do
    case "$arg" in
        deploy)
            if [ $# -ne 2 ]; then
                echo "Por favor, proporciona la versión para el despliegue."
                exit 1
            fi

            RELEASE_VERSION="$2"
            _fn_new_deploy
            exit 0
            ;;
        start)
            _fn_start_container
            ;;
        stop)
            _fn_stop_container
            ;;
        logs)
            _fn_view_logs
            ;;
        enter)
            _fn_enter_container
            ;;
        rollback)
            _fn_rollback
            ;;
        newcert)
            _fn_new_cert
            ;;
        renew)
            _fn_renew_cert
            ;;
        help)
            _fn_help
            ;;
        *)
            echo "Acción '$arg' no reconocida."
            _fn_help
            ;;
    esac
done

