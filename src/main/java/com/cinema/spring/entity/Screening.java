package com.cinema.spring.entity;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "screenings")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
    
    @ManyToOne
    @JoinColumn(name = "auditorium_id", nullable = false)
    private Auditorium auditorium;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;
	
    
    public Screening() {
    }
    
    @Autowired
    public Screening(Movie movie, Auditorium auditorium, LocalDateTime startTime) {
        this.movie = movie;
        this.auditorium = auditorium;
        this.startTime = startTime;
        this.endTime = startTime.plusMinutes(movie.getRuntimeInMinutes());
    }

    public Screening(Movie movie, Auditorium auditorium, LocalDateTime startTime, LocalDateTime endTime) {
        this.movie = movie;
        this.auditorium = auditorium;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

	public Auditorium getAuditorium() {
		return this.auditorium;
	}    
	
	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}
    
	
}
