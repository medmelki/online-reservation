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
                "JOIN FETCH fi.flight f JOIN FETCH f.origin a WHERE fi.date <= :d AND a.IATACode = :n");
        return query.setParameter("d", time)
                .setParameter("n", name)
                .getResultList();
    }

    public List getAllFlightsByAirportsSince(String origin, String destination, Long time) {
        Query query = super.entityManager.createQuery("SELECT fi FROM FlightInstance fi " +
                "JOIN FETCH fi.flight f JOIN FETCH f.origin o JOIN FETCH f.destination de " +
                "WHERE fi.date <= :d AND o.IATACode = :n AND de.IATACode = :n2");
        return query.setParameter("d", time)
                .setParameter("n", origin)
                .setParameter("n2", destination)
                .getResultList();
    }
}
