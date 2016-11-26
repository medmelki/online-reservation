package org.medlab.reservation;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.medlab.reservation.webservices.FlightResource;


public class JsonApplication extends ResourceConfig {

    public JsonApplication(){
        super(
                FlightResource.class,
                JacksonFeature.class
        );
    }

}
