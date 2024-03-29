package com.cinema.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.spring.entity.Auditorium;
import com.cinema.spring.entity.Booking;
import com.cinema.spring.entity.Screening;
import com.cinema.spring.entity.Seat;
import com.cinema.spring.repository.BookingRepository;

@Service
public class BookingService {
	
	private final ScreeningService screeningService;
	private final BookingRepository bookingRepository;
	private final SeatService seatService;

    @Autowired
    public BookingService(ScreeningService screeningService, SeatService seatService, BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
        this.screeningService = screeningService;
        this.seatService = seatService;
    }
	
	public Booking bookSeat(Long screeningId, int rowNumber, int columnNumber) {
        Optional<Screening> screening = screeningService.getScreeningById(screeningId);
        if (!screening.isPresent()) {
        	throw new RuntimeException("Screening does not exist");
        }
        
        if (!seatExists(screening.get().getAuditorium(), rowNumber, columnNumber)) {
        	throw new RuntimeException("Seat is not available in the auditorium");
        }
        
        if (!seatDoubleBooked(screening.get(), rowNumber, columnNumber)) {
           throw new RuntimeException("Seat is already booked for this screening");
        }
        
        Booking booking = new Booking(screening.get(), rowNumber, columnNumber);
        bookingRepository.save(booking);
        return booking;
    }
	 
	public void unbookSeat(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
	 

    private boolean seatExists(Auditorium auditorium, int rowNumber, int columnNumber) {
        for (Seat seat : seatService.getAllSeatsByAuditoriumId(auditorium.getId())) {
        	if ((seat.getRowNumber() == rowNumber) && (seat.getColumnNumber() == columnNumber)) {
        		return true;
        	}
        }
    	return false;
    }

    private boolean seatDoubleBooked(Screening screening, int rowNumber, int columnNumber) {
    	for (Booking booking : bookingRepository.findAllByScreeningId(screening.getId())) {
        	if ((booking.getRowNumber() == rowNumber) && (booking.getColumnNumber() == columnNumber)) {
        		return true;
        	}
        }
    	return true;
    }

}
