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

# Exportación desde producción
export PGPASSWORD=$PROD_PASSWORD
pg_dump -h $PROD_HOST -p $PROD_PORT -U $PROD_USER -d $PROD_DB -F c -b -v --data-only -f $DUMP_FILE


# Comando para conectar a PostgreSQL y ejecutar TRUNCATE
export PGPASSWORD=$QA_PASSWORD


# Lista de tablas a limpiar
# Schemas a limpiar
SCHEMAS_TO_TRUNCATE="'pershing', 'public', 'stage_pershing', 'clientes'"

# TODO: Ver tema de nombres "especiales" de tablas (con números... escapar con comillas u otro)
TABLES=$(psql -h $QA_HOST -p $QA_PORT -U $QA_USER -d $QA_DB -t -A -c "SELECT '\"' || table_schema || '\".\"' || table_name || '\"' FROM information_schema.tables WHERE table_schema IN ($SCHEMAS_TO_TRUNCATE) AND table_type = 'BASE TABLE';")

echo "Las siguientes tablas serán truncadas en QA:"
echo $TABLES
read -p "¿Deseas continuar? (y/n) " choice
if [[ $choice != "y" ]]; then
  echo "Operación cancelada."
  exit 1
fi

for table in $TABLES; do
  echo "Truncando tabla $table"
  psql -h $QA_HOST -p $QA_PORT -U $QA_USER -d $QA_DB -c "TRUNCATE TABLE $table CASCADE;" || echo "Fallo al truncar $table"
done

pg_restore -h $QA_HOST -p $QA_PORT -U $QA_USER -d $QA_DB -v -c -1 $DUMP_FILE

# Limpieza (opcional)
unset PGPASSWORD
# rm $DUMP_FILE
