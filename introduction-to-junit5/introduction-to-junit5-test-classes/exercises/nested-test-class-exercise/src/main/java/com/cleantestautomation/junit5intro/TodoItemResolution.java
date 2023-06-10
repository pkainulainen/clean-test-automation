package com.cleantestautomation.junit5intro;

/**
 * Specifies the possible resolutions of a todo item.
 */
public enum TodoItemResolution {

    /**
     * The todo item was done.
     */
    DONE,

    /**
     * The todo item is a duplicate.
     */
    DUPLICATE,

    /**
     * The todo item won't be done.
     */
    WONT_DO
}
