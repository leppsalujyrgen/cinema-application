package com.cinema.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.spring.entity.Genre;
import com.cinema.spring.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Optional<Genre> getGenreById(Integer id) {
        return genreRepository.findById(id);
    }

    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre updateGenre(Integer id, Genre updatedGenre) {
        Optional<Genre> genreData = genreRepository.findById(id);

        if (genreData.isPresent()) {
            Genre existingGenre = genreData.get();
            existingGenre.setName(updatedGenre.getName());
            // Update other fields as needed
            return genreRepository.save(existingGenre);
        } else {
            // Handle not found case
            return null;
        }
    }

    public void deleteGenre(Integer id) {
        genreRepository.deleteById(id);
    }
}