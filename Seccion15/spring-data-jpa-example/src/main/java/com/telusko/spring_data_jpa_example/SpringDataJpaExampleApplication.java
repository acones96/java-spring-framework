package com.telusko.spring_data_jpa_example;

import com.telusko.spring_data_jpa_example.model.Student;
import com.telusko.spring_data_jpa_example.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaExampleApplication.class, args);

		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		Student studentA = context.getBean(Student.class);
		Student studentB = context.getBean(Student.class);
		Student studentC = context.getBean(Student.class);

		studentA.setRollNo(101);
		studentA.setName("Navin");
		studentA.setMarks(75);

		studentB.setRollNo(102);
		studentB.setName("Kiran");
		studentB.setMarks(80);

		studentC.setRollNo(103);
		studentC.setName("Harsh");
		studentC.setMarks(70);

		studentRepository.save(studentA);
		studentRepository.save(studentB);
		studentRepository.save(studentC);

		// Get all table
		System.out.println("Find all: \n\t" + studentRepository.findAll() + "\n");

		// Fetch one row
		Optional<Student> s = studentRepository.findById(103); // Could return null or Student class
		System.out.println("Find by id: \n\t" + s.orElse(new Student()) + "\n"); // Instead of returning an Optional class, we create a new null Student instance

		// Find by name
		System.out.println("Find by name: \n\t" + studentRepository.findByName("Navin") + "\n");

		// Find by marks
		System.out.println("Find by marks: \n\t" + studentRepository.findByMarks(80) + "\n");

		// Find by marks with condition
		System.out.println("Greater than: \n\t" + studentRepository.findByMarksGreaterThan(72) + "\n");

		// Update a student
		studentB.setRollNo(102);
		studentB.setName("Kiran");
		studentB.setMarks(65);

		studentRepository.save(studentB);
		System.out.println("Update student: \n\t" + studentRepository.findAll() + "\n");

		// Delete a student
		studentRepository.delete(studentB);
		System.out.println("Delete student: \n\t" + studentRepository.findAll() + "\n");



	}

}
