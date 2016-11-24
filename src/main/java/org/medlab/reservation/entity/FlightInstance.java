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
@Table(name = "flight_instances")
public class FlightInstance implements Serializable {

    @Id
    private String flightId;

    private Long date;

    private Integer availableSeats;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "flight_fk")
    private Flight flight;

    public FlightInstance() {
    }

    public FlightInstance(String flightId, Long date, Integer availableSeats, Double price) {
        this.flightId = flightId;
        this.date = date;
        this.availableSeats = availableSeats;
        this.price = price;
    }

    @Override
    public String toString() {
        return "FlightInstance{" +
                "flightId='" + flightId + '\'' +
                ", date=" + date +
                ", availableSeats=" + availableSeats +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        FlightInstance that = (FlightInstance) o;

        return new EqualsBuilder()
                .append(flightId, that.flightId)
                .append(date, that.date)
                .append(availableSeats, that.availableSeats)
                .append(price, that.price)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(flightId)
                .append(date)
                .append(availableSeats)
                .append(price)
                .toHashCode();
    }
}
