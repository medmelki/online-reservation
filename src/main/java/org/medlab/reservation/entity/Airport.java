package org.medlab.reservation.entity;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "airports")
public class Airport implements Serializable {

    @Id
    private String IATACode;

    private String timeZone;

    private String name;

    private String country;

    private String city;

    public Airport() {
    }

    public Airport(String IATACode, String timeZone, String name, String country, String city) {
        this.IATACode = IATACode;
        this.timeZone = timeZone;
        this.name = name;
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "IATACode='" + IATACode + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        return new EqualsBuilder()
                .append(IATACode, airport.IATACode)
                .append(timeZone, airport.timeZone)
                .append(name, airport.name)
                .append(country, airport.country)
                .append(city, airport.city)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(IATACode)
                .append(timeZone)
                .append(name)
                .append(country)
                .append(city)
                .toHashCode();
    }
}
