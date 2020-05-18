package edu.mum.mumsched.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.mumsched.dao.CourseRepository;
import edu.mum.mumsched.model.Course;
import edu.mum.mumsched.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public Iterable<Course> getList() {
		return courseRepository.courseList(new Sort("name"));
	}

	@Override
	public Course save(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course findOne(Long id) {
		return courseRepository.findOne(id);
	}

	@Override
	public Course findOneByCode(String code) {
		return courseRepository.findOneByCode(code);
	}
	
	@Override
	public void delete(Long id) {
		courseRepository.delete(id);
	}

	
}
