package org.medlab.reservation.dao;

import org.medlab.reservation.entity.Flight;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface FlightDao extends GenericDao<Flight, String> {
}
