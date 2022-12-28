FROM openjdk:8

#MAINTAINER emaaristimuno
ARG JAR_FILE=target/devzed-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
