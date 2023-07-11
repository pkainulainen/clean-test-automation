package com.cleantestautomation.assertjdb.common;

import java.time.ZonedDateTime;

/**
 * Declares a method that is used to get the current date and time.
 */
public interface DateTimeService {

    /**
     * Returns the current date and time.
     */
    public ZonedDateTime getCurrentDateAndTime();
}
