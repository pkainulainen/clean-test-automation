package com.cleantestautomation.junit5intro;

/**
 * A simple message container that allows you to configure the stored
 * message and obtain the configured message.
 */
class MessageService {

    private final String message;

    /**
     * Creates a new object and configures the message.
     * @param message   The message
     */
    MessageService(String message) {
        this.message = message;
    }

    /**
     * Returns the configured message.
     */
    String getMessage() {
        return message;
    }
}
