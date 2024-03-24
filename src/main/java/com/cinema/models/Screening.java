package com.cinema.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.cinema.exceptions.SeatAlreadyTakenException;

public class Screening {
    private String id; // Unique identifier for the screening
    private Auditorium auditorium;
    private Movie movie;
    private Date showtime;
    private int durationInMinutes; // minutes
    
    public Screening() {
    	this.id = this.generateUniqueId(); // Generating a random UUID for the screening
    	this.auditorium = new Auditorium();
    	this.movie = new Movie();
    	this.showtime = new Date();
    	this.durationInMinutes = movie.getRuntimeInMinutes();
    }
    
    public Screening(Auditorium auditorium, Movie movie, Date showtime) {
    	this();
    	this.id = this.generateUniqueId(); // Generating a random UUID for the screening
        this.auditorium = auditorium;
        this.movie = movie;
        this.showtime = showtime;
        this.durationInMinutes = movie.getRuntimeInMinutes();
    }
    
    public Screening(Auditorium auditorium, Movie movie, Date showtime, int duration) {
    	this();
    	this.id = this.generateUniqueId(); // Generating a random UUID for the screening
        this.auditorium = auditorium;
        this.movie = movie;
        this.showtime = showtime;
        this.durationInMinutes = duration;
    }
    
    public void setBooking(List<String> seatIds) throws SeatAlreadyTakenException {
        auditorium.setBooking(seatIds);
    }
    
    public List<Seat> getSeats() {
        return auditorium.getSeats();
    }

    // Getter and setter for ID
    public String getId() {
        return id;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getShowtime() {
        return showtime;
    }

    public void setShowtime(Date showtime) {
        this.showtime = showtime;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
    
    public double getDurationInHours() {
        return durationInMinutes / 60.0;
    }

    public void setDurationInMinutes(int duration) {
        this.durationInMinutes = duration;
    }

    @Override
    public String toString() {
        return "Screening [id=" + id + ", auditorium=" + auditorium + ", movie=" + movie + ", showtime=" + showtime + ", duration=" + durationInMinutes + "]";
    }
    
    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
}