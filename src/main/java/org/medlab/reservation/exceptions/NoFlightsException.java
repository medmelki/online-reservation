package org.medlab.reservation.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class NoFlightsException extends WebApplicationException {
    private static final long serialVersionUID = 1L;

    public NoFlightsException() {
        this("No Flights", 1);
    }

    public NoFlightsException(String msg, int errorCode) {
        super(Response.status(Response.Status.NOT_FOUND).entity(
                new FlightException(Response.Status.NOT_FOUND.getStatusCode(), errorCode, msg)
        ).type("application/json").build());
    }
}
