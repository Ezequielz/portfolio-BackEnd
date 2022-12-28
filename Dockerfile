FROM openjdk:8-jdk-alpine

#MAINTAINER emaaristimuno
ARG JAR_FILE=target/devzed-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
