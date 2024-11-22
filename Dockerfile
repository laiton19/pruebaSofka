
FROM openjdk:17-jdk-slim
LABEL authors="laito"

VOLUME /tmp
COPY target/pruebaSofka-0.0.1-SNAPSHOT.jar pruebasofka.jar
ENTRYPOINT ["java", "-jar", "/pruebasofka.jar"]