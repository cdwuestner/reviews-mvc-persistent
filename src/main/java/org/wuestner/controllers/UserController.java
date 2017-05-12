package org.wuestner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wuestner.models.User;
import org.wuestner.models.data.UserDao;

@Controller
@RequestMapping("")
public class UserController {
	
	@Autowired
	private UserDao userDao;

    @RequestMapping(value = "")
    public String home(Model model) {
        model.addAttribute("title", "Home Page");

        return "user/home";
    }
    
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String displayRegisterForm(Model model) {
    	model.addAttribute("title", "Create Account");
        model.addAttribute(new User());
    	
    	return "user/register";
    }
    
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processRegisterForm(Model model, User newUser) {    	
    	userDao.save(newUser);
    	
    	return "user/home";
    }
    
}