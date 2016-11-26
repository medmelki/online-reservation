package org.medlab.reservation.dao.impl;


import org.medlab.reservation.dao.FlightDao;
import org.medlab.reservation.entity.Flight;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class FlightInstanceDaoImpl extends GenericDaoImpl<Flight, String> implements FlightDao {

    public FlightInstanceDaoImpl() {
        super(Flight.class);
    }

    public List getAvailableFlightsByAirportSince(String name, Long time, int tickets) {
        Query query = super.entityManager.createQuery("SELECT fi FROM FlightInstance fi " +
                "JOIN FETCH fi.flight f JOIN FETCH f.airport a WHERE fi.date > :d AND a.name = :n");
        return query.setParameter("d", time)
                .setParameter("n", name)
                .getResultList();
    }
}
