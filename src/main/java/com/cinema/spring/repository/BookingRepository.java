package com.cinema.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.spring.entity.Booking;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
