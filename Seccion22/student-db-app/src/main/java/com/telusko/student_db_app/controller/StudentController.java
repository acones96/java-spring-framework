package com.telusko.student_db_app.controller;

import com.telusko.student_db_app.model.Student;
import com.telusko.student_db_app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @PostMapping("/student")
    public void addStudent(@RequestBody Student student) {

        studentRepository.save(student);
    }
}
