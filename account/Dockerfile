FROM openjdk:8
LABEL authors="Eltan Hajiyev"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar", "--server.port=8080", "--spring.cloud.consul.host=172.17.0.2"]
EXPOSE 8080
