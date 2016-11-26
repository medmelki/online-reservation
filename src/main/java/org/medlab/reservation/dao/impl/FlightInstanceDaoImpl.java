package org.medlab.reservation.dao.impl;


import org.medlab.reservation.dao.FlightInstanceDao;
import org.medlab.reservation.entity.FlightInstance;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class FlightInstanceDaoImpl extends GenericDaoImpl<FlightInstance, String> implements FlightInstanceDao {

    public FlightInstanceDaoImpl() {
        super(FlightInstance.class);
    }

    public List getAllFlightsByAirportSince(String name, Long time) {
        Query query = super.entityManager.createQuery("SELECT fi FROM FlightInstance fi " +
                "JOIN FETCH fi.flight f JOIN FETCH f.airport a WHERE fi.date <= :d AND a.name = :n");
        return query.setParameter("d", time)
                .setParameter("n", name)
                .getResultList();
    }
}
