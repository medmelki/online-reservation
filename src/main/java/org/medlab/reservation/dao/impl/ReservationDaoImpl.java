package org.medlab.reservation.dao.impl;


import org.medlab.reservation.dao.ReservationDao;
import org.medlab.reservation.entity.Reservation;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ReservationDaoImpl extends GenericDaoImpl<Reservation, String> implements ReservationDao {

    public ReservationDaoImpl() {
        super(Reservation.class);
    }

    public List findByFlightID(String flightID) {
        Query query = super.entityManager.createQuery("SELECT r FROM Reservation r " +
                "JOIN FETCH r.flightInstance fi WHERE fi.flightId = :id");
        return query.setParameter("id", flightID)
                .getResultList();

    }
}
