FROM openjdk:8-jdk-alpine
#FROM amazoncorretto:8-alpine-jdk
#MAINTAINER emaaristimuno
ARG JAR_FILE=target/devzed-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} devzed-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/devzed-0.0.1-SNAPSHOT.jar"]
