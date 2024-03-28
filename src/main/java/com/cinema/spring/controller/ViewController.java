package com.cinema.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cinema.spring.service.GenreService;
import com.cinema.spring.service.MovieService;

@Controller
public class ViewController {
	
	@Autowired
	private final MovieService movieService;
	
	@Autowired
	private final GenreService genreService;
  
	@Autowired
	public ViewController(MovieService movieService, GenreService genreService) {
      this.movieService = movieService;
      this.genreService = genreService;
	}
	
	@GetMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("movies", movieService.getAllMovies());
		return "index";
	}
	
	@GetMapping("/movies")
	public String getMoviesPage(Model model) {
		model.addAttribute("movies", movieService.getAllMovies());
		model.addAttribute("genres", genreService.getAllGenres());
		return "movies";
	}

}
