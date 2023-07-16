package com.cleantestautomation.assertjdb.todoitem;

/**
 * Contains the metadata of the <code>todo_item</code> database table.
 */
public class TodoItemTable {

    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_DESCRIPTION = "description";
    public static final String COLUMN_NAME_CREATED_BY_USER_ID = "created_by_user_id";
    public static final String COLUMN_NAME_CREATION_TIME = "creation_time";
    public static final String COLUMN_NAME_MODIFICATION_TIME = "modification_time";
    public static final String COLUMN_NAME_MODIFIED_BY_USER_ID = "modified_by_user_id";
    public static final String COLUMN_NAME_RESOLUTION = "resolution";
    public static final String COLUMN_NAME_STATUS = "status";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_VERSION = "version";

    public static final String NAME = "todo_item";

    /**
     * Prevents instantiation.
     */
    private TodoItemTable() {}
}
