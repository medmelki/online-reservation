package org.medlab.reservation.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class UnknownErrorException extends WebApplicationException {
    private static final long serialVersionUID = 1L;

    public UnknownErrorException() {
        this("Unknown error", 4);
    }

    public UnknownErrorException(String msg, int errorCode) {
        super(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
                new FlightException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), errorCode, msg)
        ).type("application/json").build());
    }
}
