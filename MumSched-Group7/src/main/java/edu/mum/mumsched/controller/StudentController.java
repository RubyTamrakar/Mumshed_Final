package edu.mum.mumsched.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.mumsched.model.Student;
import edu.mum.mumsched.service.EntryService;
import edu.mum.mumsched.service.StudentService;
import edu.mum.mumsched.validator.UserValidator;


@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private EntryService entryService;

	@RequestMapping(value = "/studentprofile", method = RequestMethod.GET)
	public String studentProfile(Model model, Pageable pageable, Principal currentUser) {
		Student student =  studentService.findByUsername(currentUser.getName());
		model.addAttribute("student", student);
		model.addAttribute("entries", entryService.getList());
		model.addAttribute("sections", student.getSectionList());
		return "student/studentForm";
	}

	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public String adminProfile(@ModelAttribute("student") Student student, BindingResult result, Principal currentUser,
			Model model) {
		userValidator.validateStuden(student.getUser(), result);

        if (result.hasErrors()) {
        	Student studentDB = studentService.findOne(student.getId());        	
        	student.setSectionList(studentDB.getSectionList());
    		model.addAttribute("entries", entryService.getList());
			model.addAttribute("student", student);
			return "student/studentForm";
		}
		
		Student studentDB = studentService.findOne(student.getId());
		studentDB.getUser().setFirstName(student.getUser().getFirstName());
		studentDB.getUser().setLastName(student.getUser().getLastName());
		studentDB.getUser().setPasswordConfirm(student.getUser().getPasswordConfirm());
		studentDB.setEntry(student.getEntry());
		studentService.save(studentDB);
		return "redirect:/studentprofile";
	}
}
