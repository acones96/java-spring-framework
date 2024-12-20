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

* **@Service**

    It is used to mark a class as a service that golds the business logic for an application. When applied to a class it tells Spring that the class is a service component, and it should be registered as a bean in the Spring application context.

    @Component and @Service behaves the same, the difference lies in their intended use, but in practice, both annotation serve similar functions in terms of creating Spring beans.

  | Feature                     | `@Component`                                         | `@Service`                                                                               |
  |-----------------------------|------------------------------------------------------|------------------------------------------------------------------------------------------|
  | **Purpose**                 | General-purpose annotation for any Spring bean.      | Specializes the bean to indicate that it holds business logic or services.               |
  | **Use Case**                | For beans that don’t fit into a specific role.       | For classes that contain **business logic** or **service layer functionality**.          |
  | **Semantic Meaning**        | No specific meaning, just a generic component.       | Indicates the class is part of the **service layer** and contains business logic.        |
  | **Functionality**           | Registers the class as a Spring bean.                | Registers the class as a Spring bean but with an implication of business logic handling. |
  | **Common Practice**         | Used for **any** Spring-managed beans.               | Typically used for **business logic** or **domain services**.                            |
  | **Specialized Annotations** | Does not have specific features beyond `@Component`. | Often combined with annotations like `@Transactional` to manage transac                  |
