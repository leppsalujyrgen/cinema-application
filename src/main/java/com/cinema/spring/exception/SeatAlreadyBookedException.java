package com.cinema.spring.exception;

@SuppressWarnings("serial")
public class SeatAlreadyBookedException extends Exception {
    private int rowNumber;
    private int columnNumber;

    public SeatAlreadyBookedException(String message, int rowNumber, int columnNumber) {
        super(message);
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }
}