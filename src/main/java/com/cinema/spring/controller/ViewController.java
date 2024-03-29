package com.cinema.spring.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinema.spring.entity.Screening;
import com.cinema.spring.service.GenreService;
import com.cinema.spring.service.MovieService;
import com.cinema.spring.service.ScreeningService;

@Controller
public class ViewController {
	
	@Autowired
	private final MovieService movieService;
	
	@Autowired
	private final GenreService genreService;
	
	@Autowired
	private final ScreeningService screeningService;
  
	@Autowired
	public ViewController(MovieService movieService, GenreService genreService, ScreeningService screeningService) {
      this.movieService = movieService;
      this.genreService = genreService;
      this.screeningService = screeningService;
	}
	
	@GetMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("movies", movieService.getAllMovies());
		return "index";
	}
	
	@GetMapping("/schedule")
	public String getMoviesPage(Model model) {
		model.addAttribute("movies", movieService.getAllMovies());
		model.addAttribute("genres", genreService.getAllGenres());
		return "schedule";
	}
	
	@GetMapping("/movies/{id}")
	public String getMovieOverviewPage(@PathVariable Long id, Model model) {
		model.addAttribute("movie", movieService.getMovieById(id).get());
		model.addAttribute("screenings", screeningService.getAllScreeningsByMovieId(id));
		return "movie_overview";
	}
	
	@PostMapping("/movies/screening")
	public String getScreeningPage(@RequestParam("screeningId") Long screeningId) {
		return "redirect:/screenings/" + screeningId;
	}
	
	@GetMapping("/screenings/{id}")
	public String getScreeningPage(@PathVariable("id") Long id, Model model) {
		Optional<Screening> screening = screeningService.getScreeningById(id);
		if (screening.isEmpty()) {
			return "index";
		}
		model.addAttribute("screening", screening.get());
		return "auditorium1";
	}

}
