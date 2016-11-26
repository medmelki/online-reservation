package org.medlab.reservation.dao.impl;


import org.medlab.reservation.dao.ReservationDao;
import org.medlab.reservation.entity.Reservation;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDaoImpl extends GenericDaoImpl<Reservation, String> implements ReservationDao {

    public ReservationDaoImpl() {
        super(Reservation.class);
    }
}
