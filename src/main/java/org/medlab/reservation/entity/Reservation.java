package org.medlab.reservation.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

    @Id
    private String id;

    private Double totalPrice;

    private Integer numberOfSeats;

    private String reserveeName;

    private String reserveePhone;

    private String reserveeEmail;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "flight_instance_fk")
    private FlightInstance flightInstance;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "reservation")
    private List<Passenger> passengers;

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

    public FlightInstance getFlightInstance() {
        return flightInstance;
    }

    public void setFlightInstance(FlightInstance flightInstance) {
        this.flightInstance = flightInstance;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getReserveeName() {
        return reserveeName;
    }

    public void setReserveeName(String reserveeName) {
        this.reserveeName = reserveeName;
    }

    public String getReserveePhone() {
        return reserveePhone;
    }

    public void setReserveePhone(String reserveePhone) {
        this.reserveePhone = reserveePhone;
    }

    public String getReserveeEmail() {
        return reserveeEmail;
    }

    public void setReserveeEmail(String reserveeEmail) {
        this.reserveeEmail = reserveeEmail;
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
