package com.cinema.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.spring.entity.Genre;
import com.cinema.spring.entity.Movie;
import com.cinema.spring.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    public List<Movie> getAllMovies(String genreName) {
		List<Movie> filteredMovies = new ArrayList<>();
        
        for (Movie movie : movieRepository.findAll()) {
            for (Genre genre : movie.getGenres()) { // Inefficient placeholder solution
            	if (genre.getName().equals(genreName)) {
            		filteredMovies.add(movie);
            		break;
            	}
            }
        }
        
        return filteredMovies;
    }
    
    public List<Movie> getAllMovies(Integer ageRestriction) {
    	List<Movie> filteredMovies = new ArrayList<>();
        
        for (Movie movie : movieRepository.findAll()) {
            if (movie.getRestrictionAge() <= ageRestriction) {
                filteredMovies.add(movie);
            }
        }
        
        return filteredMovies;
    }
    
    public List<Movie> getAllMovies(Integer ageRestriction, String genreName) {
    	List<Movie> filteredMovies = new ArrayList<>();
        
        for (Movie movie : movieRepository.findAll()) {
            if (movie.getRestrictionAge() <= ageRestriction) {
            	for (Genre genre : movie.getGenres()) { // Inefficient placeholder solution
                	if (genre.getName().equals(genreName)) {
                		filteredMovies.add(movie);
                		break;
                	}
                }
            }
        }
        
        return filteredMovies;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Optional<Movie> movieData = movieRepository.findById(id);

        if (movieData.isPresent()) {
            Movie existingMovie = movieData.get();
            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setDescription(updatedMovie.getDescription());
            // Update other fields as needed
            return movieRepository.save(existingMovie);
        } else {
            // Handle not found case
            return null;
        }
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}