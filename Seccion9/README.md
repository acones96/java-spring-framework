# Moving to Spring Boot

Any application will have multiple layers that have a Client which interact with a Server and it has a Database.

If we need some data, the Client send a request to the Server, the Server send a request to the Database, the Database returns the data to the Server and the Server send that data to the Client

```
Client ---> Server ---> Database 
                             |
Client <-- Server <----------|
```


In the server, we have multiple layers: 
* **Controller.** <br> Is the entry point of your application for handling HTTP requests and returning HTTP responses.
* **Service.** <br> Contains the business logic of your application. It's responsible for handling the actual work, processing, and transformation of data.
Since Service can't access to data, we use a layer in between called DAO or Repository.
* **Repository or Data Access Object (DAO).** <br> Is responsible for interacting with the data source and return it to the service. This layer abstracts the database interaction and is concerned with CRUD operations (Create, Read, Update, Delete).


## Annotations

* `@Service`

  It is a specialization of `@Component` used for service classes. These are classes that hold the business logic of the application — typically operations and domain rules that process data, interact with repositories, or call external services. When applied to a class it tells Spring that the class is a service component, and it should be registered as a bean in the Spring application context.


* `@Repository`

  It is another specialization of `@Component` but is specifically intended for data access classes. These are classes that interact with the database or any other form of persistent storage (e.g., file systems, external APIs). They are responsible for performing CRUD operations (Create, Read, Update, Delete), and typically work with entities and DTOs (Data Transfer Objects).

  | Feature                     | `@Component`                                         | `@Service`                                                                                 | `@Repository`                                                                                        |
  |-----------------------------|------------------------------------------------------|--------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------|
  | **Purpose**                 | General-purpose annotation for any Spring bean.      | Specializes the bean to indicate that it holds business logic or services.                 | Specializes the bean to indicate that it handles data access and persistence logic.                  |
  | **Use Case**                | For beans that don’t fit into a specific role.       | For classes that contain **business logic** or **service layer functionality**.            | For classes that manage **data access** and interact with databases or other persistence mechanisms. |
  | **Semantic Meaning**        | No specific meaning, just a generic component.       | Indicates the class is part of the **service layer** and contains business logic.          | Indicates the class is part of the **data access layer** and handles persistence logic.              |
  | **Functionality**           | Registers the class as a Spring bean.                | Registers the class as a Spring bean but with an implication of business logic handling.   | Registers the class as a Spring bean but with an implication of handling database interactions.      |
  | **Common Practice**         | Used for **any** Spring-managed beans.               | Typically used for **business logic** or **domain services**.                              | Typically used for **data access** (e.g., CRUD operations on entities).                              |
  | **Specialized Annotations** | Does not have specific features beyond `@Component`. | Often combined with annotations like `@Transactional` to manage transactions for services. | Often used with `@Transactional` to manage database transactions and ensure consistency.             |

