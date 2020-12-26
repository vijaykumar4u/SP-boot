package com.vijay.app.service;

import java.util.List;

import com.vijay.app.model.Student;

public interface StudentService {
public Student add(Student student) ;
public Student update(Student student);
public List<Student> findAll();
public Student findById(int id);
public void deleteById(int id);
}
