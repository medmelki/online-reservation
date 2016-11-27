package org.medlab.reservation.webservices.response;

import org.apache.commons.lang.StringUtils;
import org.medlab.reservation.entity.Passenger;
import org.medlab.reservation.entity.Reservation;
import org.medlab.reservation.util.DateUtils;
import org.medlab.reservation.webservices.request.PassengerRequest;
import org.springframework.util.CollectionUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ReservationResponse {

    private String flightNumber = "";
    private String origin = "";
    private String destination = "";
    private String date = "";
    private int flightTime;
    private int numberOfSeats;
    private String reserveeName = "";
    private List<PassengerRequest> passengers = new ArrayList<>();

    public ReservationResponse(Reservation reservation) {
        if (reservation.getFlightInstance() != null) {
            if (reservation.getFlightInstance().getFlight() != null) {
                if (StringUtils.isNotEmpty(reservation.getFlightInstance().getFlight().getFlightNumber())) {
                    this.flightNumber = reservation.getFlightInstance().getFlight().getFlightNumber();
                }
                if (reservation.getFlightInstance().getFlight().getOrigin() != null &&
                        StringUtils.isNotEmpty(reservation.getFlightInstance().getFlight().getOrigin().getName())) {
                    this.origin = reservation.getFlightInstance().getFlight().getOrigin().getName();
                }
                if (reservation.getFlightInstance().getFlight().getDestination() != null &&
                        StringUtils.isNotEmpty(reservation.getFlightInstance().getFlight().getDestination().getName())) {
                    this.destination = reservation.getFlightInstance().getFlight().getDestination().getName();
                }
                if (reservation.getFlightInstance().getFlight().getFlightTime() != null) {
                    this.flightTime = reservation.getFlightInstance().getFlight().getFlightTime();
                }
            }
            if (reservation.getFlightInstance().getDate() != null) {
                this.date = DateUtils.longDateToString(reservation.getFlightInstance().getDate());
            }
        }
        this.numberOfSeats = reservation.getNumberOfSeats();
        if (reservation.getReserveeName() != null) {
            this.reserveeName = reservation.getReserveeName();
        }
        if (!CollectionUtils.isEmpty(reservation.getPassengers())) {
            for (Passenger passenger : reservation.getPassengers()) {
                this.passengers.add(new PassengerRequest(passenger.getFirstName(), passenger.getLastName()));
            }
        }
    }

    @XmlElement
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @XmlElement
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @XmlElement
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @XmlElement
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement
    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    @XmlElement
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @XmlElement
    public String getReserveeName() {
        return reserveeName;
    }

    public void setReserveeName(String reserveeName) {
        this.reserveeName = reserveeName;
    }

    @XmlElement
    public List<PassengerRequest> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerRequest> passengers) {
        this.passengers = passengers;
    }
}
