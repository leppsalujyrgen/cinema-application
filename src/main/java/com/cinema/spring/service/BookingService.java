package com.cinema.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cinema.spring.entity.Auditorium;
import com.cinema.spring.entity.Booking;
import com.cinema.spring.entity.Screening;
import com.cinema.spring.entity.Seat;
import com.cinema.spring.repository.BookingRepository;

public class BookingService {
	
	private final ScreeningService screeningService;
	private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(ScreeningService screeningService, BookingRepository bookingRepository) {
        this.screeningService = screeningService;
        this.bookingRepository = bookingRepository;
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
        for (Seat seat : auditorium.getSeats()) {
        	if ((seat.getRowNumber() == rowNumber) && (seat.getColumnNumber() == columnNumber)) {
        		return true;
        	}
        }
    	return false;
    }

    private boolean seatDoubleBooked(Screening screening, int rowNumber, int columnNumber) {
    	for (Booking booking : screening.getBookings()) {
        	if ((booking.getRowNumber() == rowNumber) && (booking.getColumnNumber() == columnNumber)) {
        		return true;
        	}
        }
    	return true;
    }

}
