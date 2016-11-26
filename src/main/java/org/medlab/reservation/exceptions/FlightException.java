package org.medlab.reservation.exceptions;

public class FlightException extends Exception {


    private static final long serialVersionUID = 4657020656743160791L;

    private int httpError;

    private int errorCode;

    private String message;

    public FlightException(String message, int httpError, int errorCode) {
        super(message);
        this.httpError = httpError;
        this.errorCode = errorCode;
    }
}
