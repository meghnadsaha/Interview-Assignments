# Dockerfile for your Spring Boot microservice
FROM openjdk:11-jre-slim
COPY target/orderservice-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app
CMD ["java", "-jar", "orderservice-0.0.1-SNAPSHOT.jar"]
