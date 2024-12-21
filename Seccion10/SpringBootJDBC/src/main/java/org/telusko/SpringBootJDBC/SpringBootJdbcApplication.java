package org.telusko.SpringBootJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.telusko.SpringBootJDBC.model.Student;
import org.telusko.SpringBootJDBC.service.StudentService;

import java.util.List;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);

		Student studentA = context.getBean(Student.class);
		studentA.setRollNo(104);
		studentA.setName("Acones");
		studentA.setMarks(78);

		StudentService studentService = context.getBean(StudentService.class);
		studentService.addStudent(studentA);

		List<Student> studentList = studentService.getStudents();
		System.out.println(studentList);

	}

}
