package com.cleantestautomation.assertjdb.todoitem;

/**
 * Contains the information of a database row that's found from
 * the <code>todo_item</code> database table.
 */
public class TodoItemRow {

    private final Long id;
    private final Long createdByUserId;
    private final String creationTimeDb;
    private final String description;
    private final String modificationTimeDb;
    private final Long modifiedByUserId;
    private final TodoItemResolution resolution;
    private final String resolutionDb;
    private final TodoItemStatus status;
    private final String statusDb;
    private final String title;
    private final Long version;

    private TodoItemRow(Builder builder) {
        this.id = builder.id;
        this.createdByUserId = builder.createdByUserId;
        this.creationTimeDb = builder.creationTimeDb;
        this.description = builder.description;
        this.modificationTimeDb = builder.modificationTimeDb;
        this.modifiedByUserId = builder.modifiedByUserId;
        this.resolution = builder.resolution;
        this.resolutionDb = builder.resolutionDb;
        this.status = builder.status;
        this.statusDb = builder.statusDb;
        this.title = builder.title;
        this.version = builder.version;
    }

    static Builder getBuilder() {
        return new Builder();
    }

    /**
     * Returns the expected value of the <code>id</code> column.
     */
    public Long getId() {
        return id;
    }


    /**
     * Returns the expected value of the <code>created_by_user_id</code> column.
     */
    public Long getCreatedByUserId() {
        return createdByUserId;
    }

    /**
     * Returns the expected value of the <code>creation_time</code> column.
     */
    public String getCreationTimeDb() {
        return creationTimeDb;
    }

    /**
     * Returns the expected value of the <code>description</code> column.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the expected value of the <code>modification_time</code> column.
     */
    public String getModificationTimeDb() {
        return modificationTimeDb;
    }

    /**
     * Returns the expected value of the <code>modified_by_user_id</code> column.
     */
    public Long getModifiedByUserId() {
        return modifiedByUserId;
    }

    /**
     * Returns the resolution that's used to build the test data that's passed
     * to the system under test.
     */
    public TodoItemResolution getResolution() {
        return resolution;
    }

    /**
     * Returns the expected value of the <code>resolution</code> column.
     */
    public String getResolutionDb() {
        return resolutionDb;
    }

    /**
     * Returns the status that's used to build the test data that's passed
     * to the system under test.
     */
    public TodoItemStatus getStatus() {
        return status;
    }

    /**
     * Returns the expected value of the <code>status</code> column.
     */
    public String getStatusDb() {
        return statusDb;
    }

    /**
     * Returns the expected value of the <code>title</code> column.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the expected value of the <code>version</code> column.
     */
    public Long getVersion() {
        return version;
    }

    static class Builder {

        private Long id;
        private Long createdByUserId;
        private String creationTimeDb;
        private String description;
        private String modificationTimeDb;
        private Long modifiedByUserId;
        private TodoItemResolution resolution;
        private String resolutionDb;
        private TodoItemStatus status;
        private String statusDb;
        private String title;
        private Long version;

        Builder withId(Long id) {
            this.id = id;
            return this;
        }

        Builder withCreatedByUserId(Long createdByUserId) {
            this.createdByUserId = createdByUserId;
            return this;
        }

        Builder withCreationTimeDb(String creationTimeDb) {
            this.creationTimeDb = creationTimeDb;
            return this;
        }

        Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        Builder withModificationTimeDb(String modificationTimeDb) {
            this.modificationTimeDb = modificationTimeDb;
            return this;
        }

        Builder withModifiedByUserId(Long modifiedByUserId) {
            this.modifiedByUserId = modifiedByUserId;
            return this;
        }

        Builder withResolution(TodoItemResolution resolution) {
            this.resolution = resolution;
            this.resolutionDb = resolution != null ? resolution.name() : null;
            return this;
        }

        Builder withStatus(TodoItemStatus status) {
            this.status = status;
            this.statusDb = status.name();
            return this;
        }

        Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        Builder withVersion(Long version) {
            this.version = version;
            return this;
        }

        TodoItemRow build() {
            return new TodoItemRow(this);
        }
    }
}
