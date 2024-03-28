package com.cinema.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(length = 128, nullable = false)
  private String name;

  public Genre() {
  }

  public Genre(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

	@Override
	public String toString() {
		return "Genre [name=" + name + "]";
	}

}
