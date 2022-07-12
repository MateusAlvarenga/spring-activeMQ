FROM openjdk:latest

WORKDIR /app

COPY target/producer-2.7.1.war  /app/producer.war

ENTRYPOINT ["java","-jar","/producer.war"]