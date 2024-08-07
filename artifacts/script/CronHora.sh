#!/bin/bash

LOG_FILE_PERM="/var/log/qye-app-perm_$(date '+%Y-%m-%d').log"

chown -R admin-qye-azure:admin-qye-azure /qye/qande-mmii-proteccion/* >> "${LOG_FILE_PERM}" 2>&1
