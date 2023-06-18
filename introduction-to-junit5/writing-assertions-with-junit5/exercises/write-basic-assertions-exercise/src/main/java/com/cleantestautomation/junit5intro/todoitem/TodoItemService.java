package com.cleantestautomation.junit5intro.todoitem;

/**
 * Provides finder methods for todo items.
 */
public class TodoItemService {

    private final TodoItemRepository repository;

    public TodoItemService(TodoItemRepository repository) {
        this.repository = repository;
    }

    /**
     * Finds the information of a todo item by using its id as a
     * search criteria.
     *
     * @param id    The id of the requested todo item.
     * @return      The information of the found todo item.
     * @throws      TodoItemNotFoundException   if no todo item is found from the
     *                                          database.
     */
    public TodoItem findById(Long id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new TodoItemNotFoundException("No todo item found with id: #" + id)
                );
    }
}
