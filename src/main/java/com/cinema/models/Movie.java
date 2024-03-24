package com.cinema.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Movie {
    private String id;
    private String title;
    private Set<GENRE> genres;
    private int restrictionAge;
    private int runtime; 

    public enum GENRE {
        ACTION, DRAMA, ROMANCE, COMEDY, ANIMATION
    }

    public Movie() {
        this.genres = new HashSet<>();
        this.id = generateUniqueId();
    }
    
    public Movie(String title, Set<GENRE> genres, int runtime) {
        this.title = title;
        this.genres = genres;
        this.restrictionAge = 0;
        this.runtime = runtime;
        this.id = generateUniqueId();
    }

    public Movie(String title, Set<GENRE> genres, int runtime, int minimumAge) {
        this.title = title;
        this.genres = genres;
        this.restrictionAge = minimumAge;
        this.runtime = runtime;
        this.id = generateUniqueId();
    }
    
    public Movie(Movie movie) {
    	this.title = movie.title;
        this.genres = movie.genres;
        this.restrictionAge = movie.restrictionAge;
        this.id = generateUniqueId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<GENRE> getGenres() {
        return genres;
    }

    public void setGenres(Set<GENRE> genres) {
        this.genres = genres;
    }

    public int getMinimumAge() {
        return restrictionAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.restrictionAge = minimumAge;
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    public int getRestrictionAge() {
		return restrictionAge;
	}

	public void setRestrictionAge(int restrictionAge) {
		this.restrictionAge = restrictionAge;
	}
	
	public double getRuntimeInHours() {
		return runtime / 60.0;
	}

	public int getRuntimeInMinutes() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	@Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genres=" + genres +
                ", minimumAge=" + restrictionAge +
                '}';
    }
}