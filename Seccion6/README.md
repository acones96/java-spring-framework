# Spring Getting Started

> ***This project is setup for Java 21***

## Introduction

Spring is a lightweight open source framework, which works with Plain Old Java Objects (POJOs), for building Java-based enterprise applications that provides a comprehensive programming and configuration model for modern Java applications, offering support for various functionalities such as dependency injection, aspect-oriented programming, and integration with data access and web technologies.

We can see the website [spring.io](https://markdownlivepreview.com/) to build microservices, reactive, cloud, web apps, serverless, event driven, and batch projects.

### Key Features

Some key features of Spring are: 

1. **Dependency Injection (DI):**

   Spring provides a powerful Inversion of Control (IoC) container that manages object creation, wiring, and lifecycle management. This reduces tight coupling between components.

2. **Aspect-Oriented Programming (AOP):**

   Spring enables modularizing cross-cutting concerns (e.g., logging, security, transaction management) using AOP.

3. **Modular Architecture:**

   Spring is modular, meaning you can use only the parts you need (e.g., Spring Core, Spring MVC, Spring Data, etc.).

4. **Declarative Programming:**

   You can configure application behavior using annotations or XML, reducing boilerplate code.

5. **Integration with Other Frameworks:**

   Spring seamlessly integrates with ORM frameworks (like Hibernate), messaging systems, and cloud platforms.

6. **Built-in Support for Testing:**

   Spring simplifies testing with support for dependency injection, mocks, and integration test utilities.

7. **Spring Boot:**

   A subproject of Spring that simplifies application development by providing defaults, embedded servers, and minimal configuration.

### Core Components of Spring
| **Component**       | **Description**                                                                                      |
|---------------------|------------------------------------------------------------------------------------------------------|
| **Spring Core**     | Provides the IoC container and Dependency Injection (DI).                                            |
| **Spring AOP**      | Supports Aspect-Oriented Programming for modularizing cross-cutting concerns.                        |
| **Spring MVC**      | Framework for building web applications using the Model-View-Controller design pattern.              |
| **Spring Data**     | Simplifies database access and supports JPA, JDBC, and NoSQL databases.                              |
| **Spring Security** | Provides authentication, authorization, and security for applications.                               |
| **Spring Boot**     | Simplifies application setup with opinionated defaults, embedded servers, and minimal configuration. |
| **Spring Cloud**    | Tools for building distributed and cloud-native applications.                                        |

## Spring Docs

We can find a lot of documentation in [Spring Framework Documentation](https://docs.spring.io/spring-framework/reference/index.html) for different topics and versions.

## IoC and DI
Inversion of Control (IoC) is a principle in software design where the **control of objects creation, configuration, and lifecycle management** is transferred from the application code to a container or framework. In simpler words, instead of creating and managing objects manually, we delegate this responsibility to the Spring IoC container.

Dependency Injection (DI) is a design pattern that enable objects to receive their dependencies from an external source rather than creating them themselves. In simpler words, they inject dependencies into a class.

Working together, IoC enable Spring to take control of objects creating and lifecycle management while DI is the mechanism Spring uses to supply dependencies to objects.

## Spring vs Spring Boot
Spring and Spring Boot are part of the same ecosystem, but they serve different purposes.

| **Feature**               | **Spring Framework**                                 | **Spring Boot**                                   |
|---------------------------|------------------------------------------------------|-------------------------------------------------|
| **Purpose**               | Comprehensive framework for Java applications.       | Simplifies Spring development with ready-to-use tools. |
| **Configuration**         | Requires manual configuration (XML/Java).            | Automatic configuration with minimal setup.     |
| **Embedded Server**       | Requires external servers (e.g., Tomcat, JBoss).     | Comes with embedded servers (Tomcat, Jetty).    |
| **Dependencies**          | Manually manage dependencies in `pom.xml`.           | Provides **starter dependencies** for quick setup. |
| **Setup Complexity**      | Higher due to manual wiring and configurations.      | Low complexity with **auto-configuration**.     |
| **Deployment**            | WAR file deployed to an external server.             | Creates **executable JARs** with embedded servers. |
| **Microservices Support** | Supported but requires more setup.                   | Built-in support for **microservices**.         |
| **Spring Initializr**     | Not available.                                       | Provides **Spring Initializr** for project bootstrapping. |

We use Spring when:
* Legacy projects or complex applications where manual configuration is required.
* When we need fine-grained control over dependencies and setup.

On the other hand, we use Spring Boot when:
* Projects require rapid development.
* Need to build microservices, standalone REST APIs, or production-ready apps quickly.