# From the container
FROM amazoncorretto:17-al2023-jdk
# Copy the project into the tmp folder
ADD target/student-app.jar student-app.jar
# Document te ports that the container will listen on at runtime
EXPOSE 8080
# Pass the execution command
ENTRYPOINT ["java", "-jar", "/student-app.jar"]