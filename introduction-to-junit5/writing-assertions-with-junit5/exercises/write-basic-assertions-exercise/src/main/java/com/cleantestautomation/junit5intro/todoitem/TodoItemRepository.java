package com.cleantestautomation.junit5intro.todoitem;

import java.util.Optional;

/**
 * Provides finder methods for todo items.
 */
interface TodoItemRepository {

    /**
     * Finds a todo item by using its id as a search criteria.
     *
     * @param id    The id of the requested todo item.
     * @return      An {@link Optional} object that contains the found
     *              todo item. If no todo item is found from the database,
     *              this method returns an empty {@link Optional}.
     */
    Optional<TodoItem> findById(Long id);
}
