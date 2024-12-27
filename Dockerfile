# Use a valid Maven base image with OpenJDK 17
FROM maven:3.9.4-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the project files into the container
COPY . .

# Build the application using Maven
RUN mvn clean package -DskipTests

# Use a lightweight OpenJDK image for running the application
FROM openjdk:17-jdk-slim

# Expose the application's port
EXPOSE 8080

# Copy the built jar file from the Maven build stage
COPY --from=build /app/target/TripSheep.jar /TripSheep-0.0.1-SNAPSHOT.jar

# Set the entry point for the application
ENTRYPOINT ["java", "-jar", "/TripSheep.jar"]