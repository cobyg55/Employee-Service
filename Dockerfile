FROM openjdk:8-jdk-alpine

COPY employee-service-app/build/libs/employee-service-app-0.0.1-SNAPSHOT-boot.jar employee-service-ms.jar

ENTRYPOINT ["java","-jar","/employee-service-ms.jar"]