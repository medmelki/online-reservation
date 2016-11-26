package org.medlab.reservation.dao;

import org.medlab.reservation.entity.Passenger;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDao extends GenericDao<Passenger, String> {
    
}
