FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21
COPY target/carStore-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 1002
ENTRYPOINT ["java","-jar","app.jar"]
