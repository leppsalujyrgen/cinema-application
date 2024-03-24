package com.cinema.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cinema.exceptions.SeatAlreadyTakenException;
import com.cinema.models.Auditorium;
import com.cinema.models.Seat;

@RestController
@RequestMapping("/auditorium")
public class AuditoriumController {

    public final Auditorium auditorium;

    public AuditoriumController() {
        // Initialize the auditorium (assuming some data)
        this.auditorium = new Auditorium(1, "Auditorium 1");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auditorium> getAuditoriumById(@PathVariable int id) {
        if (id != auditorium.getId()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(auditorium);
    }
    
    @GetMapping("/{id}/seats")
    public ResponseEntity<List<Seat>> getSeats(@PathVariable int id) {
        if (id != auditorium.getId()) {
            return ResponseEntity.notFound().build();
        }
        List<Seat> seats = auditorium.getSeats();
        return ResponseEntity.ok(seats);
    }

    @PostMapping("/{id}/booking")
    public ResponseEntity<String> bookSeats(@PathVariable int id, @RequestBody List<String> seatIds) {
        try {
            String bookingId = auditorium.setBooking(seatIds);
            return ResponseEntity.ok(bookingId);
        } catch (SeatAlreadyTakenException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}