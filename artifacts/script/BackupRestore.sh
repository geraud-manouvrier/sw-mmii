#!/bin/bash

# Configuración para el servidor de producción
PROD_HOST="pgsql16-mmii-proteccion-prod.postgres.database.azure.com"
PROD_PORT=5432
PROD_DB="qande_mmii"
PROD_USER="admin_qye_postgresql"
PROD_PASSWORD=""

# Configuración para el servidor de QA
QA_HOST="pgsql16-mmii-proteccion-qa.postgres.database.azure.com"
QA_PORT=$PROD_PORT
QA_DB=$PROD_DB
QA_USER="admin_qye_postgresql"
QA_PASSWORD=""


# Archivo de volcado
DUMP_FILE="BackupRestore.dump"


_fn_validate_input_options() {
  # Verificar si se ingresaron valores
  if [ -z "$input_options" ]; then
    echo "Debe ingresar al menos una opción."
    return 1
  fi

  # Verificar si se ingresaron solo números separados por espacios
  if ! [[ $input_options =~ ^[0-9\ ]+$ ]]; then
    echo "Debe ingresar solo números separados por espacios."
    return 1
  fi

  # Convertir la cadena de entrada en un array
  IFS=' ' read -r -a input_options_array <<< "$input_options"

  # Verificar si se ingresaron solo números entre 1 y 7
  for opt in "${input_options_array[@]}"; do
    if [ "$opt" -lt 1 ] || [ "$opt" -gt 3 ]; then
      echo "Las opciones deben ser números entre 1 y 7."
      return 1
    fi
  done

  #verifica si cada opción es mayor a la anterior (en el fondo, que vengan en orden aunque peuden saltarse opciones)
  for ((i = 1; i < ${#input_options_array[@]}; i++)); do
    if [ "${input_options_array[$i]}" -le "${input_options_array[$((i - 1))]}" ]; then
      echo "Las opciones deben estar en orden."
      return 1
    fi
  done

  return 0
}

_fn_set_credential_origen() {
  echo "Variables de entorno para el servidor de ORIGEN de respaldo:"
  echo "HOST: $PROD_HOST"
  echo "PORT: $PROD_PORT"
  echo "DB: $PROD_DB"
  echo "USER: $PROD_USER"

  read -r -p "Ingrese el nuevo valor para HOST (actual: $PROD_HOST, ENTER para mantener): " new_value
  if [ -n "$new_value" ]; then
    PROD_HOST=$new_value
  fi

  read -r -p "Ingrese el nuevo valor para PORT (actual: $PROD_PORT, ENTER para mantener): " new_value
  if [ -n "$new_value" ]; then
    PROD_PORT=$new_value
  fi

  read -r -p "Ingrese el nuevo valor para DB (actual: $PROD_DB, ENTER para mantener): " new_value
  if [ -n "$new_value" ]; then
    PROD_DB=$new_value
  fi

  read -r -p "Ingrese el nuevo valor para USER (actual: $PROD_USER, ENTER para mantener): " new_value
  if [ -n "$new_value" ]; then
    PROD_USER=$new_value
  fi

  read -r -p "Ingrese el valor para PASSWORD: " new_value
  PROD_PASSWORD=$new_value

  return 0
}


_fn_set_credential_destino() {
  echo "Variables de entorno para el servidor de DESTINO de respaldo:"
  echo "HOST: $QA_HOST"
  echo "PORT: $QA_PORT"
  echo "DB: $QA_DB"
  echo "USER: $QA_USER"

  read -r -p "Ingrese el nuevo valor para HOST (actual: $QA_HOST, ENTER para mantener): " new_value
  if [ -n "$new_value" ]; then
    QA_HOST=$new_value
  fi

  read -r -p "Ingrese el nuevo valor para PORT (actual: $QA_PORT, ENTER para mantener): " new_value
  if [ -n "$new_value" ]; then
    QA_PORT=$new_value
  fi

  read -r -p "Ingrese el nuevo valor para DB (actual: $QA_DB, ENTER para mantener): " new_value
  if [ -n "$new_value" ]; then
    QA_DB=$new_value
  fi

  read -r -p "Ingrese el nuevo valor para USER (actual: $QA_USER, ENTER para mantener): " new_value
  if [ -n "$new_value" ]; then
    QA_USER=$new_value
  fi

  read -r -p "Ingrese el valor para PASSWORD: " new_value
  QA_PASSWORD=$new_value

  return 0
}


_fn_realiza_respaldo() {
  # Exportación desde producción
  export PGPASSWORD=$PROD_PASSWORD
  echo "##############################################################"
  echo "Iniciando respaldo"
  pg_dump -h "$PROD_HOST" -p "$PROD_PORT" -U "$PROD_USER" -d "$PROD_DB" -F c -b -v --data-only -f "$DUMP_FILE"
  echo "Finalizado respaldo"
  echo "##############################################################"
  return 0;
}

_fn_set_schemas_to_truncate() {
  # Lista de schemas a limpiar
  SCHEMAS_TO_TRUNCATE="'pershing', 'public', 'stage_pershing', 'clientes'"
  # Mostrar Schemas a truncar por pantall
  echo "Schemas por defecto a procesar: $SCHEMAS_TO_TRUNCATE"

  # Pedir al usuario que ingrese los schemas a truncar
  read -r -p "Ingrese los schemas a truncar (separados por espacio, o presione Enter para usar los valores predeterminados): " input_schemas

  # Verificar si el usuario ingresó algo
  if [ -n "$input_schemas" ]; then
    # Convertir los esquemas ingresados en una lista separada por comas y encerrados en comillas simples
    SCHEMAS_TO_TRUNCATE=$(echo "$input_schemas" | sed "s/[^ ]\+/'&'/g" | tr ' ' ', ')
  fi

  # Mostrar la lista final de schemas a truncar
  echo "Schemas a truncar: $SCHEMAS_TO_TRUNCATE"
  # TODO: validar que existan schemas en la BD de QA

  return 0;
}


_fn_trunca_tablas() {
  # Comando para conectar a PostgreSQL y ejecutar TRUNCATE
  export PGPASSWORD=$QA_PASSWORD

  TABLES=$(psql -h "$QA_HOST" -p "$QA_PORT" -U "$QA_USER" -d "$QA_DB" -t -A -c "SELECT '\"' || table_schema || '\".\"' || table_name || '\"' FROM information_schema.tables WHERE table_schema IN ($SCHEMAS_TO_TRUNCATE) AND table_type = 'BASE TABLE' ORDER BY table_schema, table_name;")

  echo "Las siguientes tablas serán truncadas en QA:"
  echo "$TABLES"
  read -r -p "¿Deseas continuar? (y/n) " choice
  if [[ $choice != "y" ]]; then
    echo "Operación cancelada."
    exit 1
  fi

  for table in $TABLES; do
    echo "##############################################################"
    echo "Truncando tabla $table"
    echo "##############################################################"
    psql -h "$QA_HOST" -p "$QA_PORT" -U "$QA_USER" -d "$QA_DB" -c "TRUNCATE TABLE $table CASCADE;" || echo "Fallo al truncar $table"
  done

  echo "Finalizado truncando tabla $table"
  echo "##############################################################"
  return 0;
}


_fn_restaurar_respaldo() {
  export PGPASSWORD=$QA_PASSWORD
  echo "##############################################################"
  echo "Iniciando restauración"
  pg_restore -h "$QA_HOST" -p "$QA_PORT" -U "$QA_USER" -d "$QA_DB" -v -c -1 $DUMP_FILE
  echo "Restauración finalizada"
  echo "##############################################################"
}

_fn_limpieza() {
  # Limpieza (opcional)
  unset PGPASSWORD
  # Muestra mensaje de respaldo finalizado y pregunta si quiere borrar o no DUMP_FILE
  echo "##############################################################"
  echo "Respaldo finalizado"
  read -r -p "¿Desea borrar el archivo de respaldo [$DUMP_FILE]? (y/n) " choice
  if [[ $choice == "y" ]]; then
    rm $DUMP_FILE
  fi
  return 0;
}

_fn_muestra_menu() {
  echo "Seleccione las opciones que desea ejecutar:"
  echo "1. Ejecutar respaldo (Archivo $DUMP_FILE)"
  echo "2. Truncar tablas en destino"
  echo "3. Restaurar respaldo en destino"
  read -r -p "Ingrese los números de las opciones que desea ejecutar (separados por espacio): " input_options
}



# Inicio del script
_fn_muestra_menu
_fn_validate_input_options || exit 1

credential_origen_invoked=false
credential_destino_invoked=false

for opt in "${input_options_array[@]}"; do
  case $opt in
  1)
    if [ "$credential_origen_invoked" = false ]; then
      _fn_set_credential_origen || exit 1
      credential_origen_invoked=true
    fi
    _fn_realiza_respaldo || exit 1
    ;;
  2)
    if [ "$credential_destino_invoked" = false ]; then
      _fn_set_credential_destino || exit 1
      credential_destino_invoked=true
    fi
    _fn_set_schemas_to_truncate || exit 1
    _fn_trunca_tablas || exit 1
    ;;
  3)
    if [ "$credential_destino_invoked" = false ]; then
      _fn_set_credential_destino || exit 1
      credential_destino_invoked=true
    fi
    _fn_restaurar_respaldo || exit 1
    ;;
  esac
done

_fn_limpieza || exit 1
exit 0
# Fin del script
