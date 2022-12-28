
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM amazoncorretto:11-alpine-jdk

MAINTAINER emaaristimuno

COPY target/devzed-0.0.1-SNAPSHOT.jar devzed-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/devzed-0.0.1-SNAPSHOT.jar"]
