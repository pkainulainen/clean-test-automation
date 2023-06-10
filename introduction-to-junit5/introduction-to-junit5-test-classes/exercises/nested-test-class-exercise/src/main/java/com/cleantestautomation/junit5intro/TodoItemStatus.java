package com.cleantestautomation.junit5intro;

/**
 * Specifies the possible statuses of a todo item.
 */
public enum TodoItemStatus {

    /**
     * The todo item is closed.
     */
    CLOSED,

    /**
     * The todo item is under work.
     */
    IN_PROGRESS,

    /**
     * The todo item hasn't been started yet.
     */
    OPEN
}
