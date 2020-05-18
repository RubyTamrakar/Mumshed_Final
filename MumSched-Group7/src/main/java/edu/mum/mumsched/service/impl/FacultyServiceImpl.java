package edu.mum.mumsched.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.mum.mumsched.dao.FacultyRepository;
import edu.mum.mumsched.enums.MonthEnum;
import edu.mum.mumsched.model.Faculty;
import edu.mum.mumsched.model.User;
import edu.mum.mumsched.service.FacultyService;
import edu.mum.mumsched.service.UserService;

@Service("facultyService")
public class FacultyServiceImpl  implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private UserService userService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Faculty save(Faculty faculty) {
    	User user = faculty.getUser();    	
    	if(faculty.getId() == null)
    	{
    		user = userService.save(user);
    		faculty.setUser(user);
    	}
    	else {
			if(user.getPasswordConfirm() != null && !user.getPasswordConfirm().isEmpty())
				user.setPassword(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
    	}
    		//userService.setUserPassword(faculty.getUser());
		return facultyRepository.save(faculty);	
    }

	@Override
	public Page<Faculty> findAll(Pageable pageable) {
		return facultyRepository.findAll(pageable);
	}
	
	@Override
	public List<Faculty> findAll() {
		return facultyRepository.findAll();
	}
	
	@Override
	public List<Faculty> findAllByMonth(MonthEnum month) {
		return facultyRepository.findAllByMonth(month);
	}

	@Override
	public Faculty findOne(Long id) {
		return facultyRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		facultyRepository.delete(id);
	}

	@Override
	public Faculty findByUsername(String userName) {
		return facultyRepository.findByUsername(userName);
	}
}
