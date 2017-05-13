package org.wuestner.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wuestner.models.Movie;
import org.wuestner.models.data.MovieDao;

@Controller
@RequestMapping("movie")
public class MovieController {
	
	@Autowired
	private MovieDao movieDao;
	
    @RequestMapping(value = "")
    public String home(Model model) {
        model.addAttribute("title", "Home Page");

        return "user/home";
    }
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addMovie(Model model) {
		model.addAttribute("title", "Add a Movie Title");
		model.addAttribute(new Movie());
		
		return "movie/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String processMovie(Model model, @ModelAttribute @Valid Movie newMovie, Errors errors) {
		if (errors.hasErrors()) {
			model.addAttribute("title", "Add a Movie Title");
			
			return "movie/add";
		}
		
		movieDao.save(newMovie);
		
		return "redirect:";
	}

}
