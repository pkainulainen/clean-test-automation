package com.cleantestautomation.junit5intro.todoitem;

/**
 * Contains the information of one todo item.
 */
public class TodoItemListItem {

    private Long id;
    private String title;

    public TodoItemListItem() {}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
