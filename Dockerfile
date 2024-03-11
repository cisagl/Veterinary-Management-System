FROM maven:3.9.5-openjdk-latest AS build

WORKDIR /app

COPY VetApp/pom.xml /app
COPY VetApp/src /app/src

RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:latest

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
