package org.medlab.reservation.webservices;

import org.apache.commons.lang.StringUtils;
import org.medlab.reservation.dao.FlightInstanceDao;
import org.medlab.reservation.dao.PassengerDao;
import org.medlab.reservation.dao.ReservationDao;
import org.medlab.reservation.entity.FlightInstance;
import org.medlab.reservation.entity.Reservation;
import org.medlab.reservation.exceptions.IllegalInputException;
import org.medlab.reservation.exceptions.NoFlightsException;
import org.medlab.reservation.exceptions.NoTicketsException;
import org.medlab.reservation.exceptions.UnknownErrorException;
import org.medlab.reservation.webservices.request.ReservationRequest;
import org.medlab.reservation.webservices.response.ReservationResponse;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/reservation")
public class ReservationResource {


    @Autowired
    PassengerDao passengerDao;

    @Autowired
    ReservationDao reservationDao;

    @Autowired
    FlightInstanceDao flightInstanceDao;


    @POST
    @Path("{flightId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response saveReservation(ReservationRequest reservation, @PathParam("flightId") String flightId) {

        if (StringUtils.isEmpty(flightId) || reservation == null
                || StringUtils.isEmpty(reservation.getFlightID())
                || reservation.getNumberOfSeats() <= 0) {
            throw new IllegalInputException();
        }
        Reservation reservationResult = null;
        FlightInstance flightInstance = null;
        try {
            flightInstance = flightInstanceDao.read(reservation.getFlightID());
        } catch (Exception e) {
            throw new NoFlightsException();
        }
        if (flightInstance == null) {
            throw new NoFlightsException();
        }
        if (flightInstance.getAvailableSeats() < reservation.getNumberOfSeats()) {
            throw new NoTicketsException();
        }
        try {
            Reservation reservationInstance = ReservationRequestRetriever.retrieve(reservation, flightInstance);
            reservationResult = reservationDao.create(reservationInstance);
        } catch (Exception e) {
            throw new UnknownErrorException();
        }
        return Response.status(200).entity(new ReservationResponse(reservationResult)).build();
    }
}
