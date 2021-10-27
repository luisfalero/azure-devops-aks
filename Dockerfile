## MULTI-STAGE
## Compilar, ejecutar test y crear artefacto JAR
FROM maven:3.8-openjdk-11-slim AS BUILD_IMAGE
ENV APP_HOME=/root/dev/app/
RUN mkdir -p $APP_HOME/src/main/java
WORKDIR $APP_HOME
COPY . .
RUN ls -lha
RUN mvn clean package

## Ejecutar la aplicación
FROM openjdk:11-jre
LABEL maintainer="BCP-AZURE-DEVOPS"
EXPOSE 80
WORKDIR /root/
COPY --from=BUILD_IMAGE /root/dev/app/target/bcp-azure-devops-0.0.1.jar /opt/app.jar
ENTRYPOINT ["java", "-Djava.file.encoding=UTF-8","-jar","/opt/app.jar"]