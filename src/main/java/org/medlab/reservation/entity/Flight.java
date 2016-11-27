package org.medlab.reservation.entity;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "flights")
public class Flight implements Serializable {

    @Id
    private String flightNumber;

    private Integer seats;

    private Integer flightTime;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "airline_fk")
    private Airline airline;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "origin_fk")
    private Airport origin;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "destination_fk")
    private Airport destination;


    public Flight() {
    }

    public Flight(String flightNumber, Integer seats, Integer flightTime) {
        this.flightNumber = flightNumber;
        this.seats = seats;
        this.flightTime = flightTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Integer flightTime) {
        this.flightTime = flightTime;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", seats=" + seats +
                ", flightTime=" + flightTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        return new EqualsBuilder()
                .append(flightNumber, flight.flightNumber)
                .append(seats, flight.seats)
                .append(flightTime, flight.flightTime)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(flightNumber)
                .append(seats)
                .append(flightTime)
                .toHashCode();
    }
}
