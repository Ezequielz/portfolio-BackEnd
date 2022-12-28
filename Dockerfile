FROM amazoncorretto:8-alpine-jdk

#MAINTAINER emaaristimuno

COPY target/devzed-0.0.1-SNAPSHOT.jar devzed-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/devzed-0.0.1-SNAPSHOT.jar"]
