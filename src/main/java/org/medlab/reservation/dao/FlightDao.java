package org.medlab.reservation.dao;

import org.medlab.reservation.entity.Flight;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDao extends GenericDao<Flight, String> {
}
