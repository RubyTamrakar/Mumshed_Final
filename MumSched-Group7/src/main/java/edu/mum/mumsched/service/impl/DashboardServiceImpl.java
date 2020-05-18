package edu.mum.mumsched.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.mumsched.dao.CourseRepository;
import edu.mum.mumsched.dao.FacultyRepository;
import edu.mum.mumsched.dao.SectionRepository;
import edu.mum.mumsched.dao.StudentRepository;
import edu.mum.mumsched.service.DashboardService;

@Service("dashboardService")
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private FacultyRepository facultyRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private SectionRepository sectionRepository;
	
	@Override
	public Long countStudents() {
		return studentRepository.count();
	}

	@Override
	public Long countFaculties() {
		return facultyRepository.count();
	}

	@Override
	public Long countCourses() {
		return courseRepository.count();
	}

	@Override
	public Long countSections() {
		return sectionRepository.count();
	}

}
