FROM openjdk:11-oracle

RUN adduser app
USER app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} customer-manager.jar

ENTRYPOINT ["java","-jar","/customer-manager.jar"]
