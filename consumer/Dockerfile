FROM openjdk:latest

WORKDIR /app

COPY target/consumer-2.7.1.war  /app/consumer.war

ENTRYPOINT ["java","-jar","/consumer.war"]