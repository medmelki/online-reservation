package org.medlab.reservation.dao;

import org.medlab.reservation.entity.FlightInstance;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightInstanceDao extends GenericDao<FlightInstance, String> {

    List getAllFlightsByAirportSince(String name, Long time);
    List getAllFlightsByAirportsSince(String origin, String destination, Long time);

}
