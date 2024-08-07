#!/bin/bash

# Definir variables globales
DIR="$(dirname "${BASH_SOURCE[0]}")"
WORK_DIR="$(realpath "${DIR}")"
PID_FILE=docker.pid
SEM_VER_FILE=semver.pid
IMAGE_NAME=mytomcat:v1
WAR_NAME=core-web-col-web
WAR_FILE="${WAR_NAME}.war"
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
RELEASE_ID=""
RELEASE_DATE=""



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
    docker cp $FULL_PATH_TO_WAR_FILE $CONT_ID:/usr/local/tomcat/webapps
}

# Función para detener el contenedor
_fn_stop_container() {
    echo "Deteniendo contenedor..."
    docker stop $CONT_ID
    docker rm $CONT_ID
    echo "" > $PID_FILE
    docker image prune -a && docker system prune -a -f
}

# Función para ver los logs del contenedor
_fn_view_logs() {
    echo "Mostrando logs del contenedor..."
    docker logs -f $CONT_ID
}

# Función para ingresar al contenedor
_fn_enter_container() {
    echo "Ingresando al contenedor..."
    docker exec -it $CONT_ID /bin/bash
}

# Función para realizar los pasos previos al inicio del contenedor
_fn_pre_start_actions() {
    # Mostrando datos del release
    echo "Versión del release: $RELEASE_VERSION"
    echo "ID de iteración: $RELEASE_ID"
    echo "Fecha del release: $RELEASE_DATE"

    echo "Realizando pasos previos al inicio del contenedor..."
    cd $ROOT_HOST_DIR
    cp -a "${WAR_FILE}" "${WAR_FILE}_ROLLBACK"
    cp -a "releases/${RELEASE_VERSION}-${RELEASE_ID}-${RELEASE_DATE}/${WAR_NAME}-${RELEASE_VERSION}.war" "./${WAR_FILE}"
    echo "${RELEASE_VERSION}" > $SEM_VER_FILE
    cd "${WORK_DIR}"
}

# Función para liberar nuevo release
_fn_new_deploy() {
    _fn_pre_start_actions
    _fn_stop_container
    _fn_start_container
    _fn_view_logs
}

# Función para hacer rollback
_fn_rollback() {
    echo "Ejecutando rollback..."
    cd $ROOT_HOST_DIR
    cp -a "${WAR_FILE}_ROLLBACK" "${WAR_FILE}"
    cd "${WORK_DIR}"
    _fn_stop_container
    _fn_start_container
    _fn_view_logs
}

# Función para manejar variables de entorno para pasar valores a archivos docker
_fn_export_values() {
    # TODO: Revisar todas las variables necesarias y exportar; luego modificar docker-compsoe
    export DEPLOY_WORK_DIR="$WORK_DIR"
    export DEPLOY_CERT_HOST_DIR="$CERT_HOST_DIR"
}

# Función para renovar certificado
_fn_renew_cert() {
    # Mostrar mensaje de confirmación
    echo "***************************************************"
    echo "* Debe abrir los puertos 80/443 en el firewall    *"
    echo "* Agregue la IP 0.0.0.0/0 a las IPs permitidas    *"
    echo "* Además, se le pedirá la contraseña de root      *"
    echo "***************************************************"
    
    # Esperar a que el usuario presione Enter
    read -n 1 -r -s -p "Presione Enter para continuar o Ctrl+C para cancelar...."
    echo ""  # Añadir una nueva línea después de la entrada del usuario
    _fn_stop_container
    sudo certbot renew
    _fn_start_container
    _fn_view_logs
}

# Función de ayuda
_fn_help() {
    echo ""
    echo "Uso: deploy.sh [OPCIÓN]"
    echo "Despliega y administra la aplicación Q&E MMII."
    echo ""
    echo "Uso:"
    echo "deploy <versión> <ID de iteración> <fecha>"
    echo "[start|stop|logs]"
    echo "rollback | help | renew | enter"
    echo ""
    echo "OPCIONES:"
    echo "  start          Inicia el contenedor de la aplicación."
    echo "  stop           Detiene el contenedor de la aplicación."
    echo "  logs           Muestra los logs del contenedor de la aplicación."
    echo "  enter          Ingresa al contenedor de la aplicación."
    echo "  deploy <versión> <ID de iteración> <fecha>    Despliega una nueva versión de la aplicación."
    echo "  rollback       Realiza un rollback a la versión anterior de la aplicación."
    echo "  renew          Renueva certificados SSL con certbot"
    echo "  help           Muestra esta ayuda."
    echo ""
    echo "EJEMPLO PARA DEPLOY:"
    echo "  deploy v7.0.0-RC 01 20240529"
    echo "    Despliega la versión v7.0.0-RC con ID de iteración 01 y fecha 20240529."
    echo ""
    echo "NOTAS:"
    echo "  - Las opciones 'deploy', 'rollback', 'help', 'renew' y 'enter' deben ejecutarse solas."
    echo "  - Las opciones 'start', 'stop' y 'logs' pueden ejecutarse solas o en conjunto."
    echo "  - Si se usan varias opciones, 'logs' debe ir al final."
    echo ""
    _fn_validate_options
}

# Valida opciones
_fn_validate_options() {
    return 0
    
    # Verificar que se hayan proporcionado opciones
    if [ $# -eq 0 ]; then
        echo "Por favor, proporciona al menos una acción para ejecutar."
        exit 1
    fi

    # Definir las expresiones regulares para las opciones
    local deploy_regex='^(deploy|rollback|help|renew|enter)$'
    local multiple_options_regex='^(start|stop)( (start|stop|logs))*$'
    local logs_regex='^logs$'

    for arg in "$@"; do
        if [[ $arg =~ $deploy_regex ]]; then
            echo "Solo se puede ejecutar '$arg' por sí solo."
            exit 1
        elif [[ $arg =~ $multiple_options_regex ]]; then
            echo "Las opciones '$arg' se pueden ejecutar solas o en conjunto con otras opciones de 'start' o 'stop'."
            exit 1
        elif [[ $arg =~ $logs_regex ]]; then
            echo "La opción '$arg' solo puede ir al final cuando se utilizan varias opciones."
            exit 1
        fi
    done

}


# Validamos llamado
_fn_validate_options "$@"

cd $WORK_DIR
docker ps
_fn_get_docker_pid



# Procesar cada argumento
for arg in "$@"; do
    case "$arg" in
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
        deploy)
            if [ $# -ne 4 ]; then
                echo "Por favor, proporciona la versión, ID de iteración y fecha para el despliegue."
                exit 1
            fi

            RELEASE_VERSION="$2"
            RELEASE_ID="$3"
            RELEASE_DATE="$4"
            _fn_new_deploy
            ;;
        rollback)
            _fn_rollback
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

