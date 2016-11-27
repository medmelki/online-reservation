package org.medlab.reservation.webservices.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class FlightsResponse {

    private String airline;
    private List<FlightResponse> flights;

    public FlightsResponse(String airline, List<FlightResponse> flights) {
        this.airline = airline;
        this.flights = flights;
    }

    @XmlElement
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @XmlElement
    public List<FlightResponse> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightResponse> flights) {
        this.flights = flights;
    }
}
