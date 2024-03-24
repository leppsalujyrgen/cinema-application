package com.cinema.models;

import com.cinema.exceptions.SeatAlreadyTakenException;

public class Seat {
	
	public enum TYPE {
		REGULAR, VIP
	}
	
	private String id;
	private Seat.TYPE type;
	private int row;
	private int column;
	private String bookingId;
	private double price;
	
	public Seat() {}
	
	public Seat(String id, double price) {
		this.id = id;
		this.type = Seat.TYPE.REGULAR;
		this.price = price;
	}
	
	public Seat(String id, Seat.TYPE type,double price) {
		this.id = id;
		this.type = type;
		this.price = price;
	}
	
	public Seat.TYPE getType() {
		return type;
	}

	public void setType(Seat.TYPE type) {
		this.type = type;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setBooking(String bookingId) throws SeatAlreadyTakenException {
		if (this.isBooked()) {
			throw new SeatAlreadyTakenException("Seat " +this.getId()+ "is already booked!");
		}
		this.bookingId = bookingId;
	}
	
	public String getBooking() {
		return this.bookingId;
	}
	
	public void deleteBooking() {
		this.bookingId = null;
	}
	
	public boolean isBooked() {
		return this.bookingId != null;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
    public String toString() {
        return "Seat{" +
                "bookingId='" + bookingId + '\'' +
                ", price=" + price +
                '}';
    }

}
