package com.cinema.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {

    public static List<Movie> movies = new ArrayList<>();

    public MovieController() {
        movies.add(new Movie("Inception", new HashSet<>(Arrays.asList(Movie.GENRE.ACTION, Movie.GENRE.DRAMA)), 180));
        movies.add(new Movie("The Notebook", new HashSet<>(Arrays.asList(Movie.GENRE.ROMANCE, Movie.GENRE.DRAMA)), 120, 16));
        movies.add(new Movie("Paul Mart Mall Cop", new HashSet<>(Arrays.asList(Movie.GENRE.COMEDY)), 90));
        movies.add(new Movie("Ice Age", new HashSet<>(Arrays.asList(Movie.GENRE.ANIMATION)), 100));
    }

    @GetMapping("/")
    public List<Movie> getMovies() {
        return movies;
    }

    @PostMapping("/")
    public Movie addMovie(@RequestBody Movie movie) {
        movies.add(new Movie(movie));
        return movie;
    }

    @PutMapping("/{id}")
    public void updateMovie(@PathVariable String id, @RequestBody Movie movie) {
    	for (int i = 0; i<movies.size(); i++) {
    		if (movies.get(i).getId().equals(id)) {
	            movies.set(i, new Movie(movie));
	            break;
    		}
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable String id) {
    	for (int i = 0; i<movies.size(); i++) {
    		if (movies.get(i).getId().equals(id)) {
	            movies.remove(i);
	            break;
    		}
        }
    }
}
