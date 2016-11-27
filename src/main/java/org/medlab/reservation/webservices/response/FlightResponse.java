package org.medlab.reservation.webservices.response;

import org.medlab.reservation.entity.FlightInstance;
import org.medlab.reservation.util.DateUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FlightResponse {

    private String flightID = "";
    private String flightNumber = "";
    private String date = "";
    private int numberOfSeats;
    private double totalPrice;
    private int travelTime;
    private String origin = "";
    private String destination = "";

    public FlightResponse(String flightID, String flightNumber, String date, int numberOfSeats, double totalPrice, int travelTime, String origin, String destination) {
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.date = date;
        this.numberOfSeats = numberOfSeats;
        this.totalPrice = totalPrice;
        this.travelTime = travelTime;
        this.origin = origin;
        this.destination = destination;
    }

    public FlightResponse(FlightInstance flight) {
        this.flightID = flight.getFlightId();
        if (flight.getDate() != null) {
            this.date = DateUtils.longDateToString(flight.getDate());
        }
        if (flight.getAvailableSeats() != null) {
            this.numberOfSeats = flight.getAvailableSeats();
        }
        if (flight.getPrice() != null) {
            this.totalPrice = flight.getPrice();
        }
        if (flight.getFlight().getFlightTime() != null) {
            this.travelTime = flight.getFlight().getFlightTime();
        }
        if (flight.getFlight() != null) {
            if (flight.getFlight().getFlightNumber() != null) {
                this.flightNumber = flight.getFlight().getFlightNumber();
            }
            if (flight.getFlight().getOrigin() != null
                    && flight.getFlight().getOrigin().getIATACode() != null) {
                this.origin = flight.getFlight().getOrigin().getIATACode();
            }
            if (flight.getFlight().getDestination() != null
                    && flight.getFlight().getDestination().getIATACode() != null) {
                this.destination = flight.getFlight().getDestination().getIATACode();
            }
        }

    }

    @XmlElement
    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    @XmlElement
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @XmlElement
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @XmlElement
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @XmlElement
    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
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
}
