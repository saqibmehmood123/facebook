# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the executable jar file from the target directory to the container
COPY target/Users-1.0-SNAPSHOT.jar /app/Users-1.0-SNAPSHOT.jar

# Expose the port the application will run on
EXPOSE 8087

# Run the jar file
ENTRYPOINT ["java","-jar","/app/Users-1.0-SNAPSHOT.jar"]
