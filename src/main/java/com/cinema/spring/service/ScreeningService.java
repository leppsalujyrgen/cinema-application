package com.cinema.spring.service;

import com.cinema.spring.entity.Genre;
import com.cinema.spring.entity.Movie;
import com.cinema.spring.entity.Screening;
import com.cinema.spring.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScreeningService {

    private final ScreeningRepository screeningRepository;

    @Autowired
    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }
    
    public List<Screening> getAllScreenings(String genreName) {
		List<Screening> filteredScreenings = new ArrayList<>();
        
        for (Screening screening : screeningRepository.findAll()) {
        	Movie movie = screening.getMovie();
            for (Genre genre : movie.getGenres()) { // Inefficient placeholder solution
            	if (genre.getName().equals(genreName)) {
            		filteredScreenings.add(screening);
            		break;
            	}
            }
        }
        
        return filteredScreenings;
    }
    
    public List<Screening> getAllScreenings(Integer ageRestriction) {
    	List<Screening> filteredScreenings = new ArrayList<>();
        
        for (Screening screening : screeningRepository.findAll()) {
        	Movie movie = screening.getMovie();
            if (movie.getRestrictionAge() <= ageRestriction) {
            	filteredScreenings.add(screening);
            }
        }
        
        return filteredScreenings;
    }
    
    public List<Screening> getAllScreenings(Integer ageRestriction, String genreName) {
    	List<Screening> filteredScreenings = new ArrayList<>();
        
        for (Screening screening : screeningRepository.findAll()) {
        	Movie movie = screening.getMovie();
            if (movie.getRestrictionAge() <= ageRestriction) {
            	for (Genre genre : movie.getGenres()) { // Inefficient placeholder solution
                	if (genre.getName().equals(genreName)) {
                		filteredScreenings.add(screening);
                		break;
                	}
                }
            }
        }
        
        return filteredScreenings;
    }


    public List<Screening> getAllScreenings() {
        return screeningRepository.findAll();
    }
    
    public List<Screening> getAllScreeningsByMovieId(Long movieId) {
    	return screeningRepository.findAllByMovieId(movieId);
    }

    public Optional<Screening> getScreeningById(Long id) {
        return screeningRepository.findById(id);
    }

    public Screening createScreening(Screening screening) {
        return screeningRepository.save(screening);
    }

    public void deleteScreening(Long id) {
        screeningRepository.deleteById(id);
    }
    
}