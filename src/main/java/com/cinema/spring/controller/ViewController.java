package com.cinema.spring.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinema.spring.entity.Movie;
import com.cinema.spring.entity.Screening;
import com.cinema.spring.entity.Seat;
import com.cinema.spring.service.BookingService;
import com.cinema.spring.service.GenreService;
import com.cinema.spring.service.MovieService;
import com.cinema.spring.service.ScreeningService;
import com.cinema.spring.service.SeatService;

@Controller
public class ViewController {
	
	@Autowired
	private final MovieService movieService;
	
	@Autowired
	private final GenreService genreService;
	
	@Autowired
	private final ScreeningService screeningService;
	
	@Autowired
	private final BookingService bookingService;
	
	@Autowired
	private final SeatService seatService;
  
	@Autowired
	public ViewController(MovieService movieService, GenreService genreService, ScreeningService screeningService, BookingService bookingService, SeatService seatService) {
      this.movieService = movieService;
      this.genreService = genreService;
      this.screeningService = screeningService;
      this.bookingService = bookingService;
      this.seatService = seatService;
	}
	
	@GetMapping("/")
	public String getHomePage(@RequestParam(required = false) String genre, @RequestParam(required = false) Integer ageRestriction, Model model) {
		
		List<Movie> movies;
		if (genre != null && ageRestriction != null) {
            movies = movieService.getAllMovies(ageRestriction, genre);
        } else if (genre != null) {
        	movies = movieService.getAllMovies(genre);
        } else if (ageRestriction != null) {
        	movies = movieService.getAllMovies(ageRestriction);
        } else {
        	movies = movieService.getAllMovies();
        }
		
		model.addAttribute("movies", movies);
		model.addAttribute("genres", genreService.getAllGenres());
		return "index";
	}
	
	@GetMapping("/schedule")
	public String getMoviesPage(Model model) {
		model.addAttribute("screenings", screeningService.getAllScreenings());
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
	

    @PostMapping("/screenings/{id}/seats/book")
    public String receiveSeatNumbers(@PathVariable("id") Long screeningId, @RequestBody Integer[] seatIds, Model model) {
    	Optional<Screening> screening = screeningService.getScreeningById(screeningId);
		if (screening.isEmpty()) {
			return "index";
		}
		
        for (Integer seatId : seatIds) {
        	Optional<Seat> seat = seatService.getSeatById(seatId);
        	if (seat.isEmpty()) {
    			return "index";
    		}
        }
        
        for (Integer seatId : seatIds) {
        	Seat seat = seatService.getSeatById(seatId).get();
        	bookingService.bookSeat(screeningId, seat.getRowNumber(), seat.getColumnNumber());
        }
        
        return "index";
    }

}
