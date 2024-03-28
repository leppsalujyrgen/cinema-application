package com.cinema.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.spring.entity.Movie;
import com.cinema.spring.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

  @Autowired
  private final MovieService movieService;
  
  @Autowired
  public MovieController(MovieService movieService) {
      this.movieService = movieService;
  }
  
  @GetMapping()
  public ResponseEntity<List<Movie>> getMovies() {
	  return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
  }
  
  @PostMapping()
  public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
      Movie savedMovie = movieService.createMovie(movie);
      return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Movie> createMovie(@PathVariable Long id) {
      if (movieService.getMovieById(id).isPresent()) {
    	  movieService.deleteMovie(id);
    	  return new ResponseEntity<>(null, HttpStatus.OK);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }
  
  
  /*

  @GetMapping("/tutorials/new")
  public String addTutorial(Model model) {
    Tutorial tutorial = new Tutorial();
    tutorial.setPublished(true);

    model.addAttribute("tutorial", tutorial);
    model.addAttribute("pageTitle", "Create new Tutorial");

    return "tutorial_form";
  }

  @PostMapping("/tutorials/save")
  public String saveTutorial(Tutorial tutorial, RedirectAttributes redirectAttributes) {
    try {
      movieRepository.save(tutorial);

      redirectAttributes.addFlashAttribute("message", "The Tutorial has been saved successfully!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
    }

    return "redirect:/tutorials";
  }

  @GetMapping("/tutorials/{id}")
  public String editTutorial(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
    try {
      Tutorial tutorial = movieRepository.findById(id).get();

      model.addAttribute("tutorial", tutorial);
      model.addAttribute("pageTitle", "Edit Tutorial (ID: " + id + ")");

      return "tutorial_form";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());

      return "redirect:/tutorials";
    }
  }

  @GetMapping("/tutorials/delete/{id}")
  public String deleteTutorial(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
    try {
      movieRepository.deleteById(id);

      redirectAttributes.addFlashAttribute("message", "The Tutorial with id=" + id + " has been deleted successfully!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/tutorials";
  }

  @GetMapping("/tutorials/{id}/published/{status}")
  public String updateTutorialPublishedStatus(@PathVariable("id") Integer id, @PathVariable("status") boolean published,
      Model model, RedirectAttributes redirectAttributes) {
    try {
      movieRepository.updatePublishedStatus(id, published);

      String status = published ? "published" : "disabled";
      String message = "The Tutorial id=" + id + " has been " + status;

      redirectAttributes.addFlashAttribute("message", message);
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/tutorials";
  }
  
  */
}
