package com.cleantestautomation.junit5intro.todoitem;

/**
 * This exception is thrown when the requested todo item
 * isn't found from the database.
 */
public class TodoItemNotFoundException extends RuntimeException {

    public TodoItemNotFoundException(String message) {
        super(message);
    }
}
