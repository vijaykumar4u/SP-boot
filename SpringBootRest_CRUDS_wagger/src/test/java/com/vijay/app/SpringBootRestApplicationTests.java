package com.vijay.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.vijay.app.model.Student;
import com.vijay.app.repo.StudentRepo;
import com.vijay.app.service.StudentServiceImpl;
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest

class SpringBootRestApplicationTests {
	@Autowired
	private StudentServiceImpl studentService;

	@MockBean
	private StudentRepo repository;

	@Test
	@Order(3)
	public void getAllStudents() {
		when(repository.findAll())
				.thenReturn(Stream.of(new Student(219, "vijay kumar", "Reddy"), new Student(242, "Ravi", "M"))
						.collect(Collectors.toList()));
		assertEquals(2, studentService.getAllStudents().size());
	}

	@Test
	@Order(2)
	public void getStudentById() {
		int id = 218;
		Student student = new Student(19, "red", "chan");
		when(repository.findStudentById(id)).thenReturn(student);
		assertEquals(student, studentService.findById(id));

	}

	@Test
	@Order(1)
	public void saveStudent() {
		Student student = new Student(1, "vivek", "M");
		when(repository.save(student)).thenReturn(student);
		assertEquals(student, studentService.add(student));
		
	}

	@Test
	@Order(4)
	public void deleteById() {
		int id = 1;
		//Student student = new Student(218, "vivek", "M");
		studentService.deleteById(id);
		verify(repository, times(1)).deleteById(id);
	}

}
