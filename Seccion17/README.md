# Spring Data Rest

Spring Data REST is a module in the Spring ecosystem that helps expose your data repository as RESTful web services automatically, without writing explicit controller code. It builds on top of Spring Data and uses Spring MVC to provide a set of endpoints for managing and querying your data.

## Key Concepts

* Automatic REST API Creation

    Spring Data REST works with Spring Data repositories (e.g., JpaRepository, MongoRepository) to automatically expose CRUD operations as RESTful endpoints.

    ```
    @Repository
    public interface EmployeeRepository extends JpaRepository<Employee, Long> {
        List<Employee> findByDepartment(String department);
    }
    ```

    Without any additional code, this repository is exposed as RESTful endpoints, such as:

    * `GET /employees` - List all employees. 
    * `GET /employees/{id}` - Get details of an employee by ID.
    * `POST /employees` - Add a new employee.
    * `PUT /employees/{id}` - Update an existing employee.
    * `DELETE /employees/{id}` - Delete an employee.
    * `GET /employees/search/findByDepartment?department=Sales` - Query employees by department.

* Base Endpoints

  Spring Data REST exposes a default set of RESTful endpoints:

    * **Collection resource:** Handles the entire collection of entities.
      * `GET /{resource}`: List all entities (e.g., /employees).
      * `POST /{resource}`: Add a new entity.
    * **Item resource:** Handles operations on a single entity.
      * `GET /{resource}/{id}`: Retrieve a specific entity.
      * `PUT /{resource}/{id}`: Update an entity.
      * `DELETE /{resource}/{id}`: Delete an entity.
    * **Search resource:** Queries defined in the repository using Spring Data query methods.
      * `GET /{resource}/search`: Lists available query methods.
      * `GET /{resource}/search/{methodName}`: Executes a query method.