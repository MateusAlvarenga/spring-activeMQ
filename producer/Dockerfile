FROM maven:3.8.6-eclipse-temurin-8-alpine

WORKDIR /app

COPY . .

EXPOSE 8080

ENTRYPOINT [ "mvn", "spring-boot:run" ]