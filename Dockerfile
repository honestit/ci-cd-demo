FROM openjdk:latest
# Create user and group for security reason
RUN addgroup -S demo && adduser -S demo -G demo
# Use new user
USER demo:demo
# Set variable to jar
ARG JAR_FILE=target/*.jar
# Copy jar as a predefined file
COPY ${JAR_FILE} app.jar
# Set entry point to run jar file
ENTRYPOINT ["java","-jar","/app.jar"]