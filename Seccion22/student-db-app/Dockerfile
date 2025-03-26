# From the container
FROM openjdk:17-jdk
# Copy the project into the tmp folder
ADD target/student-app.jar student-app.jar
# Pass the execution command
ENTRYPOINT ["java", "-jar", "/student-app.jar"]