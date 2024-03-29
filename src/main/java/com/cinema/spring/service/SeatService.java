package com.cinema.spring.service;

import com.cinema.spring.entity.Seat;
import com.cinema.spring.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Optional<Seat> getSeatById(Integer id) {
        return seatRepository.findById(id);
    }

    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public void deleteSeat(Integer id) {
        seatRepository.deleteById(id);
    }
    
    public List<Seat> getAllSeatsByAuditoriumId(Integer auditoriumId) {
        return seatRepository.findAllByAuditoriumId(auditoriumId);
    }

}