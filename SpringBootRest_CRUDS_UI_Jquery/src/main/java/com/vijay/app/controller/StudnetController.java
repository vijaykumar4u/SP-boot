package com.vijay.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.app.model.Student;
import com.vijay.app.service.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StudnetController {
	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@PostMapping("/add")
	public Student add(@RequestBody Student student) {
		return studentServiceImpl.add(student);
	}

	@PutMapping("/update")
	public Student update(@RequestBody Student student) {
		return studentServiceImpl.update(student);

	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		studentServiceImpl.deleteById(id);
		return "deleted succefully";

	}
	@GetMapping("/find/{id}")
	public Student findById(@PathVariable Integer id) {
		return studentServiceImpl.findById(id);
		
	}
	@GetMapping("/getAll")
	public List<Student> students(){
		return studentServiceImpl.findAll();
		
	}
}
