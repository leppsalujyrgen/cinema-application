package com.cinema.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.spring.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}