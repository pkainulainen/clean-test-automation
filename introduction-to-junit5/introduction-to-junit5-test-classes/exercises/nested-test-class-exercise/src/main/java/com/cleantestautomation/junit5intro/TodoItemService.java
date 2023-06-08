package com.cleantestautomation.junit5intro;

/**
 * Provides read operations for todo items.
 */
public class TodoItemService {

    private final TodoItemRepository repository;

    public TodoItemService(TodoItemRepository repository) {
        this.repository = repository;
    }

    /**
     * Finds the requested todo item from the database.
     * @param id    The id of the requested todo item.
     * @return  The information of the found item.
     * @throws  NotFoundException   When the requested todo item isn't found from the database.
     */
    public TodoItemDTO findById(Long id) {
        return repository.findById(id)
                .map(source -> {
                    var todoItem = new TodoItemDTO();

                    todoItem.setId(source.getId());
                    todoItem.setResolution(source.getResolution());
                    todoItem.setStatus(source.getStatus());
                    todoItem.setTitle(source.getTitle());

                    return todoItem;
                })
                .orElseThrow(() -> new NotFoundException("No todo item found with id: #" + id));
    }
}
