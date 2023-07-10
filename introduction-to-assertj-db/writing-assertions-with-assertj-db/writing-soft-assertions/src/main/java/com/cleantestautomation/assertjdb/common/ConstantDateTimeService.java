package com.cleantestautomation.assertjdb.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class returns always the same time. We will use this class when we will
 * write integration tests for our application because it allows us to write
 * assertions for the timestamp columns.
 *
 * @author Petri Kainulainen
 */
public class ConstantDateTimeService implements DateTimeService {

    private static final String CONSTANT_UTC_DATE_TIME = "2023-07-08T13:36:28";
    private static final DateTimeFormatter LOCAL_DATE_TIME_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE_TIME;;
    private static final DateTimeFormatter UTC_DATE_TIME_FORMAT = DateTimeFormatter.ISO_DATE_TIME;
    private static final DateTimeFormatter ZONED_DATE_TIME_FORMAT = DateTimeFormatter.ISO_ZONED_DATE_TIME;

    public static final String CURRENT_LOCAL_DATE_TIME = getConstantDateAndTime();
    public static final String CURRENT_DATE_TIME_WITH_OFFSET_AND_ZONE_ID = getConstantDateAndTimeWithOffsetAndZoneId();

    private static final Logger LOGGER = LoggerFactory.getLogger(ConstantDateTimeService.class);

    private static String getConstantDateAndTime() {
        var zonedDateTime = transformUTCStringToZonedDateTime(CONSTANT_UTC_DATE_TIME);
        return LOCAL_DATE_TIME_FORMAT.format(zonedDateTime);
    }

    private static String getConstantDateAndTimeWithOffsetAndZoneId() {
        var zonedDateTime = transformUTCStringToZonedDateTime(CONSTANT_UTC_DATE_TIME);
        return ZONED_DATE_TIME_FORMAT.format(zonedDateTime);
    }

    private static ZonedDateTime transformUTCStringToZonedDateTime(String dateTime) {
        var utcDateTime = LocalDateTime.from(UTC_DATE_TIME_FORMAT.parse(dateTime));
        var utcZonedDateTime = utcDateTime.atZone(ZoneId.of("UTC"));
        return utcZonedDateTime.withZoneSameInstant(ZoneId.systemDefault());
    }

    @Override
    public ZonedDateTime getCurrentDateAndTime() {
        ZonedDateTime constantDateAndTime = ZonedDateTime.from(ZONED_DATE_TIME_FORMAT.parse(CURRENT_DATE_TIME_WITH_OFFSET_AND_ZONE_ID));

        LOGGER.info("Returning constant date and time: {}", constantDateAndTime);

        return constantDateAndTime;
    }
}
