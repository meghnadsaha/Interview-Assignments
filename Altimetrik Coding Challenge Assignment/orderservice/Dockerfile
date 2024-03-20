# Use a base image with OpenJDK 17 installed, compatible with Apple Silicon
FROM openjdk:17-jdk-slim-buster

WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container at the specified path
COPY target/orderservice-3.2.3.jar /app/app.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Define the command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]

#Try rebuilding your Docker image using this updated Dockerfile:
#docker build -t my-spring-boot-app .

#And then run the Docker container as before:
#docker build -t orderservice-3.2.3 .
#docker run -p 8080:8080 my-spring-boot-app
#docker run -p 8080:8080 orderservice-app
