FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build src/app/target/carStore-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 1002
ENTRYPOINT ["java","-jar","app.jar"]
