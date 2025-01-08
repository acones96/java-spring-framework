package com.telusko.spring_data_jpa_example.repository;

import com.telusko.spring_data_jpa_example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    /* Java Persistence Query Language (JPQA)
        JPQL is a query language used in JPA to interact with relational databases through entities instead of tables. It’s similar to SQL but operates on Java objects and their attributes rather than directly on database tables and columns.
    */

    // SELECT {object} FROM {class  alias] WHERE {variable.property}=?{parameterNumber}
//    @Query("SELECT student FROM Student student WHERE student.name=?1") // JPA uses DSL to generate these queries without writing them, but not all the times.
    List<Student> findByName(String name);
    List<Student> findByMarks(int marks);
    List<Student> findByMarksGreaterThan(int marks);
}
