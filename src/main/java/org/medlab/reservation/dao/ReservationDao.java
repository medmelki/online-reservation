package org.medlab.reservation.dao;

import org.medlab.reservation.entity.Reservation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationDao extends GenericDao<Reservation, String> {

    List findByFlightID(String flightID);
}
