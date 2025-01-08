package com.telusko.spring_data_jpa_example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
/* @Entity
    An annotation in Java (specifically in JPA – Java Persistence API) marks a class as a persistent entity, meaning it's mapped to a database table. Essentially, this tells JPA that the class represents a table in the database, and each instance of the class is a row in that table. It makes easy to create and manage database tables using plain Java classes, following the ORM approach.
*/
@Entity
public class Student {
    /* @Id
        Marks a field as the primary key for an entity. This field uniquely identifies each record (or row) in the database table associated with the entity class. Without @Id, JPA won't know which field to use as the table's primary key, and the entity won't be valid.
    */
    @Id
    private int rollNo;
    private String name;
    private int marks;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
