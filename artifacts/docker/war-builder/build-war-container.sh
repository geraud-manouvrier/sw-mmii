#!/bin/bash

# Variables
IMAGE_NAME="war-builder"
DOCKERFILE="Dockerfile"
TOKEN="${TOKEN_FOR_COMPILE_FROM_GIT}"  # Variable de entorno para el token
BRANCH="main"  # Valor predeterminado si no se pasa un tag
TAG=""         # Tag vacío por defecto
OUTPUT_DIR="/qye/releases"
CONTAINER_WORK_DIR="/mnt/output"

REPO_OWNER="geraud-manouvrier"  # Usuario de GitHub o GitLab
USERNAME="geraud-manouvrier"  # Usuario de GitHub o GitLab
REPO_NAME="sw-mmii"          # Nombre del repositorio
PLATFORM="github.com"        # Cambiar a gitlab.com si es necesario

# Construir la URL del repositorio
REPO_URL="https://${USERNAME}:${TOKEN}@${PLATFORM}/${REPO_OWNER}/${REPO_NAME}.git"

# Función para mostrar ayuda
function show_help() {
  echo "Uso: $0 {levantar|compilar|limpiar} [--tag <nombre_del_tag>]"
  echo "  levantar   - Construir la imagen del contenedor"
  echo "  compilar   - Ejecutar el contenedor para generar el WAR"
  echo "  limpiar    - Eliminar la imagen y contenedores temporales"
  echo "  --tag      - (Opcional) Especificar un tag para el clon en lugar de la rama main"
}

# Validar que el TOKEN esté configurado
function validate_token() {
  if [ -z "$TOKEN" ]; then
    echo "Error: El TOKEN_FOR_COMPILE_FROM_GIT no está configurado. Configúralo como una variable de entorno." >&2
    exit 1
  fi
}

# Construir la imagen del contenedor
function build_image() {
  echo "Construyendo la imagen Docker..."
  docker build -t $IMAGE_NAME -f $DOCKERFILE .
  if [ $? -eq 0 ]; then
    echo "Imagen $IMAGE_NAME creada con éxito."
  else
    echo "Error al construir la imagen." >&2
    exit 1
  fi
}

# Ejecutar el contenedor para compilar
function run_container() {
  validate_token
  if [ -n "$TAG" ]; then
    echo "Clonando desde el tag: $TAG"
    BRANCH=""  # Si usamos un tag, ignoramos la rama
  else
    echo "Clonando desde la rama: $BRANCH"
  fi

  docker run --rm -v $OUTPUT_DIR:$CONTAINER_WORK_DIR \
    -e REPO_URL="$REPO_URL" \
    -e BRANCH=$BRANCH -e TAG=$TAG $IMAGE_NAME
  if [ $? -eq 0 ]; then
    echo "WAR generado en $OUTPUT_DIR."
  else
    echo "Error al ejecutar el contenedor." >&2
    exit 1
  fi
}

# Limpiar imágenes y contenedores temporales
function clean_up() {
  echo "Eliminando la imagen Docker..."
  if docker images -q $IMAGE_NAME >/dev/null 2>&1; then
    docker rmi -f $IMAGE_NAME
    echo "Imagen $IMAGE_NAME eliminada con éxito."
  else
    echo "La imagen $IMAGE_NAME no existe. No se realizó ninguna acción."
  fi
}

# Parsear los argumentos
while [[ $# -gt 0 ]]; do
  case "$1" in
    levantar)
      build_image
      shift
      ;;
    compilar)
      shift
      if [[ $1 == "--tag" ]]; then
        TAG="$2"
        shift 2
      fi
      run_container
      ;;
    limpiar)
      clean_up
      shift
      ;;
    *)
      show_help
      exit 1
      ;;
  esac
done
