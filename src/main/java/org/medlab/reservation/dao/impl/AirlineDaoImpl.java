package org.medlab.reservation.dao.impl;


import org.medlab.reservation.dao.AirlineDao;
import org.medlab.reservation.entity.Airline;
import org.springframework.stereotype.Repository;

@Repository
public class AirlineDaoImpl extends GenericDaoImpl<Airline, String> implements AirlineDao {

    public AirlineDaoImpl() {
        super(Airline.class);
    }
}
