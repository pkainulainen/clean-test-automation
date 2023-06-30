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

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Closes this todo item because it was finished.
     *
     * @param closerId  The id of the user who closed this todo item.
     */
    public void closeAsDone(Long closerId) {
        this.closerId = closerId;
        this.resolution = TodoItemResolution.DONE;
        this.status = TodoItemStatus.CLOSED;
    }
}

