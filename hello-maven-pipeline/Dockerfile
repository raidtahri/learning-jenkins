# Use an official Maven image to build the app
FROM maven:3.8.6-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Use a lightweight JRE to run the app
FROM openjdk:17-jre-slim
WORKDIR /app
COPY --from=build /app/target/hello-maven-app-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

