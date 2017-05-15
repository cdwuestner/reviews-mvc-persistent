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
import org.wuestner.models.Genre;
import org.wuestner.models.Movie;
import org.wuestner.models.data.DirectorDao;
import org.wuestner.models.data.GenreDao;
import org.wuestner.models.data.MovieDao;

@Controller
@RequestMapping("movie")
public class MovieController {
	
	@Autowired
	private MovieDao movieDao;
	
	@Autowired
	private GenreDao genreDao;
	
	@Autowired
	private DirectorDao directorDao;
	
    @RequestMapping(value = "")
    public String home(Model model) {
        model.addAttribute("title", "Home Page");

        return "user/home";
    }
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addMovie(Model model) {
		model.addAttribute("title", "Add a Movie Title");
		model.addAttribute(new Movie());
		model.addAttribute("genres", genreDao.findAll());
		model.addAttribute("directors", directorDao.findAll());
		
		return "movie/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String processMovie(Model model, @ModelAttribute @Valid Movie newMovie, Errors errors, int genreId, int directorId) {
		if (errors.hasErrors()) {
			model.addAttribute("title", "Add a Movie Title");
			return "movie/add";
		}
		Genre g = genreDao.findOne(genreId);
		newMovie.setGenre(g);
		
		Director d = directorDao.findOne(directorId);
		newMovie.setDirector(d);
		
		movieDao.save(newMovie);
		return "redirect:";
	}

}
