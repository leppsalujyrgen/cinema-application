package com.cinema.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cinema.spring.repository.GenreRepository;
import com.cinema.spring.repository.MovieRepository;

@Controller
public class ViewController {
	
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
    private GenreRepository genreRepository;
	
	@GetMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("movies", movieRepository.findAll());
		return "index";
	}
	
	@GetMapping("/movies")
	public String getMoviesPage(Model model) {
		model.addAttribute("movies", movieRepository.findAll());
		model.addAttribute("genres", genreRepository.findAll());
		return "movies";
	}

}
