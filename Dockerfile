FROM openjdk:21-jdk-slim AS build

WORKDIR /app

COPY target/CalculatorApplication-0.0.1-SNAPSHOT.jar calculator-api.jar

EXPOSE 6000

ENTRYPOINT ["java", "-jar", "calculator-api.jar"]