package org.medlab.reservation.util;

import javax.xml.bind.DatatypeConverter;

public class DateUtils {

    public static Long dateStringToLong(String date) {
        if (date != null && !date.isEmpty()) {
            return DatatypeConverter.parseDateTime(date).getTimeInMillis();
        } else {
            return null;
        }
    }
}
