package org.wuestner.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wuestner.models.Director;
import org.wuestner.models.data.DirectorDao;

@Controller
@RequestMapping("director")
public class DirectorController {
	
	@Autowired
	private DirectorDao directorDao;
	
	@RequestMapping(value = "")
	public String home(Model model) {
		model.addAttribute("title", "Home Page");
		
		return "user/home";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addDirector(Model model) {
		model.addAttribute("title", "Add a Director");
		model.addAttribute(new Director());
		
		return "director/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String processDirector(Model model, @ModelAttribute @Valid Director newDirector, Errors errors) {
		if (errors.hasErrors()) {
			model.addAttribute("title", "Add a Director");
			
			return "director/add";
		}
		
		directorDao.save(newDirector);
		
		return "redirect:";
	}

}
