package com.cleantestautomation.junit5intro;

/**
 * A DTO that contains the information of a todo item.
 */
public class TodoItemDTO {

    private Long id;
    private TodoItemResolution resolution;
    private TodoItemStatus status;
    private String title;

    public TodoItemDTO() {}

    public Long getId() {
        return id;
    }

    public TodoItemResolution getResolution() {
        return resolution;
    }

    public TodoItemStatus getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setResolution(TodoItemResolution resolution) {
        this.resolution = resolution;
    }

    public void setStatus(TodoItemStatus status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
