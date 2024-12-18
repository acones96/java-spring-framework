package org.constandse.junitapp.ejemplo;

import java.sql.*; // Import package

public class Main {
    public static void main(String[] args) {
        /* STEPS JDBC
            import package
            load and register
            create connection
            create statement
            execute statement
            process the results
            close
        */

        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "admin";
        String request = "SELECT * FROM student ";

        try {
            Class.forName("org.postgresql.Driver"); // Load JDBC driver (optional)
            Connection connection = DriverManager.getConnection(url, username, password); // Create connection

            System.out.println("**Connection Established**\n");

            Statement statement = connection.createStatement(); // Create statement

            ResultSet response = statement.executeQuery(request); // Execute Query and save statement

            // Response only one row
            System.out.println(response.next()); // Verify if it has a response (null or not)
            String name = response.getString("sname");// Return the value in 'sname' column
            System.out.println("Name of a student is " + name);

            // Response multiple rows
            System.out.println("All data: ");
            while(response.next()) {
                System.out.print(response.getInt(1) + " - ");
                System.out.print(response.getString(2) + " - ");
                System.out.println(response.getInt(3));
            }

            /* CRUD Operations are Create, Read, Update and Delete */

            // Insert
            String sql = "INSERT INTO student VALUES (5, 'David', 48)"; // Query to execute

            statement.execute(sql); // Return a boolean indicating if query performs correctly

            // Update
            sql = "UPDATE student SET sname='Danny' WHERE sid = 5";

            statement.execute(sql);

            // Delete
            sql = "DELETE FROM student WHERE sid = 5";

            statement.execute(sql);

            // Prepare Statements
            sql = "INSERT INTO student VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, 5);
            preparedStatement.setString(2, "Danny");
            preparedStatement.setInt(3, 48);

            preparedStatement.executeUpdate();

            connection.close(); // Close the connection
            System.out.println("\n**Connection Close**");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}