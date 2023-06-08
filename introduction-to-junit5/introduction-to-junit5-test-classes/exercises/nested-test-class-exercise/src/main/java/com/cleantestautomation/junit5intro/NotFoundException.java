package com.cleantestautomation.junit5intro;

/**
 * This exception is thrown when the requested todo item
 * isn't found from the database.
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
