package org.medlab.reservation.dao;

import org.medlab.reservation.entity.Airline;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineDao extends GenericDao<Airline, String> {

}
