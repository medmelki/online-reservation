package org.medlab.reservation.dao.impl;


import org.medlab.reservation.dao.FlightDao;
import org.medlab.reservation.entity.Flight;
import org.springframework.stereotype.Repository;

@Repository
public class FlightDaoImpl extends GenericDaoImpl<Flight, String> implements FlightDao {

    public FlightDaoImpl() {
        super(Flight.class);
    }
}
