package com.cinema.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private int rowNumber;
	
	@Column(nullable = false)
	private int columnNumber;
	
	
	@ManyToOne()
	@JoinColumn(name = "screening_id", nullable = false)
	private Screening screening;
	
	public Booking() {}

	public Booking(Screening screening, int rowNumber, int columnNumber) {
		this.rowNumber = rowNumber;
		this.columnNumber = columnNumber;
		this.screening = screening;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public int getColumnNumber() {
		return columnNumber;
	}

	public void setColumnNumber(int columnNumber) {
		this.columnNumber = columnNumber;
	}	
	
}
