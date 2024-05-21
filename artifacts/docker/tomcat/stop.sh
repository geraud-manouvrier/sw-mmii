#!/bin/bash
DIR="$(dirname "${BASH_SOURCE[0]}")"
WORK_DIR="$(realpath "${DIR}")"
CONT_ID=`head -n 1 docker.pid`

PID_FILE=docker.pid

cd $WORK_DIR

docker ps
echo Container ID $CONT_ID

docker stop $CONT_ID
docker rm $CONT_ID

docker ps -a
echo "" > $PID_FILE
echo "Limpiando imagenes docker"
docker images prune -a && docker system prune -a -f
