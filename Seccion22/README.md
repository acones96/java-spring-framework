# Docker

Docker is an **open-source platform** that allows developers to package applications into containers. Containers bundle everything an application needs to run, including the code, libraries, dependencies, and configurations, making them portable and consistent across different environments.

## How it Works
1. Write a code.
2. Define a `Dockerfile` (sets up the container environment).
3. Build a Docker image (`docker build`).
4. Run the container (`docker run`).

## Where is Used
* **Microservices**. Run independent services in separate containers.
* **CI/CD Pipelines**. Automate testing and deployment (Jenkins, GitHub actions).
* **Cloud Deployment**. Works on AWS, Azure, GCP, Kubernetes.
* **Local Development**. Set up dev environments quickly.

## Benefits
* **Works everywhere**. Avoid local issues on each developer.
* **Lightweight**. Uses fewer resources than virtual machines.
* **Fast deployments**. Start, stop, and replicate containers instantly.
* **Isolation**. Each container runs independently without affecting others.

## Architecture
1. **Docker Engine**. The core part that runs and manage containers.
2. **Docker Daemon (`dockerd`)**. Runs in the background and handles API requests.
3. **Docker CLI**. Command-line tool for interacting with Docker.
4. **Docker Images**. Read-only templates used to create containers.
5. **Docker Containers**. Running instances of Docker images.
6. **Docker Registry (Docker Hub)**. Stores and shares Docker images.

## Volume
When you run a container in Docker, any data created inside it disappears when the container stops or is deleted. This is because containers are ephemeral by nature. Docker volumes solve this problem by providing persistent storage that exists outside the container.

### Benefits
* **Persistent data**. Prevents data loss when a container stops.
* **Data sharing**. Allows multiple containers to access the same files.
* **Better performance**. Volumes are optimized by Docker for storage operations.
* **Easier backups**. Since volumes exist independently, they can be backed up separately from containers.
* **More secure**. You control what data is shared between containers.

### How to use Volumes
1. Create a Volume
    ```
        docker volume create my_volume
    ```
    This will create a new volume called "my_volume".

2. Use the Volume in a Container
    ```
    docker run -d --name my_container -v my_volume:/app/data nginx
    ```
    * `-v my_volume:/app/data`: Mounts the volume `my_volume` inside the container at `/app/data`.
   * Any data written to `/app/data` inside the container will **persist** even if the container is deleted.

3. List Existing Volumes
    ```
    docker volume ls
    ```
    This shows all created Docker volumes.
   
4. Inspect Volume
    ```
    docker volume inspect my_volume
    ```
    Shows details about the volume, including its storage path on the host.

5. Remove Volume
    ```
    docker volume rm my_volume
    ```
    This will delete the volume and all data inside it.

## Docker Commands Cheat Sheet
### Container Basics
| Command | Description |
|---------|------------|
| `docker run <image>` | Run a container from an image |
| `docker ps` | List running containers |
| `docker ps -a` | List all containers (including stopped) |
| `docker stop <container_id>` | Stop a running container |
| `docker start <container_id>` | Start a stopped container |
| `docker rm <container_id>` | Remove a container |

### Working with Images
| Command | Description |
|---------|------------|
| `docker images` | List all downloaded images |
| `docker pull <image>` | Download an image from Docker Hub |
| `docker build -t myapp .` | Build an image from a Dockerfile |
| `docker rmi <image>` | Remove an image |

### Volumes (Persistent Data Storage)
| Command | Description |
|---------|------------|
| `docker volume create mydata` | Create a volume |
| `docker volume ls` | List all volumes |
| `docker run -v mydata:/app/data <image>` | Attach a volume to a container |

## Docker Compose (Multiple Containers Management)
Docker Compose allows you to define multi-container applications using a `docker-compose.yml` file. Here's an example of it:

```
version: '3'
services:
  web:
    image: nginx
    ports:
      - "80:80"
  database:
    image: mysql
    environment:
      MYSQL_ROOT_PASSWORD: secret
```

Then, we use `docker-compose up -d` to run everything and `docker-compose down` to stop everything.

We can also use `docker-compose up --build` which 

* Rebuilds the service images defined in docker-compose.yml, even if they already exist.
* Starts the containers based on those newly built images.
* Applies changes in the Dockerfile or configuration files without manually removing containers.

## Run OpenJDK Image
To run a JDK in a container we need to do the following steps:
1. Find the OpenJDK image. We can use the command `docker search openjdk` and search for a official image or Docker desktop to search in Docker Hub.
2. Pull the image in Docker Desktop or use the command which is at the top, for example: `docker run openjdk:25-slim-bullseye`. Use `:` indicates a specific tag.
3. Once is pulled, run the image with the following command: `docker run -it openjdk:25-slim-bullseye`.
   * Using `-it` is used to start a Docker container in interactive mode with a terminal session as a jshell.
4. To exit the jshell we can use the command `/exit` in the terminal, but it will keep running.

## Packing Spring Boot Web App
1. Create the project with all requirements.
2. Execute `mvn package` to create his jar file.
3. Run `java -jar {project-jar-path}` to verify it works correctly as a `.jar`.
4. Put the jar file into the container.
   1. **Search where we can save the file**. 
      * We can see all folders using `docker exec {image-name} ls -a`. Usually tmp is a good place, which we can see what's in that folder adding `/tmp` instead of `-a`.
      ``` Final Docker Command Example
      docker exec relaxed_grothendieck ls /tmp
      ```
   2. **Save the `.jar` file into the tmp folder**. 
      * We use command copy (`cp`) where with the path of the .jar into the container:path as `docker cp {jar-path} {container-name}:{container-path}`.
      ``` Final Docker Command Example
      docker cp target/rest-demo.jar relaxed_grothendieck:/tmp
      ```
   3. **Create an image**.
      * Use `docker commit {container-name} {image-name}:{tag-name}`
      * Since the default command is `jshell` it won't run the project, so the correct commit should be `docker commit --change="CMD java -jar {jar-path}" {container-name} {image-name}:{tag-name}`
      ```Final Docker Command Example
      docker commit --change="CMD java -jar /tmp/rest-demo.jar" relaxed_grothendieck telusko/rest-demo:v2
      ```
   4. **Configure Docker Port**. 
      * The port where the project is running, isn't the same that is running in the machine.
      * To synchronize the port from the Docker to the one in the machine we use `p`, referred to port; the Docker port and the machine port which would be `docker run -p {docker-port}:{machine-port} {image-name}:{image-tag-name}`
      ```Final Docker Command Example
      docker run -p 8080:8080 telusko/rest-demo:v2
      ```
      
## Docker File
It allows us to write the instructions to build a Docker image automized. Here's the following example of an Dockerfile:
```
# (The container where we are based of)
FROM openjdk:17-jdk

# (Copy the project into the container)
ADD target/rest-demo.jar rest-demo.jar

# (Change the execution command)
ENTRYPOINT ["java", "-jar", "/rest-demo.jar"]

# (Once the configuration is set, the execute the following command in the terminal to create an image)
build -t {image-name}:{tag-name}
```