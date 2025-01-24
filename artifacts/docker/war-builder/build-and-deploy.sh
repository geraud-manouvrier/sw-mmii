#!/bin/bash

# Variables
REPO_URL="${REPO_URL}"  # Pasado como variable de entorno
BRANCH="${BRANCH}"      # Pasado como variable de entorno
TAG="${TAG}"            # Pasado como variable de entorno
OUTPUT_DIR="/mnt/output"
WORK_DIR="/app"

# Clonar el repositorio
if [ -n "$TAG" ]; then
  echo "Clonando el repositorio desde $REPO_URL con el tag $TAG..."
  git clone --depth 1 --branch $TAG $REPO_URL $WORK_DIR || exit 1
else
  echo "Clonando el repositorio desde $REPO_URL con la rama $BRANCH..."
  git clone --depth 1 --branch $BRANCH $REPO_URL $WORK_DIR || exit 1
fi

# Obtener la versión del proyecto
cd $WORK_DIR/core-web || exit 1
VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
echo "Versión detectada: $VERSION"

# Generar el WAR y el directorio
echo "Generando el WAR y el directorio versionado..."
mvn clean compile package || exit 1

# Identificar el nombre del directorio generado
TARGET_DIR=$(ls -d target/v${VERSION}-* 2>/dev/null)

if [ -z "$TARGET_DIR" ]; then
  echo "Error: No se encontró el directorio versionado en target." >&2
  exit 1
fi

echo "Directorio encontrado: $TARGET_DIR"

# Copiar el directorio completo al sistema anfitrión
echo "Copiando el directorio al directorio de salida..."
cp -r $TARGET_DIR $OUTPUT_DIR || exit 1

echo "¡Compilación completada con éxito!"
