package com.cinema.spring.repository;

import com.cinema.spring.entity.Seat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
	List<Seat> findAllByAuditoriumId(Integer auditoriumId);
}