package org.medlab.reservation.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

    @Id
    private String id;

    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "passenger_fk")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "flight_instance_fk")
    private FlightInstance flightInstance;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public FlightInstance getFlightInstance() {
        return flightInstance;
    }

    public void setFlightInstance(FlightInstance flightInstance) {
        this.flightInstance = flightInstance;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(totalPrice, that.totalPrice)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(totalPrice)
                .toHashCode();
    }
}
