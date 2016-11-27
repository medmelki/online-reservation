package org.medlab.reservation;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.medlab.reservation.dao.FlightInstanceDao;
import org.medlab.reservation.entity.Airport;
import org.medlab.reservation.entity.Flight;
import org.medlab.reservation.entity.FlightInstance;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static io.restassured.RestAssured.given;

public class FlightResourceTest {

    private static ClassPathXmlApplicationContext springAppContext;

    private static FlightInstanceDao flightInstanceDao;

    private FlightInstance flight1;

    @BeforeClass
    public static void setUpClass() throws Exception {
        springAppContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        flightInstanceDao = (FlightInstanceDao) springAppContext.getBean("flightInstanceDaoImpl");

    }

    @Before
    public void setup() {
        Airport airport = new Airport();
        airport.setIATACode("NY");
        airport.setName("NY");

        Flight flight = new Flight();
        flight.setFlightNumber("QE1234");
        flight.setOrigin(airport);

        FlightInstance flightInstance = new FlightInstance();
        flightInstance.setFlightId("00FZ5");
        flightInstance.setAvailableSeats(145);
        flightInstance.setFlight(flight);
        flightInstance.setDate(1480118400000L);

        flight1 = flightInstanceDao.create(flightInstance);

    }

    @Test
    public void testGetAvailableFlightsFromAndSince() {

        given().when().get("api/flights/NY/2016-11-26Z/123").then().statusCode(200);
    }

    @After
    public void tearDown() {
        flightInstanceDao.delete(flight1);
    }

}
