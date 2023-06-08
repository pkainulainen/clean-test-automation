package com.cleantestautomation.junit5intro;

/**
 * A model object that contains the information of a todo item.
 * Must be hidden from the outside world.
 */
class TodoItem {

    private Long id;
    private TodoItemResolution resolution;
    private TodoItemStatus status;
    private String title;

    TodoItem() {}

    Long getId() {
        return id;
    }

    TodoItemResolution getResolution() {
        return resolution;
    }

    TodoItemStatus getStatus() {
        return status;
    }

    String getTitle() {
        return title;
    }

    void setId(Long id) {
        this.id = id;
    }

    void setResolution(TodoItemResolution resolution) {
        this.resolution = resolution;
    }

    void setStatus(TodoItemStatus status) {
        this.status = status;
    }

    void setTitle(String title) {
        this.title = title;
    }
}
