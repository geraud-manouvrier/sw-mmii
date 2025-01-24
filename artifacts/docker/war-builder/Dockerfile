FROM maven:3.8.5-openjdk-11

# Crear directorio de trabajo
WORKDIR /app

# Copiar el script de compilación al contenedor
COPY build-and-deploy.sh /usr/local/bin/build-and-deploy.sh
RUN chmod +x /usr/local/bin/build-and-deploy.sh

# Comando por defecto
ENTRYPOINT ["build-and-deploy.sh"]
