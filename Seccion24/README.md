# Microservices

Every microservice is an independent project 

## Introduction 

A microservice is a small, independent, and loosely coupled service that is part of a larger system, where multiple microservices work together to form a complete application.

This kind of architecture is more modern than a monolithic architecture, where the hole application is a single, unified codebase where all components are tightly coupled and run as one unit, but where a small bug can bring down the entire system and his development is slower.

Some characteristics of microservices are:
1. **Single Responsibility.** Each microservice focuses on a specific functionality.
2. **Independently Deployable.** Can update or scale one microservice without affecting others.
3. **Decentralized Data Management.** Each service can have its own database.
4. **Lightweight Communication.** They communicate using APIs (usually REST or gRPC).
5. **Technology Agnostic.** Each microservice can use different programming language, framework, or database.

### Advantages
* **Scalability.** Can scale necessary parts.
* **Faster Development.** Can work with different teams for different services simultaneously.
* **Better Fault Isolation.** A bug in one microservice won't crash the entire system.
* **Flexibility.** Can mix different technologies.

### Disadvantages
* Might be overkill for small applications.
* Can be complex if your team lacks experience in distributed systems.

## Cloud-Native
To define a Cloud-Native application we just need to follow the 12 factor app rules or standard:

1. **Codebase.** One codebase tracked in revision control, many deploys.
   * Example: A single codebase per app, stored in Git, deployed in different environments (dev, prod, etc.)
2. **Dependencies.** Explicitly declare and isolate dependencies.
   * Example: Use tools like Maven/Gradle to declare all dependencies, avoid relying on system-level packages.
3. **Config.** Store config in the environment.
   * Example: Settings like DB URLs, secrets, etc., must be stored in environment variables, not hardcoded.
4. **Backing services.** Treat backing services as attached resources.
   * Example: Databases, caches, and queues should be accessed via URLs or endpoints, like external services.
5. **Build, release, run.** Strictly separate build and run stages.
   * Example: Build artifacts once, promote them to environments with different configs.
6. **Processes.** Execute the app as one or more stateless processes.
   * Example: Apps should be stateless. State foes in DB or external storage, not in memory.
7. **Port binding.** Export services via port binding.
   * Example: The app should start its own web server (like with Spring Boot on port 8080).
8. **Concurrency.** Scale out via the process model.
   * Example: Scale by running multiple instances, not by making a single app bigger.
9. **Disposability.** Maximize robustness with fast startup and graceful shutdown.
    * Example: Apps should boot quickly and shutdown cleanly to support scaling and updates.
10. **Dev/prod parity.** Keep development, staging, and production as similar as possible.
    * Example: Avoid "it works on my machine" by syncing environments.
11. **Logs.** Treat logs as event streams.
    * Example: Don't write to files; output logs to STDOUT/STDEER and use log aggregators.
12. **Admin processes.** Run admin/management tasks as one-off processes.
    * Example: Use commands like `java -jar app.jar db:migrate` for tasks, not as permanent parts of the app.

These factors are a guide to create an app scalable, maintainable, and portable in the cloud. To find more about these factors, click on the [12-factor link](https://12factor.net/).

## Microservice Requirements
We need:
* Load balancers
  * It distributes incoming network traffic across multiple instances of a microservice to prevent overloading a single server, improving availability, and ensure fast responses. It acts as an intermediary between clients and servers, using algorithms like round-robin, the least connections, or IP hash.
  * Key functions:
    * Distributes requests across instances.
    * Detects unavailable servers (health checks)
    * Supports horizontal scaling by adding more instances
    * Enhances fault tolerance
    
* API Gateways
  * It serves as a single entry point for all client requests to microservices. It handles tasks such as routing, authentication, authorization, rate limiting, request/response transformation, and monitoring. It reduces complexity by centralizing these functions.
  * Key functions:
    * Routes requests to the appropriate microservice.
    * Handles authentication and authorization.
    * Aggregates responses from multiple microservices.
    * Provides security and protection against attacks
    * Monitors and logs metrics.
    
* Service Registry
  * Is a centralized database that maintains a dynamic inventory of available microservice instances, including their addresses (IP and ports). Microservices register themselves upon startup and deregister upon shutdown. It enables service discovery in dynamic environments where instances frequently change.
  * Key functions:
    * Registers and deregister microservice instances.
    * Provides up-to-date information about service locations.
    * Integrates with load balancers for request routing.
    * Supports dynamic environments like containers or Kubernetes.
    
* Failed fast
  * It's a principle that involves quickly detecting and handling failures in a microservice to prevent issues from propagating or degrading the system. It is implemented using patterns like circuit breakers, timeouts, or limited retries, ensuring the system doesn't wait indefinitely for a response and takes alternative actions as fallback.
  * Key functions:
    * Prevents prolonged blockages during failures.
    * Protects the system from cascading errors.
    * Provides fallback responses when a service fails.
    * Enhances system resilience.

## Microservice Connection 
### Feign Client
A Feign Client is a declarative HTTP client developed by Netflix and commonly used in Spring Boot applications, especially in microservices architectures. It means you define an interface, and Feign automatically generates the implementation that makes the actual REST calls for you. So instead of manually using RestTemplate or WebClient, you just declare what endpoints you want to call.

### Service Discovery (Eureka)
Service Discovery is a pattern used in microservices architectures to help services find and communicate with each other automatically, without needing to hardcode the network locations (like IP addresses or ports) of other services.

To automatically enable Eureka Server we use the annotation @EnableEurekaServer in the main class of the Service Registry project.