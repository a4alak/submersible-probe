# Use a lightweight JDK base image
FROM openjdk:17

# Set working directory
WORKDIR /app

# Copy the built JAR into the container
COPY target/submersible-probe-1.0.0.jar /app

# Expose application port (adjust if different)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "submersible-probe-1.0.0.jar"]
