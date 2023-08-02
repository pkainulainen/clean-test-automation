package com.cleantestautomation.assertjdb.todoitem;


import com.cleantestautomation.assertjdb.TestDateTimeBuilder;
import com.cleantestautomation.assertjdb.useraccount.UserAccounts;

/**
 * Contains the test data that's found from the <code>todo_item</code> database table.
 */
public class TodoItems {

    public static final Long DEFAULT_VERSION = 0L;
    public static final int TODO_ITEM_ROW_COUNT = 2;
    public static final Long UNKNOWN_ID = 99L;

    /**
     * Contains the information that should be found from the first row of the <code>todo_item</code>
     * database table.
     */
    public static class ReadAllLessons {

        public static final Long ID = 1L;
        public static final Long CREATED_BY_USER_ID = UserAccounts.AnneOwens.ID;
        public static final String CREATION_TIME_DB = TestDateTimeBuilder.transformUTCDateTimeToLocalDateTime("2023-07-07T10:46:00");
        public static final String DESCRIPTION = "Be diligent";
        public static final String UPDATED_DESCRIPTION = "Finish this todo item before the end of this month";
        public static final String MODIFICATION_TIME = CREATION_TIME_DB;
        public static final Long MODIFIED_BY_USER_ID = CREATED_BY_USER_ID;
        public static final TodoItemResolution NO_RESOLUTION = null;
        public static final TodoItemStatus STATUS_OPEN = TodoItemStatus.OPEN;
        public static final String TITLE = "Read all lessons";
        public static final String UPDATED_TITLE = "Finish the course";
        public static final Long VERSION = 0L;
    }

    /**
     * Contains the information that should be found from the second row of the <code>todo_item</code>
     * database table.
     */
    public static class FinishAllExercises {

        public static final Long ID = 2L;
        public static final Long CREATED_BY_USER_ID = UserAccounts.AnneOwens.ID;
        public static final String CREATION_TIME_DB = TestDateTimeBuilder.transformUTCDateTimeToLocalDateTime("2023-07-07T12:46:00");
        public static final String DESCRIPTION = "Do not use copy & paste";
        public static final String MODIFICATION_TIME_DB = CREATION_TIME_DB;
        public static final Long MODIFIED_BY_USER_ID = CREATED_BY_USER_ID;
        public static final TodoItemResolution NO_RESOLUTION = null;
        public static final TodoItemStatus STATUS_OPEN = TodoItemStatus.OPEN;
        public static final String TITLE = "Finish all exercises";
        public static final Long VERSION = 0L;
    }

    /**
     * Prevents instantiation.
     */
    private TodoItems() {}
}
