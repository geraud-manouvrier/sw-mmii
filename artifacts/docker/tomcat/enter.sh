#!/bin/bash
DIR="$(dirname "${BASH_SOURCE[0]}")"
WORK_DIR="$(realpath "${DIR}")"
CONT_ID=`head -n 1 docker.pid`

cd $WORK_DIR

docker ps
echo Container ID $CONT_ID

docker exec -it $CONT_ID /bin/bash

docker ps
