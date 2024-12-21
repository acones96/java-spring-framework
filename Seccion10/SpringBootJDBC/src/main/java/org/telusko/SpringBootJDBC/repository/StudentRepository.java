package org.telusko.SpringBootJDBC.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.telusko.SpringBootJDBC.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbc;

    public void save(Student student) {
        String sql = "INSERT INTO student (rollno, name, marks) VALUES (?, ?, ?)";
        int rows = jdbc.update(sql, student.getRollNo(), student.getName(), student.getMarks()); // We use update when we insert, update or delete data. On the other hand, we use query when we want to select/get data

        System.out.println("Student Added!");
        System.out.println(rows + " effected");
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM student";

        RowMapper<Student> mapper = (rs, rowNum) -> {
            Student student = new Student();
            student.setRollNo(rs.getInt("rollno"));
            student.setName(rs.getString("name"));
            student.setMarks(rs.getInt("marks"));

            return student;
        };

        return jdbc.query(sql, mapper);

        /*
            We can reduce even more the code as follows:

                return jdbc.query(sql, (rs, rowNum) -> {
                    Student student = new Student();
                    student.setRollNo(rs.getInt("rollno"));
                    student.setName(rs.getString("name"));
                    student.setMarks(rs.getInt("marks"));

                    return student;
                });
        */
    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
}
