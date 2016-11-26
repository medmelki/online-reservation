package org.medlab.reservation.dao;

import org.medlab.reservation.entity.Airport;
import org.medlab.reservation.entity.FlightInstance;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportDao extends GenericDao<Airport, String> {

}
