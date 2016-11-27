package org.medlab.reservation.webservices;

import org.apache.commons.lang.StringUtils;
import org.medlab.reservation.entity.FlightInstance;
import org.medlab.reservation.entity.Passenger;
import org.medlab.reservation.entity.Reservation;
import org.medlab.reservation.webservices.request.PassengerRequest;
import org.medlab.reservation.webservices.request.ReservationRequest;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReservationRequestRetriever {

    public static Reservation retrieve(ReservationRequest reservationRequest, FlightInstance flight) {

        if (reservationRequest != null) {
            FlightInstance flightInstance = new FlightInstance();
            Reservation reservation = new Reservation();
            reservation.setFlightInstance(flight);
            reservation.setId(UUID.randomUUID().toString());
            reservation.setNumberOfSeats(reservationRequest.getNumberOfSeats());
            if (StringUtils.isNotEmpty(reservationRequest.getReserveeEmail())) {
                reservation.setReserveeEmail(reservationRequest.getReserveeEmail());
            }
            if (StringUtils.isNotEmpty(reservationRequest.getReserveeName())) {
                reservation.setReserveeName(reservationRequest.getReserveeName());
            }
            if (StringUtils.isNotEmpty(reservationRequest.getReserveePhone())) {
                reservation.setReserveePhone(reservationRequest.getReserveePhone());
            }
            if (!CollectionUtils.isEmpty(reservationRequest.getPassengers())) {
                List<Passenger> passengers = new ArrayList<>();
                for (PassengerRequest passengerRequest : reservationRequest.getPassengers()) {
                    Passenger passenger = new Passenger();
                    passenger.setId(UUID.randomUUID().toString());
                    if (passengerRequest.getFirstName() != null) {
                        passenger.setFirstName(passengerRequest.getFirstName());
                    }
                    if (passengerRequest.getLastName() != null) {
                        passenger.setLastName(passengerRequest.getLastName());
                    }
                    passenger.setReservation(reservation);
                    passengers.add(passenger);
                }
                reservation.setPassengers(passengers);
            }
            return reservation;
        } else {
            return null;
        }
    }

}
