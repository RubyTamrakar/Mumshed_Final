package edu.mum.mumsched.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.mumsched.model.User;
import edu.mum.mumsched.service.DashboardService;
import edu.mum.mumsched.service.UserService;
import edu.mum.mumsched.view.DashboardView;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
    @Autowired
    private DashboardService dashboardService;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(Principal currentUser, HttpServletRequest request) {     
    	
		ModelAndView modelAndView = new ModelAndView();
		
    	if(currentUser != null)
    	{
			User user = userService.findByUsername(currentUser.getName());		
			modelAndView.addObject("userName", "Welcome " + user.getUsername() + "!");    		
    	}

    	DashboardView dv = new DashboardView();
    	dv.setCountFaculties(dashboardService.countFaculties());
    	dv.setCountStudents(dashboardService.countStudents());
    	dv.setCountCourses(dashboardService.countCourses());
    	dv.setCountSections(dashboardService.countSections());
    	

		modelAndView.addObject("dashboard", dv);    
		modelAndView.setViewName("home/index");
		return modelAndView;
    }
}
