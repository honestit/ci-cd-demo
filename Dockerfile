# Start from base maven image as builder role
FROM maven:3.6-jdk-11 as builder
# Create workdir and copy required files
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Package jar file without running tests
RUN mvn package -DskipTests

# Start from openjdk latest image
FROM openjdk:latest
# Copy previously built jar
COPY --from=builder /app/target/*.jar /app.jar
# Expose default port
EXPOSE 8080
# Set entry point to run jar file
ENTRYPOINT ["java","-jar","/app.jar"]