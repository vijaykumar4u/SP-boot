package com.vijay.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.app.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
