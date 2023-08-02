package com.cleantestautomation.assertjdb.todoitem;

/**
 * Contains the information of one todo item.
 */
class TodoItem {

    private final Long id;
    private final String description;
    private final TodoItemResolution resolution;
    private final TodoItemStatus status;
    private final String title;

    private TodoItem(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.resolution = builder.resolution;
        this.status = builder.status;
        this.title = builder.title;
    }

    static Builder getBuilder() {
        return new Builder();
    }

    Long getId() {
        return id;
    }

    String getDescription() {
        return description;
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

    /**
     * Allows you to build new {@link TodoItem} objects.
     */
    static class Builder {

        private String description;
        private Long id;
        private TodoItemResolution resolution;
        private TodoItemStatus status;
        private String title;

        Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        Builder withId(Long id) {
            this.id = id;
            return this;
        }

        Builder withResolution(TodoItemResolution resolution) {
            this.resolution = resolution;
            return this;
        }

        Builder withStatus(TodoItemStatus status) {
            this.status = status;
            return this;
        }

        Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        TodoItem build() {
            //Typically this method would check that the state of the created object
            //is correct. I omitted these checks because I wanted to keep this class
            //as simple as possible.
            return new TodoItem(this);
        }
    }
}
