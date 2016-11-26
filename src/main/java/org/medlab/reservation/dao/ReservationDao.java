package org.medlab.reservation.dao;

import org.medlab.reservation.entity.Reservation;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDao extends GenericDao<Reservation, String> {

}
