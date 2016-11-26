package org.medlab.reservation.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class IllegalInputException extends WebApplicationException {
    private static final long serialVersionUID = 1L;

    public IllegalInputException() {
        this("Illegal Input", 3);
    }

    public IllegalInputException(String msg, int errorCode) {
        super(Response.status(Response.Status.BAD_REQUEST).entity(
                new FlightException(Response.Status.BAD_REQUEST.getStatusCode(), errorCode, msg)
        ).type("application/json").build());
    }
}
