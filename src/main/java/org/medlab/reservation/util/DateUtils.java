package org.medlab.reservation.util;

import javax.xml.bind.DatatypeConverter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    public static Long dateStringToLong(String date) {
        if (date != null && !date.isEmpty()) {
            return DatatypeConverter.parseDateTime(date).getTimeInMillis();
        } else {
            return null;
        }
    }

    public static String longDateToString(Long date) {
        if (date != null) {
            TimeZone tz = TimeZone.getTimeZone("UTC");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
            df.setTimeZone(tz);
            return df.format(new Date(date));
        } else {
            return null;
        }
    }
}
