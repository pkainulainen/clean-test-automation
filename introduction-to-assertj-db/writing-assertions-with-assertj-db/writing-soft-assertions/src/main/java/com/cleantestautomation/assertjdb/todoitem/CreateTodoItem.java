package com.cleantestautomation.assertjdb.todoitem;

/**
 * Contains the information of the created todo item.
 */
class CreateTodoItem {

    private final Long creatorId;
    private final String description;
    private final TodoItemStatus status;
    private final String title;

    private CreateTodoItem(Builder builder) {
        this.creatorId = builder.creatorId;
        this.description = builder.description;
        this.status = TodoItemStatus.OPEN;
        this.title = builder.title;
    }

    static Builder getBuilder() {
        return new Builder();
    }

    Long getCreatorId() {
        return creatorId;
    }

    String getDescription() {
        return description;
    }

    TodoItemStatus getStatus() {
        return status;
    }

    String getTitle() {
        return title;
    }

    /**
     * Allows you to build new {@link CreateTodoItem} objects.
     */
    static class Builder {

        private Long creatorId;
        private String description;
        private String title;

        Builder withCreatorId(Long creatorId) {
            this.creatorId = creatorId;
            return this;
        }

        Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        CreateTodoItem build() {
            //Typically this method would check that the state of the created object
            //is correct. I omitted these checks because I wanted to keep this class
            //as simple as possible.
            return new CreateTodoItem(this);
        }
    }
}
