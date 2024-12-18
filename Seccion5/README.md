# Java Database Connectivity (JDBC)
JDBC is a Java API that allows Java applications to interact with relational databases. It provides methods to query, update, and manage data in a database from a Java program.

JDBC is part of the Java Standard Edition (Java SE) and serves as a bridge between Java applications and databases.

## JDBC Steps
There are few steps to configure and use JDBC:

1. **Import packages:**

    Import the required classes and interfaces from the `java.sql` package. These provide the tools for establishing connections, executing SQL queries, and processing results.
    ```
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.Statement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    ```
  
2. **Load driver:**

    By loading the specific database driver for the database we are using tells the Java program which database driver to use for communication.
    ```
    Class.forName("com.mysql.cj.jdbc.Driver");
    ```
3. **Register driver:**

    In older versions of Java, we need to explicitly registered the driver with the `DriverManager`, but with modern JDBC versions this is donde automatically when the driver is loaded.
    ```
    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
    ```

4. **Create connection:**

    Use `DriverManager` class to establish a connection to the database. We require the JDBC URL, username and password for the databse.
    ```
    String jdbcURL = "jdbc:mysql://localhost:3306/mydatabase";
    String username = "root";
    String password = "password";
    
    Connection connection = DriverManager.getConnection(jdbcURL, username, password);
    System.out.println("Connection established!");
    ```

5. **Create statement:**

    Use the `Connection` object to create a `Statement` object which is used to execute SQL queries.
    ```
    Statement statement = connection.createStatement();
    ```

6. **Execute statement:**

    Use the `Statement` object to execute SQL queries.

    * For SELECT queries use `executeQuery()` which returns a `ResultSet` object.
    ```
    String query = "SELECT * FROM users";
    ResultSet resultSet = statement.executeQuery(query);
    
    while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        System.out.println("ID: " + id + ", Name: " + name);
    }
    ```
    
   * For INSERT, UPDATE, DELETE use `executeUpdate()` which returns the number of rows affected.

     ```
     String update = "UPDATE users SET name = 'John' WHERE id = 1";
     int rowsAffected = statement.executeUpdate(update);
     System.out.println(rowsAffected + " rows updated.");
     ```

   * Prepared Statements

     Is a feature which allow us to execute parameterized SQL queries efficiently and securely. Unlike regular `Statement` objects, a `PreparedStatement` is precompiled by the database, making it faster for repeated queries and resistant to SQL injection attacks.<br><br>
   
     **Key features:** 
     * **Parameterized Queries.** Use placeholders(`?`) for input parameters instead of hardcoding values directly into the SQL query. This prevents SQL injection by safely handling user inputs.
     * **Precompiled and optimized.** The database compiles the query once, and subsequent executions reuse the compiled query plan, improving performance.
     * **Reusable.** We can execute the same query multiple times with different parameters without recompiling.
     * **Improved readability and maintenance.** Placeholders makes the queries cleaner and easier to maintain.
   <br><br>
   
   **Steps to use it:**
   1. **Create a PreparedStatement**
   
      Use a `Connection` object to create a `PreparedStatement`object.

   ```
    String sql = "SELECT * FROM users WHERE id = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
   ```
   
   2. **Set Parameters**
   
        Replace placeholders(`?`) with actual values using setter methods.
   
   ```
    preparedStatement.setInt(1, 10); // Replace the first "?" with 10
   ```
   
   3. **Execute the Query**
   
      Use appropiate methods depending on the type of SQL query:
   
    * `executeQuery()`. For SELECT queries (returns a `ResultSet`).
    * `executeUpdate()`. For INSERT, UPDATE, or DELETE (returns an integer representing affected rows).
   
   ```
    ResultSet resultSet = preparedStatement.executeQuery();
   ```
   
   4. **Process the Results**

      If the query is a SELECT statement, use the `ResultSet` to retrieve data.

    ```
    while (resultSet.next()) {
      String name = resultSet.getString("name");
      System.out.println("Name: " + name);
    }
   ```
   
    


7. **Close connection**

    Always close resources like `ResultSet`, `Statement`, and `Connection` to free up database resources. We can use `try-finally` or `try-with-resources` to ensure resources are closed properly.

   * Code example:
   ```
    resultSet.close();
    statement.close();
    connection.close();
    System.out.println("Connection closed.");
   ```
   
   * Try-With-Resources:
    ```   
    try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
         Statement statement = connection.createStatement()) {
         String query = "SELECT * FROM users";
         ResultSet resultSet = statement.executeQuery(query);
    
         while (resultSet.next()) {
             System.out.println("User: " + resultSet.getString("name"));
         }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    ```


| **Step**            | **Description**                                                                 | **Key Method/Interface**           |
|----------------------|---------------------------------------------------------------------------------|-------------------------------------|
| 1. Import Packages   | Import necessary classes from `java.sql`.                                       | `import java.sql.*;`               |
| 2. Load Driver       | Load the database-specific JDBC driver.                                         | `Class.forName(driverClassName)`   |
| 3. Register Driver   | Register the driver explicitly (optional for newer versions).                  | `DriverManager.registerDriver()`   |
| 4. Create Connection | Establish a connection to the database.                                        | `DriverManager.getConnection()`    |
| 5. Create Statement  | Create a statement for executing queries.                                      | `connection.createStatement()`     |
| 6. Execute Statement | Execute SQL queries and process the results.                                   | `executeQuery()` or `executeUpdate()` |
| 7. Close Connection  | Close all resources to release the database connection and free resources.      | `close()`                          |


The most important steps in here are: create connection, create statement, execute statement and close connection.

