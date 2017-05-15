package org.wuestner.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wuestner.models.Genre;
import org.wuestner.models.data.GenreDao;

@Controller
@RequestMapping("genre")
public class GenreController {
	
	@Autowired
	private GenreDao genreDao;
	
	@RequestMapping(value = "")
	public String home(Model model) {
		model.addAttribute("title", "Home Page");
		
		return "user/home";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addGenre(Model model) {
		model.addAttribute("title", "Add a Genre");
		model.addAttribute(new Genre());
		
		return "genre/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String processGenre(Model model, @ModelAttribute @Valid Genre newGenre, Errors errors) {
		if (errors.hasErrors()) {
			model.addAttribute("title", "Add a Genre");
			
			return "genre/add";
		}
		
		genreDao.save(newGenre);
		
		return "redirect:";
	}

}

	
