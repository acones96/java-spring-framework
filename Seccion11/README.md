# Spring Boot Web

## Servlet

A `Servlet` is a Java class that handles HTTP request and responses in a web-based application. It runs on a Servlet Container (like Apache Tomcat, Jetty, etc.) which is part of a web server, and provides a way to extend the capabilities of web servers by responding to client request.

### Servlet Class
To create a Servlet class we need to first add two dependencies:
1. Servlet API dependency
2. Servlet Container (TOMCAT)

### Key Points
* **Handles HTTP Requests:** A servlet processes incoming HTTP requests (such as `GET`, `POST`, etc.) and generates appropriate responses (HTML, JSON, etc.)
* **Request and Response:** It allows fine-grained control over the request and response cycle, enabling custom logic,session management, and content generation.
* **Runs in a Servlet Container:** Servlets are managed by a servlet container, which routes requests to the appropriate servlet based on URL patterns.
* **When to Use:** Servlets are useful when you need low-level control over request handling, or when building a simple or small-scale web application. They're ideal for custom logic, handling APIs, or maintaining legacy systems.
* **When Not to Use:** For larger applications or those requiring an MVN architecture, frameworks like Spring MVC are better suited.