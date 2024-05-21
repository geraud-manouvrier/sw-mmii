#!/bin/bash
DIR="$(dirname "${BASH_SOURCE[0]}")"
WORK_DIR="$(realpath "${DIR}")"

PID_FILE=docker.pid
IMAGE_NAME=mytomcat:v1
BASE_DIR=/qye/qande-mmii-proteccion
WAR_FILE=/qye/core-web-col-web.war


cd $WORK_DIR
docker build -t $IMAGE_NAME .
docker run -d -v $BASE_DIR:/qande-mmii-proteccion -v /etc/letsencrypt:/etc/letsencrypt -p 80:8080 -p 443:8443 $IMAGE_NAME > $PID_FILE
docker ps
CONT_ID=`head -n 1 docker.pid`

docker cp $WAR_FILE $CONT_ID:/usr/local/tomcat/webapps

