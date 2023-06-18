package com.cleantestautomation.junit5intro.todoitem;

/**
 * Contains information of one todo item.
 */
public class TodoItem {

    private Long id;
    private String title;
    private String description;

    public TodoItem() {}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
