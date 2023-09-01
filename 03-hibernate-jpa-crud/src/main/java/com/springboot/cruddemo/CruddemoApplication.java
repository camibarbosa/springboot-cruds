package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.StudentDAO;
import com.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO)

			createMultipleStudent(studentDAO);

			//readStudent(studentDAO);

			//queryForStudent(studentDAO);

			//queryForStudentByLastName(studentDAO);

			updateStudent(studentDAO);

			deleteStudent(studentDAO);

			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();

		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: pk
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Seungmin"
		System.out.println("Updating student");
		myStudent.setFirstName("Seungmin");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		// get list of students
		List<Student> theStudents = studentDAO.findByLastName("wang");

		// display list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void queryForStudent(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student...");
		Student tempStudent = new Student("Jackson", "Wang", "jacksonwang@gmail.com");
		// save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);
		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);
		//display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		//create the multiple student
		System.out.println("Creating 3 students objects...");
		Student tempStudent1 = new Student("Christopher","Bahng", "bangchan@gmail.com");
		Student tempStudent2 = new Student("Seo","Changbin", "seobin@gmail.com");
		Student tempStudent3 = new Student("Lee","Know", "leeknow@gmail.com");

		//save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Christopher","Bahng", "bangchan@gmail.com");

		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
