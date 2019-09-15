FROM tomcat:latest
WORKDIR /usr/local/tomcat
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./tennis/target/Tennis-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/tennis.war
CMD ["catalina.sh","run"]
EXPOSE 80
