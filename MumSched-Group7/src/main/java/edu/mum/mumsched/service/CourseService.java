package edu.mum.mumsched.service;

import java.util.List;

import edu.mum.mumsched.model.Course;

public interface CourseService {
	Iterable<Course> getList();
	Course save(Course course);
	Course findOne(Long id);
	Course findOneByCode(String code);
	void delete(Long id);
	List<Course> findAll();
}
