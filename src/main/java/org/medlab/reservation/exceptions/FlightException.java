package org.medlab.reservation.exceptions;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlRootElement
public class FlightException {


    private static final long serialVersionUID = 4657020656743160791L;

    private int httpError;

    private int errorCode;

    private String message;

    public FlightException(int httpError, int errorCode, String message) {
        this.httpError = httpError;
        this.errorCode = errorCode;
        this.message = message;
    }

    @XmlElement
    public int getHttpError() {
        return httpError;
    }

    @XmlElement
    public int getErrorCode() {
        return errorCode;
    }

    @XmlElement
    public String getMessage() {
        return message;
    }
}
