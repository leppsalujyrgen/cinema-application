package com.cinema.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.cinema.exceptions.SeatAlreadyTakenException;

public class Auditorium {
    
    private int id;
    private String name;
    private Map<String, Seat> seats;

    public Auditorium() {
    	this.id = 0;
        this.name = "Test";
        this.seats = new HashMap<>();
        this.seats.put("1", new Seat("1", 10.5));
        this.seats.put("2", new Seat("2", 10.5));
        this.seats.put("3", new Seat("3", 10.5));
        this.seats.put("4", new Seat("4", 10.5));
        this.seats.put("5", new Seat("5", 10.5));
        this.seats.put("VIP1", new Seat("VIP1", 20.5));
    }
    
    public Auditorium(int id, String name) {
        this.id = id;
        this.name = name;
        this.seats = new HashMap<>();
        this.seats.put("1", new Seat("1", 10.5));
        this.seats.put("2", new Seat("2", 10.5));
        this.seats.put("3", new Seat("3", 10.5));
        this.seats.put("4", new Seat("4", 10.5));
        this.seats.put("5", new Seat("5", 10.5));
        this.seats.put("VIP1", new Seat("VIP1", 20.5));
        
        /*
        for (Seat seat : seats) {
            String seatId = seat.getId();
            seatMap.put(seatId, seat);
        }
        */
    }
    
    public String setBooking(List<String> seatIds) throws SeatAlreadyTakenException {
    	List<Seat> unbookedSeats = this.getSeatsById(seatIds, false);
    	String bookingId = generateUniqueId();
    	for (Seat seat : unbookedSeats) {
    		seat.setBooking(bookingId);
    	}
    	return bookingId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Seat> getSeats() {
        return new ArrayList<Seat>(seats.values());
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seats=" + seats +
                '}';
    }
    
    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
    
    @SuppressWarnings("unused")
	private List<Seat> getSeatsById(List<String> seatIds) {
        return getSeatsById(seatIds, false);
    }

    private List<Seat> getSeatsById(List<String> seatIds, boolean allowBookedSeats) {
        List<Seat> seatsById = new ArrayList<>();
        for (String seatId : seatIds) {
            if (!this.seats.containsKey(seatId)) {
                throw new IllegalArgumentException("This seat does not exist!");
            }
            Seat seat = seats.get(seatId);
            if (!allowBookedSeats && seat.isBooked()) {
                throw new IllegalStateException("Booked seats are not allowed!");
            }
            seatsById.add(seat);
        }
        return seatsById;
    }
}
