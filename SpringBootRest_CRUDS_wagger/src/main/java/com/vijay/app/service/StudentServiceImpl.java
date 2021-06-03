package com.vijay.app.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.app.exception.StudentNameNotFoundException;
import com.vijay.app.exception.StudentRecordNotFoundException;
import com.vijay.app.model.Student;
import com.vijay.app.repo.StudentRepo;

@Service

public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student add(Student student) {

		return studentRepo.save(student);
	}

	@Override
	public Student update(Student student) {
		Student student2 = studentRepo.save(student);
		System.out.println("save student "+student2);
		return student2;

	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> listStudents = studentRepo.findAll();
		 System.out.println("list of studnets "+listStudents);// for testing junit weather it is hitting
		// the db or returning the mocked data
		return listStudents;
		// return studentRepo.findAll();
	}

	@Override
	public Student findById(int id) {
		Student student = null;
		try {
			student = studentRepo.findStudentById(id);
			System.out.println("find by id "+student);// testing unit
			if (student.getFname() == null || student.getLname() == null) {
				throw new StudentNameNotFoundException("No vailid name for this record");
			}

		} catch (NoSuchElementException e) {
			throw new StudentRecordNotFoundException("No Record Found Exception");
		}
		return student;

	}

	@Override
	public void deleteById(int id) {
		studentRepo.deleteById(id);

	}

}
