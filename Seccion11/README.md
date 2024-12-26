# Spring Boot Web

We have two different projects: SpringBootWeb, which is developed using Servlets; and SpringBootMvc, which is developed using Spring Web dependency.

* SpringBootWeb

  It is all developed in the App and HelloServlet java files.


* SpringBootMvc

  We develop a few in the src/main/webapp/views of how it will be shown from the page from the client side. The tomcat-jasper dependency will be in charge to convert the .jsp file into a Servlet.

  We create a CSS file in src/main/resources/static to give more personalized experience in the views. We set it on static because is perfect for serving frontend assets, static web pages, and media files. 

  We also use a little of `application.properties` to identify the prefix and suffix of views files.

## Servlet

A `Servlet` is a Java class that handles HTTP request and responses in a web-based application. It runs on a Servlet Container (like Apache Tomcat, Jetty, etc.) which is part of a web server, and provides a way to extend the capabilities of web servers by responding to client request.

### Servlet Class
To create a Servlet class we need to first add two dependencies:
1. Servlet API dependency
2. Servlet Container (TOMCAT)

To handle different types of requests, such as `GET`, `POST` `PUT`, and `DELETE` in a servlet, we use the methods as `doGet()`, `doPost()`, `doPut()` or `doDelete()` the same way we use `service()`.

### Key Points
* **Handles HTTP Requests:** A servlet processes incoming HTTP requests (such as `GET`, `POST`, etc.) and generates appropriate responses (HTML, JSON, etc.)
* **Request and Response:** It allows fine-grained control over the request and response cycle, enabling custom logic,session management, and content generation.
* **Runs in a Servlet Container:** Servlets are managed by a servlet container, which routes requests to the appropriate servlet based on URL patterns.
* **When to Use:** Servlets are useful when you need low-level control over request handling, or when building a simple or small-scale web application. They're ideal for custom logic, handling APIs, or maintaining legacy systems.
* **When Not to Use:** For larger applications or those requiring an MVN architecture, frameworks like Spring MVC are better suited.

## MVC

MVC is a design pattern used to separate the presentation layer from the business logic in software applications. This separation promotes organized, scalable, and maintainable code by dividing an application into three interconnected components: 
1. **Model.** Represents the data and business logic.
2. **View.** Handles the user interface (UI).
3. **Controller.** Manages user input and coordinates between the Model and View.

### MVC Architecture

```
           +----------------+              +--------------------+ 
           |    View/JSP    | <----------> | Controller/Servlet |
           +----------------+              +--------------------+ 
                  |                          |      
                  |                          v      
                  |                    +-----------------+ 
                  +------------------->|   Model/POJO    |
                                       +-----------------+ 
```

### Detailed Breakdown of MVC Components

| **Component** | **Role** | **Example**                                      |
|--------------|----------|---------------------------------------------------|
| **Model**    | Manages data, logic, and rules. Notifies View of data changes.| Database queries, business rules, or calculations. |
| **View**     | Displays data to users. Reflects updates from the Model.      | HTML pages, JSP, or front-end components.          |
| **Controller**| Handles user inputs. Updates the Model and selects the appropriate View. | Servlet, Spring Controller, or REST API handler. |



### Jakarta Server Page (JSP)
JSP is a Java EE technology view technology that allows us to create dynamic web pages based on HTML/XML, with the ability to integrate server-side logic using Java.

Meanwhile, Servlet is the one in charge to accept the request from the client, JSP is in charge to create the web page.