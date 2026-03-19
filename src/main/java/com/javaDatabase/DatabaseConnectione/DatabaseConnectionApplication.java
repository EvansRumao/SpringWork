package com.javaDatabase.DatabaseConnectione;

import com.javaDatabase.DatabaseConnectione.ser.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DatabaseConnectionApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(DatabaseConnectionApplication.class, args);
		System.out.println("hey there ");

		Student s = context.getBean(Student.class);
		s.setRollNo(106);
		s.setName("ramesh");

		s.setMarks(93);


		StudentService ser=context.getBean(StudentService.class);

		ser.addStudent(s);


		List<Student> student=ser.getStudents();

		System.out.println(student);



	}

}
