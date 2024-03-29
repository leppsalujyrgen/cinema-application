package com.cinema.spring.controller;

import com.cinema.spring.entity.Auditorium;
import com.cinema.spring.service.AuditoriumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auditoriums")
public class AuditoriumController {

    private final AuditoriumService auditoriumService;

    @Autowired
    public AuditoriumController(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    @GetMapping
    public ResponseEntity<List<Auditorium>> getAllAuditoriums() {
        List<Auditorium> auditoriums = auditoriumService.getAllAuditoriums();
        return new ResponseEntity<>(auditoriums, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auditorium> getAuditoriumById(@PathVariable Integer id) {
        Auditorium auditorium = auditoriumService.getAuditoriumById(id).get();
        return new ResponseEntity<>(auditorium, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Auditorium> createAuditorium(@RequestBody Auditorium auditorium) {
        Auditorium createdAuditorium = auditoriumService.saveAuditorium(auditorium);
        return new ResponseEntity<>(createdAuditorium, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuditorium(@PathVariable Integer id) {
        auditoriumService.deleteAuditorium(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}