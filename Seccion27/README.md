# Hibernate

Hibernate is an open-source Object-Relational Mapping (ORM) framework for Java, designed to simplify database interactions by mapping Java objects to database tables. It acts as a bridge between the object-oriented world and the relational world of databases reducing the need for manual SQL queries and boilerplate JDBC code.

## Key Features
### Object-Relational Mapping
Maps Java classes to database tables and Java properties to table columns using annotations (@Entity, @Column) or XML configuration. It also supports relationships like OneToOne, OneToMany, ManyToOne, and ManyToMany.

### Hibernate Query Language (HQL)
Provides a database-agnostic query language similar to SQL but operates on Java objects and their properties.

### Automatic SQL Generation
Generates SQL queries at runtime based on the database dialect and reduces manual query writing and ensures portability across databases.

### Lazy and Eager Loading
Supports lazy loading (fetches related data only when needed) and eager loading (fetches data upfront) to optimize performance.

### Caching
Offers first-level cache (session-scoped, automatic) and second-level cache (configurable) to reduce database calls and improve performance.

### Transaction Management
Integrates with Java Transaction API (JTA) or JDBC transactions to ensure data consistency. Supports ACID properties (Atomicity, Consistency, Isolation, Durability).

### Dirty Checking
Automatically detects changes to objects in a session and synchronizes them with the database.

### Database Independence
Uses dialects to support multiple databases.

## Annotations and Properties
There are a few annotations that we can work with.

### Annotation

* `@Embeddable`. Defines a reusable group of attributes that can be included in multiple entities without creating a separate table. The embeddable’s fields are stored as columns in the owning entity’s table.
* `@Entity`. Declares that the class represents an entity whose instances are stored as rows in a database table. Hibernate uses this annotation to manage the class’s lifecycle (e.g., CRUD operations).
* `@Table`. Specifies the table name, schema, catalog, or other table-level attributes (e.g., unique constraints) for the entity. If omitted, Hibernate uses the class name as the table name.
* `@Id`. Identifies the field that uniquely identifies each instance of the entity in the database. Typically used with @GeneratedValue to define key generation strategies (e.g., auto-increment, sequence).
* `@Column`. Specifies column attributes like name, length, nullability, or uniqueness. If omitted, Hibernate uses the field name as the column name.
* `@Transient`. Marks a field as non-persistent, meaning Hibernate ignores it during database operations. Useful for fields that are used in business logic but don’t need to be stored.

### Properties
We can configure the properties of the hibernate configuration in the `hibernate.cfg.xml` file. Here is an example of it and some of the main properties:

```
<hibernate-configuration xmlns="http://www.hibernate.org/xsd/orm/cfg">
    <session-factory>
        <!--
            Tells Hibernate which Java class implements the JDBC driver for the target database (e.g., MySQL, PostgreSQL). This class enables communication between Hibernate and the database.
        -->
        <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
        <!--
            Specifies the database’s location, including the protocol, host, port, and database name. The format depends on the database type.
        -->
        <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/telusko</property>
        <!--
            Specifies the database user account with permissions to access the target database.
        -->
        <property name="hibernate.connection.username">postgres</property>
        <!--
            The password associated with the hibernate.connection.username for authentication.
        -->
        <property name="hibernate.connection.password">admin</property>

        <!--
            Determines how Hibernate manages the database schema based on entity mappings (e.g., @Entity classes). Options include:

            * create: Drops and recreates the schema on startup.
            * update: Updates the schema to match entities without dropping data (not always reliable).
            * validate: Validates the schema against entities without changes.
            * create-drop: Creates the schema on startup and drops it on shutdown.
            * none: No schema changes.
        -->
        <property name="hibernate.hbm2ddl.auto">create</property>

        <!--
            Configuration setting in Hibernate that tells the framework which database dialect to use. A dialect is a class that defines how Hibernate should interact with a specific database
        -->
        <property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>

        <!--
            When set to true, Hibernate outputs all SQL queries to the console or log, aiding debugging.
        -->
        <property name="hibernate.show_sql">true</property>
        <!--
            When set to true and hibernate.show_sql is enabled, Hibernate formats SQL queries with line breaks and indentation.
        -->
        <property name="hibernate.format_sql">true</property>
    </session-factory>
</hibernate-configuration>
```

## Mapping Relationship
Hibernat, as an Object-Relational Mapping (ORM) framework, enables developers to map Java objects to database tables and define relationships between them. These relationships mirror associations in the object-oriented domain and are translated into relational database structures using foreign keys and join tables.

These associations between entities are defined using annotations like `@OneToOne`, `@OneToMany`, `@ManyToOne`, and `@ManyToMany`.

### `@OneToOne` 
**Definition:** A single instance of one entity is associated with exactly one instance of another entity.
**Database Representation:** A foreign key in one table references the primary key of another table, often with a unique constraint.

**Example:**
```
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

**Database:** `User` table has a `profile_id` column (foreign key to `Profile.id`).
**Use Case:** A `User` has one `Profile` (e.g., user settings).

### `@OneToMany`
**Definition:** A single instance of one entity is associated with multiple instances of another entity.
**Database Representation:** The “many” side has a foreign key referencing the “one” side’s primary key.

**Example:**
```
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

**Database:** `Employee` table has a `department_id` column (foreign key to `Department.id`).
**Use Case:** A `Department` has multiple `Employees`.

### `@ManyToOne`
**Definition:** Multiple instances of one entity are associated with a single instance of another entity.
**Database Representation:** The “many” side has a foreign key to the “one” side.

**Example:**
```
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

**Use Case:** Many Employees belong to one Department.

### `@ManyToMany`
**Definition:** Multiple instances of one entity can be associated with multiple instances of another entity.
**Database Representation:** A join table contains foreign keys to both entities’ primary keys.

**Example:**
```
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
**Database Representation:** A `student_course` join table has columns `student_id` and `course_id`.
**Use Case:** A Student can enroll in multiple Courses, and a Course can have multiple Students.

