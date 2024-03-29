package com.cinema.spring.controller;

import com.cinema.spring.entity.Seat;
import com.cinema.spring.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seats = seatService.getAllSeats();
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }
    
    @GetMapping("/auditorium/{id}")
    public ResponseEntity<List<Seat>> getSeatByAuditoriumId(@PathVariable Integer id) {
        List<Seat> seats = seatService.getAllSeatsByAuditoriumId(id);
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }
    

    @PostMapping()
    public ResponseEntity<Seat> createSeat(@RequestBody Seat seat) {
        Seat createdSeat = seatService.saveSeat(seat);
        return new ResponseEntity<>(createdSeat, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Integer id) {
        seatService.deleteSeat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}