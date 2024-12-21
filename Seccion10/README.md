# Spring JDBC

`JdbcTemplate` is a Spring class that simplifies interaction with relational databases by handling common boilerplate code such as connection management, result set iteration, and exception handling. When working with `H2`, an in-memory or disk-based Java database, JdbcTemplate can be used to perform SQL operations easily.

In this template, we use `update()` when we want to insert, update or delete data. On the other hand, we use `query()` when we want to select/get data

## H2 Database

**H2** is a lightweight, open-source, relational database management system (RDBMS) written in Java. It's known for its fast performance, small footprint, and easy integration with Java applications.

H2 can operate in two primary modes:

1. In-Memory Mode – Data is stored in RAM, and the database disappears when the application stops (perfect for testing).
2. Embedded/Disk Mode – Data is stored persistently on disk, allowing long-term storage.

## Schma.sql
`schema.sql` is a file used in Spring Boot or JDBC-based applications to define and manage the database schema. It contains DDL (Data Definition Language) commands such as `CREATE TABLE`, `ALTER TABLE`, or `DROP TABLE` to automatically create or update the database structure when the application starts.

### How it works
* When the application starts, Spring Boot detects `schema.sql` in the `/resources` folder. 
* Spring executes the SQL statements within this file before the application is fully initialized. 
* If `data.sql` (used to populate tables) exists, it runs after `schema.sql`.

## Connect External Database

We have a file named `application.properties` which is a configuration file used in Spring Boot applications to define application-level settings. It controls how the app behaves by setting values for:

* Database connections
* Logging levels
* Security
* Server ports
* Custom application variables

Spring Boot automatically loads this file at startup, applying the configurations to the app context.