package com.cinema.controllers;

import java.util.Collections;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cinema.exceptions.SeatAlreadyTakenException;
import com.cinema.models.Screening;
import com.cinema.models.Seat;

@RestController
@RequestMapping("/screenings")
public class ScreeningController {
	
	public static Screening screening = new Screening();

    @PostMapping("/{id}/booking")
    public ResponseEntity<String> bookSeats(@PathVariable String id, @RequestBody List<String> seatIds) {
        try {
            // Assuming you have a way to retrieve the screening by ID
            screening.setBooking(seatIds);
            return ResponseEntity.ok("Seats booked successfully.");
        } catch (SeatAlreadyTakenException e) {
            return ResponseEntity.status(409).body("Seat already taken.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}/seats")
    public ResponseEntity<List<Seat>> getSeats(@PathVariable int id) {
        // Assuming you have a way to retrieve the screening by ID
        List<Seat> seats = screening.getSeats();
        return ResponseEntity.ok(seats);
    }
    
    
    @GetMapping("/")
    public ResponseEntity<List<Screening>> getScreenings() {
        // Assuming you have a way to retrieve the screening by ID
        List<Screening> screenings = Collections.singletonList(screening);
        return ResponseEntity.ok(screenings);
    }
    
   
}