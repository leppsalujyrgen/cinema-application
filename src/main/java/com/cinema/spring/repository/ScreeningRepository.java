package com.cinema.spring.repository;

import com.cinema.spring.entity.Screening;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
	List<Screening> findAllByMovieId(Long movieId);
}
