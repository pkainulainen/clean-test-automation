package com.cleantestautomation.junit5intro.todoitem;

import java.util.List;

/**
 * Provides find operations for todo items.
 */
public class TodoItemService {

    private final TodoItemRepository repository;

    public TodoItemService(TodoItemRepository repository) {
        this.repository = repository;
    }

    /**
     * Finds all todo items from the database.
     *
     * @return  A list of todo items. if no todo items is found from
     *          the database, this method returns an empty list.
     */
    public List<TodoItemListItem> findAll() {
        return repository.findAll();
    }
}
