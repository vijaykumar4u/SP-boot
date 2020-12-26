package com.vijay.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.app.model.Student;
import com.vijay.app.repo.StudentRepo;
@Service


public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepo studentRepo;
	@Override
	public Student add(Student student) {
		
		return studentRepo.save(student);
	}

	@Override
	public Student update(Student student) {
	
		return studentRepo.save(student);
		
		
	}

	@Override
	public List<Student> findAll() {
		
		return studentRepo.findAll();
	}

	@Override
	public Student findById(int id) {
		return studentRepo.findById(id).get();
		
	}

	@Override
	public void deleteById(int id) {
		studentRepo.deleteById(id);
		
	}

}
