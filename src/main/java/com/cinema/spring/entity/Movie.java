package com.cinema.spring.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
    private String title;
	
	@Column()
    private String description;
    
	@ManyToMany
    @JoinTable(
        name = "movie_genre",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
	private Set<Genre> genres;
	
	@Column()
    private int restrictionAge;
	
	@Column(nullable = false)
    private int runtime; 

    public Movie() {
    }
    
    public Movie(String title, String description, Set<Genre> genres, int runtime) {
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.restrictionAge = 0;
        this.runtime = runtime;
    }

    public Movie(String title, Set<Genre> genres, int runtime, int minimumAge) {
        this.title = title;
        this.description = "";
        this.genres = genres;
        this.restrictionAge = minimumAge;
        this.runtime = runtime;
    }
    
    public Movie(Movie movie) {
    	this.title = movie.getTitle();
    	this.description = movie.getDescription();
        this.genres = movie.getGenres();
        this.restrictionAge = movie.getRestrictionAge();
        this.runtime = movie.getRuntime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRuntime() {
		return runtime;
	}

	public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public int getMinimumAge() {
        return restrictionAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.restrictionAge = minimumAge;
    }

    public int getRestrictionAge() {
		return restrictionAge;
	}

	public void setRestrictionAge(int restrictionAge) {
		this.restrictionAge = restrictionAge;
	}

	public int getRuntimeInMinutes() {
		return runtime;
	}

	public void setRuntimeInMinutes(int runtime) {
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