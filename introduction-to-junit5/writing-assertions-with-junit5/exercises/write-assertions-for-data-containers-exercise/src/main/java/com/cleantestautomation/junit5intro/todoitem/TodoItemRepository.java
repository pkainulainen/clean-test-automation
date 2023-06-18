package com.cleantestautomation.junit5intro.todoitem;

import java.util.List;

interface TodoItemRepository {

    /**
     * Finds all todo items from the database.
     *
     * @return  A list of todo items. If no todo items is found
     *          from the database, this method returns an empty list.
     */
    List<TodoItemListItem> findAll();
}
