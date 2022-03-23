package com.cleantestautomation.junit5intro;

/**
 * Contains the information of one todo item.
 */
public class TodoItem {

    private Long closerId;
    private TodoItemResolution resolution;
    private String title;
    private TodoItemStatus status;

    public Long getCloserId() {
        return closerId;
    }

    public TodoItemResolution getResolution() {
        return resolution;
    }

    public String getTitle() {
        return title;
    }

    public TodoItemStatus getStatus() {
        return status;
    }

    //Generally speaking, it's not a good idea to add
    //setters to domain objects because if you do this,
    //the domain object cannot protect itself from "illegal"
    //state transitions.
    public void setCloserId(Long closerId) {
        this.closerId = closerId;
    }

    public void setResolution(TodoItemResolution resolution) {
        this.resolution = resolution;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(TodoItemStatus status) {
        this.status = status;
    }
}
