package org.medlab.reservation.dao.impl;


import org.medlab.reservation.dao.AirportDao;
import org.medlab.reservation.entity.Airport;
import org.springframework.stereotype.Repository;

@Repository
public class AirportDaoImpl extends GenericDaoImpl<Airport, String> implements AirportDao {

    public AirportDaoImpl() {
        super(Airport.class);
    }
}
