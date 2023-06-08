package com.cleantestautomation.junit5intro;

import java.util.Optional;

/**
 * Provider read operations for todo items.
 */
interface TodoItemRepository {

    /**
     * Finds the requested todo item from the database.
     * @param id    The id of the request todo item
     * @return  An {@link Optional} object that contains the found todo item.
     *          If no todo item is found from the database, this method
     *          returns an empty {@link Optional} object.
     */
    Optional<TodoItem> findById(Long id);
}
