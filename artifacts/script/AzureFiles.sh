#!/bin/bash

CRED_BASE_DIR=/etc
CRED_DIR=smbcredentials
CRED_FILE="${CRED_BASE_DIR}/${CRED_DIR}/storageproteccion.cred"

MNT_BASE_DIR=/mnt
MNT_DIR="${MNT_BASE_DIR}/qande-mmii-files"

USER=storageproteccion
PASSWD=MICLAVESECRETA

AZ_SERVER_HOST=storageproteccion.file.core.windows.net
AZ_SERVER_DIR=qande-mmii-dev

# Mostrar mensaje de confirmación
echo "***************************************************"
echo "* Debe ejecutar como root o con sudo              *"
echo "***************************************************"
echo "Presione Enter para continuar o Ctrl+C para cancelar."

# Esperar a que el usuario presione Enter
read -n 1 -r -s -p "Presione Enter para continuar..."
echo ""  # Añadir una nueva línea después de la entrada del usuario


# Solicitar al usuario actualizar el nombre de usuario
echo "El usuario actual es: $USER"
read -p "Ingrese nuevo usuario (presione Enter para mantener [$USER]): " new_user
if [ -n "$new_user" ]; then
  USER="$new_user"
fi

# Solicitar al usuario actualizar la contraseña
echo "La contraseña actual está configurada. No se mostrará por razones de seguridad."
read -sp "Ingrese nueva contraseña (presione Enter para mantener la actual): " new_passwd
echo ""  # Añadir una nueva línea después de la entrada
if [ -n "$new_passwd" ]; then
  PASSWD="$new_passwd"
fi

# Solicitar al usuario actualizar el servidor host
echo "El servidor host actual es: $AZ_SERVER_HOST"
read -p "Ingrese nuevo servidor host (presione Enter para mantener [$AZ_SERVER_HOST]): " new_host
if [ -n "$new_host" ]; then
  AZ_SERVER_HOST="$new_host"
fi

# Solicitar al usuario actualizar el directorio del servidor
echo "El directorio del servidor actual es: $AZ_SERVER_DIR"
read -p "Ingrese nuevo directorio del servidor (presione Enter para mantener [$AZ_SERVER_DIR]): " new_dir
if [ -n "$new_dir" ]; then
  AZ_SERVER_DIR="$new_dir"
fi


# Crear directorio para credenciales si no existe
mkdir -p ${CRED_BASE_DIR}/${CRED_DIR}

# Crear archivo de credenciales
echo "username=${USER}" > ${CRED_FILE}
echo "password=${PASSWD}" >> ${CRED_FILE}

# Establecer permisos seguros para el archivo de credenciales
chmod 600 ${CRED_FILE}

# Imprimir el archivo de credenciales para verificar
cat ${CRED_FILE}

# Crear directorio de montaje si no existe
mkdir -p ${MNT_DIR}

# Montar el recurso compartido de Azure Files usando las credenciales
# mount -t cifs //${AZ_SERVER_HOST}/${AZ_SERVER_DIR} ${MNT_DIR} -o credentials=${CRED_FILE},dir_mode=0777,file_mode=0777,serverino,nosharesock,actimeo=30


# Definir un identificador basado en la ubicación del recurso compartido de Azure
FSTAB_KEY="//${AZ_SERVER_HOST}/${AZ_SERVER_DIR} ${MNT_DIR}"

# Definir la entrada completa de fstab con todas las opciones necesarias
FSTAB_ENTRY="${FSTAB_KEY} cifs credentials=${CRED_FILE},dir_mode=0777,file_mode=0777,serverino,nosharesock,actimeo=30 0 0"

# Crear un backup del archivo fstab con marca de tiempo
TIMESTAMP=$(date +%Y%m%d_%H%M%S)
cp /etc/fstab /etc/fstab_BACKUP_${TIMESTAMP}
echo "Backup de fstab realizado: /etc/fstab_BACKUP_${TIMESTAMP}"

# Buscar la entrada actual en fstab
if grep -q "$FSTAB_KEY" /etc/fstab; then
    echo "Se encontró una entrada existente en fstab. Desmontando y actualizando..."
    # Desmontar el recurso compartido si está montado
    umount ${MNT_DIR}
    # Eliminar la entrada existente que contiene el identificador
    sudo sed -i "\|${FSTAB_KEY}|d" /etc/fstab
fi

# Agregar la nueva entrada a fstab
echo "Agregando nueva entrada a fstab para montaje automático en el reinicio..."
echo "$FSTAB_ENTRY" >> /etc/fstab

# Montar todas las entradas de fstab para verificar que todo está correcto
mount -a
echo "Todas las entradas de fstab han sido montadas."

echo "Configuración completa."
