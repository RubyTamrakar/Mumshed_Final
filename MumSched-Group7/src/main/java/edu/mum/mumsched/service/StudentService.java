package edu.mum.mumsched.service;

import java.util.List;

import edu.mum.mumsched.model.Student;


public interface StudentService {    
	Student save(Student student);
	Student findOne(Long id);
	void delete(Long id);
	List<Student> findAll();  
	
	Student findByUsername(String userName);
}
