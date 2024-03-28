package com.cinema.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.spring.entity.Movie;
import com.cinema.spring.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
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