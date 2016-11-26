package org.medlab.reservation.dao.impl;


import org.medlab.reservation.dao.PassengerDao;
import org.medlab.reservation.entity.Passenger;
import org.springframework.stereotype.Repository;

@Repository
public class PassengerDaoImpl extends GenericDaoImpl<Passenger, String> implements PassengerDao {

    public PassengerDaoImpl() {
        super(Passenger.class);
    }
}
