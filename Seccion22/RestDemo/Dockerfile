# From the container
FROM openjdk:17-jdk
# Copy the project into the tmp folder
ADD target/rest-demo.jar rest-demo.jar
# Pass the execution command
ENTRYPOINT ["java", "-jar", "/rest-demo.jar"]

# Create an image
#    We use docker `build -t {image-name}:{tag-name}`