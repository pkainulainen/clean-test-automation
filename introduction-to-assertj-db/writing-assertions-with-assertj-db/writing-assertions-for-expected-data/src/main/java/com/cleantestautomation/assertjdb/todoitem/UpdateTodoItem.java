package com.cleantestautomation.assertjdb.todoitem;

/**
 * Contains the new information of the updated todo item.
 */
class UpdateTodoItem {

    private final Long id;
    private final String description;
    private final Long modifierId;
    private final String title;

    private UpdateTodoItem(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.modifierId = builder.modifierId;
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

    Long getModifierId() {
        return modifierId;
    }

    String getTitle() {
        return title;
    }

    /**
     * Allows you to build new {@link UpdateTodoItem} objects.
     */
    static class Builder {

        private String description;
        private Long id;
        private Long modifierId;
        private String title;

        Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        Builder withId(Long id) {
            this.id = id;
            return this;
        }

        Builder withModifierId(Long modifierId) {
            this.modifierId = modifierId;
            return this;
        }

        Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        UpdateTodoItem build() {
            return new UpdateTodoItem(this);
        }
    }
}
