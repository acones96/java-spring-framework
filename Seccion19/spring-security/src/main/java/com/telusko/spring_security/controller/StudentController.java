package com.telusko.spring_security.controller;

import com.telusko.spring_security.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Acones", "Java"),
            new Student(2, "Navin", "Telusko")
    ));

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    /* CSRF Token
        We were not able to make the post operation using authentication since we need the CSRF token.
    */
    @PostMapping("/students")
    public void addStudent(@RequestBody Student student) {
        students.add(student);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
