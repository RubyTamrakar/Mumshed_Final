package edu.mum.mumsched.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.mumsched.enums.RoleEnum;
import edu.mum.mumsched.model.User;
import edu.mum.mumsched.service.SecurityServices;
import edu.mum.mumsched.service.UserService;
import edu.mum.mumsched.validator.UserValidator;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private SecurityServices securityService;

	@Value("${mumshced.appaddress}")
	private String appAddress;

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView signin(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login/login");
		return modelAndView;
	}	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signup(Model model){
        model.addAttribute("user", new User());
        return "login/signup";
	}	

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, 
    		BindingResult bindingResult, Model model) {

    	userValidator.validate(user, bindingResult);
    	
        if (bindingResult.hasErrors()) {
			model.addAttribute("user", user);
            return "login/signup";			
		}	
		user.setRole(RoleEnum.ROLE_STUDENT);
        userService.save(user);

        securityService.autologin(user.getUsername(), user.getPasswordConfirm());

        return "redirect:/";
    }
}
