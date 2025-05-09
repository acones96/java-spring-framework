# Hibernate Study Notes

## Overview
Hibernate is an open-source Object-Relational Mapping (ORM) framework for Java. It simplifies database interactions by mapping Java objects to database tables, reducing the need for manual SQL queries and boilerplate JDBC code.

---

## Key Features
1. **Object-Relational Mapping**: Maps Java classes to database tables and supports relationships like `@OneToOne`, `@OneToMany`, `@ManyToOne`, and `@ManyToMany`.
2. **Hibernate Query Language (HQL)**: Database-agnostic query language operating on Java objects.
3. **Automatic SQL Generation**: Generates SQL queries at runtime based on the database dialect.
4. **Lazy and Eager Loading**: Optimizes performance by controlling when related data is fetched.
   * **Eager Fetching**: Loads the related data immediately when the owning entity is fetched, typically using a single query with joins. Used when we run get method in session.
   * **Lazy Fetching**: Defers loading related data until it is explicitly accessed, fetching it only when needed. Used when we run load or byId methods in session.
5. **Caching**: Supports first-level (session-scoped) and second-level (configurable) caching.
6. **Transaction Management**: Ensures data consistency with JTA or JDBC transactions.
7. **Dirty Checking**: Automatically synchronizes object changes with the database.
8. **Database Independence**: Uses dialects to support multiple databases.

---

## Annotations
1. **`@Embeddable`**: Defines reusable attribute groups stored as columns in the owning entity’s table.
2. **`@Entity`**: Declares a class as an entity managed by Hibernate.
3. **`@Table`**: Specifies table-level attributes like name and schema.
4. **`@Id`**: Marks a field as the primary key.
5. **`@Column`**: Configures column attributes like name and nullability.
6. **`@Transient`**: Excludes a field from persistence.

---

## Hibernate Configuration (`hibernate.cfg.xml`)
- **Connection Properties**:
    - `hibernate.connection.driver_class`: JDBC driver class.
    - `hibernate.connection.url`: Database URL.
    - `hibernate.connection.username`: Database username.
    - `hibernate.connection.password`: Database password.
- **Schema Management**:
    - `hibernate.hbm2ddl.auto`: Options include `create`, `update`, `validate`, `create-drop`, or `none`.
- **Dialect**: Specifies the database dialect (e.g., `PostgreSQLDialect`).
- **SQL Logging**:
    - `hibernate.show_sql`: Logs SQL queries.
    - `hibernate.format_sql`: Formats SQL queries for readability.

---

## Mapping Relationships
### `@OneToOne`
- **Definition**: One entity instance is associated with one instance of another entity.
- **Example**: A `User` has one `Profile`.
```java
  @Entity
  public class User {
      @Id
      @GeneratedValue
      private Long id;
      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name = "profile_id")
      private Profile profile;
  }
  
  @Entity
  public class Profile {
      @Id
      @GeneratedValue
      private Long id;
      private String bio;
  }
```

### `@OneToMany`
- **Definition**: One entity instance is associated with multiple instances of another entity.
- **Example**: A `Department` has multiple `Employees`.
  ```java
    @Entity
    public class Department {
        @Id
        @GeneratedValue
        private Long id;
        @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
        private List<Employee> employees = new ArrayList<>();
    }
    
    @Entity
    public class Employee {
        @Id
        @GeneratedValue
        private Long id;
        @ManyToOne
        @JoinColumn(name = "department_id")
        private Department department;
    }
  ```

### `@ManyToOne`
- **Definition**: Multiple instances of one entity are associated with one instance of another entity.
- **Example**: Many `Employees` belong to one `Department`.
  ```java
    @Entity
    public class Department {
        @Id
        @GeneratedValue
        private Long id;
        @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
        private List<Employee> employees = new ArrayList<>();
    }
    
    @Entity
    public class Employee {
        @Id
        @GeneratedValue
        private Long id;
        @ManyToOne
        @JoinColumn(name = "department_id")
        private Department department;
    }
  ```

### `@ManyToMany`
- **Definition**: Many instances of one entity are associated with many instances of another entity.
- **Example**: A `Student` can enroll in multiple `Courses`, and a `Course` can have multiple `Students`.
  ```java
    @Entity
    public class Student {
        @Id
        @GeneratedValue
        private Long id;
        @ManyToMany(cascade = CascadeType.PERSIST)
        @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
        )
        private List<Course> courses = new ArrayList<>();
    }
    
    @Entity
    public class Course {
        @Id
        @GeneratedValue
        private Long id;
        @ManyToMany(mappedBy = "courses")
        private List<Student> students = new ArrayList<>();
    }
  ```

---

## Example Hibernate Configuration
```xml
<hibernate-configuration xmlns="http://www.hibernate.org/xsd/orm/cfg">
    <session-factory>
        <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
        <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/telusko</property>
        <property name="hibernate.connection.username">postgres</property>
        <property name="hibernate.connection.password">admin</property>
        <property name="hibernate.hbm2ddl.auto">create</property>
        <property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
        <property name="hibernate.show_sql">true</property>
        <property name="hibernate.format_sql">true</property>
    </session-factory>
</hibernate-configuration>
```

