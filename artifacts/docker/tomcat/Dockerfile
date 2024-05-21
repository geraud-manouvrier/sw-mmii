FROM tomcat:9-jdk11
ENV TZ=America/Santiago
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY tomcat-users.xml /usr/local/tomcat/conf/
COPY server.xml /usr/local/tomcat/conf/
COPY context.xml /usr/local/tomcat/conf/



