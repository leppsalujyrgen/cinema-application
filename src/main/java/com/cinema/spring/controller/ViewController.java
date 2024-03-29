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

/**
 * Controller class responsible for handling views related to movie scheduling and booking.
 */
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
  
	 /**
     * Constructor for ViewController.
     * @param movieService MovieService instance.
     * @param genreService GenreService instance.
     * @param screeningService ScreeningService instance.
     * @param bookingService BookingService instance.
     * @param seatService SeatService instance.
     */
	@Autowired
	public ViewController(MovieService movieService, GenreService genreService, ScreeningService screeningService, BookingService bookingService, SeatService seatService) {
      this.movieService = movieService;
      this.genreService = genreService;
      this.screeningService = screeningService;
      this.bookingService = bookingService;
      this.seatService = seatService;
	}
	
	/**
     * Retrieves movies for the home page.
     * @param genre Genre of the movie (optional).
     * @param ageRestriction Age restriction of the movie (optional).
     * @param model Model object to add attributes.
     * @return String representing the view name.
     */
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
	
	/**
     * Retrieves screenings for the schedule page.
     * @param genre Genre of the movie (optional).
     * @param ageRestriction Age restriction of the movie (optional).
     * @param model Model object to add attributes.
     * @return String representing the view name.
     */
	@GetMapping("/schedule")
	public String getMoviesPage(@RequestParam(required = false) String genre, @RequestParam(required = false) Integer ageRestriction, Model model) {
		
		List<Screening> screenings;
		if (genre != null && ageRestriction != null) {
			screenings = screeningService.getAllScreenings(ageRestriction, genre);
        } else if (genre != null) {
        	screenings = screeningService.getAllScreenings(genre);
        } else if (ageRestriction != null) {
        	screenings = screeningService.getAllScreenings(ageRestriction);
        } else {
        	screenings = screeningService.getAllScreenings();
        }
		
		model.addAttribute("screenings", screenings);
		model.addAttribute("genres", genreService.getAllGenres());
		return "schedule";
	}
	
	/**
     * Retrieves details of a specific movie.
     * @param id ID of the movie.
     * @param model Model object to add attributes.
     * @return String representing the view name.
     */
	@GetMapping("/movies/{id}")
	public String getMovieOverviewPage(@PathVariable Long id, Model model) {
		model.addAttribute("movie", movieService.getMovieById(id).get());
		model.addAttribute("screenings", screeningService.getAllScreeningsByMovieId(id));
		return "movie_overview";
	}
	
	/**
     * Redirects to the screening page after selecting a movie.
     * @param screeningId ID of the screening.
     * @return String representing the redirect URL.
     */
	@PostMapping("/movies/screening")
	public String getScreeningPage(@RequestParam("screeningId") Long screeningId) {
		return "redirect:/screenings/" + screeningId;
	}
	
	/**
     * Retrieves screenings for the seat selection page.
     * @param id ID of the screening.
     * @param model Model object to add attributes.
     * @return String representing the view name.
     */
	@GetMapping("/screenings/{id}")
	public String getScreeningPage(@PathVariable("id") Long id, Model model) {
		Optional<Screening> screening = screeningService.getScreeningById(id);
		if (screening.isEmpty()) {
			return "index";
		}
		model.addAttribute("screening", screening.get());
		return "auditorium1";
	}
	
	 /**
     * Receives seat numbers and books them for a screening.
     * @param screeningId ID of the screening.
     * @param seatIds Array of seat IDs to be booked.
     * @param model Model object to add attributes.
     * @return String representing the view name.
     */
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
