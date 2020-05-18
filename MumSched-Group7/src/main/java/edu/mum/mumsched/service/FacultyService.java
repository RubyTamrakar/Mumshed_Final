package edu.mum.mumsched.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.mum.mumsched.enums.MonthEnum;
import edu.mum.mumsched.model.Faculty;


public interface FacultyService {    
	Faculty save(Faculty faculty);
	Faculty findOne(Long id);
	void delete(Long id);
	Page<Faculty> findAll(Pageable pageable);  	
	Faculty findByUsername(String userName);	
	

	List<Faculty> findAll();
	List<Faculty> findAllByMonth(MonthEnum month);  
}
