package com.cleantestautomation.assertjdb;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Provides static factory methods that construct date and time
 * related test data.
 */
public class TestDateTimeBuilder {

    private static final DateTimeFormatter LOCAL_DATE_TIME_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private static final DateTimeFormatter UTC_DATE_TIME_FORMAT = DateTimeFormatter.ISO_DATE_TIME;

    /**
     * Prevents instantiation.
     */
    private TestDateTimeBuilder() {}

    /**
     * Transforms the given UTC datetime to a local datetime.
     * @param dateTime The UTC date and time string that uses the ISO date and time format without an offset.
     * @return  The local datetime string.
     */
    public static String transformUTCDateTimeToLocalDateTime(String dateTime) {
        var zonedDateTime = transformUTCStringToZonedDateTime(dateTime);
        return LOCAL_DATE_TIME_FORMAT.format(zonedDateTime);
    }

    private static ZonedDateTime transformUTCStringToZonedDateTime(String dateTime) {
        var utcDateTime = LocalDateTime.from(UTC_DATE_TIME_FORMAT.parse(dateTime));
        var utcZonedDateTime = utcDateTime.atZone(ZoneId.of("UTC"));
        return utcZonedDateTime.withZoneSameInstant(ZoneId.systemDefault());
    }
}
