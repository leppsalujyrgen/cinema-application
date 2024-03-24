package com.cinema.exceptions;

@SuppressWarnings("serial")
public class SeatAlreadyTakenException extends Exception {
    public SeatAlreadyTakenException(String message) {
        super(message);
    }
}