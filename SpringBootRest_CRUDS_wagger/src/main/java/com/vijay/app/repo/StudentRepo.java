package com.vijay.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vijay.app.model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

	public Student findStudentById(int id);

}
