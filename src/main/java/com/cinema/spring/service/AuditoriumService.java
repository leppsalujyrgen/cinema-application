package com.cinema.spring.service;

import com.cinema.spring.entity.Auditorium;
import com.cinema.spring.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditoriumService {

    private final AuditoriumRepository auditoriumRepository;

    @Autowired
    public AuditoriumService(AuditoriumRepository auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }

    public List<Auditorium> getAllAuditoriums() {
        return auditoriumRepository.findAll();
    }

    public Optional<Auditorium> getAuditoriumById(Integer id) {
        return auditoriumRepository.findById(id);
    }

    public Auditorium saveAuditorium(Auditorium auditorium) {
        return auditoriumRepository.save(auditorium);
    }

    public void deleteAuditorium(Integer id) {
        auditoriumRepository.deleteById(id);
    }
}