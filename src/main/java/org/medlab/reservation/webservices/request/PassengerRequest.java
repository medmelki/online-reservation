package org.medlab.reservation.webservices.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PassengerRequest {

    private String firstName;
    private String lastName;

    public PassengerRequest() {
    }

    public PassengerRequest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = firstName;
    }

    @XmlElement
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
