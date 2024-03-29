package com.cinema.spring.controller;

import com.cinema.spring.entity.Screening;
import com.cinema.spring.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {

    private final ScreeningService screeningService;

    @Autowired
    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @GetMapping
    public ResponseEntity<List<Screening>> getAllScreenings() {
        List<Screening> screenings = screeningService.getAllScreenings();
        return new ResponseEntity<>(screenings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screening> getScreeningById(@PathVariable Long id) {
        Optional<Screening> screeningOptional = screeningService.getScreeningById(id);
        return screeningOptional.map(screening -> new ResponseEntity<>(screening, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Screening> createScreening(@RequestBody Screening screening) {
        Screening createdScreening = screeningService.createScreening(screening);
        return new ResponseEntity<>(createdScreening, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScreening(@PathVariable Long id) {
        screeningService.deleteScreening(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
