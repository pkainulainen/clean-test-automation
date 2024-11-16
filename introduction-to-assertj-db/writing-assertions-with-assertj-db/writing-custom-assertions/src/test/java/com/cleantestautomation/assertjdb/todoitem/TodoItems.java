package com.cleantestautomation.assertjdb.todoitem;

import com.cleantestautomation.assertjdb.TestDateTimeBuilder;
import com.cleantestautomation.assertjdb.common.ConstantDateTimeService;
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
    public static final TodoItemRow ReadAllLessons = TodoItemRow.getBuilder()
            .withId(1L)
            .withCreatedByUserId(UserAccounts.AnneOwens.getId())
            .withCreationTimeDb(TestDateTimeBuilder.transformUTCDateTimeToLocalDateTime("2023-07-07T10:46:00"))
            .withDescription("Be diligent")
            .withModificationTimeDb(TestDateTimeBuilder.transformUTCDateTimeToLocalDateTime("2023-07-07T10:46:00"))
            .withModifiedByUserId(UserAccounts.AnneOwens.getId())
            .withResolution(null)
            .withStatus(TodoItemStatus.OPEN)
            .withTitle("Read all lessons")
            .withVersion(0L)
            .build();

    /**
     * Contains the information that should be found from the first row of the <code>todo_item</code>
     * database table after the information of the todo item has been updated.
     */
    public static final TodoItemRow UpdatedReadAllLessons = TodoItemRow.getBuilder()
            .withId(1L)
            .withCreatedByUserId(UserAccounts.AnneOwens.getId())
            .withCreationTimeDb(TestDateTimeBuilder.transformUTCDateTimeToLocalDateTime("2023-07-07T10:46:00"))
            .withDescription("Finish this todo item before the end of this month")
            .withModificationTimeDb(ConstantDateTimeService.CURRENT_LOCAL_DATE_TIME)
            .withModifiedByUserId(UserAccounts.AnneOwens.getId())
            .withResolution(null)
            .withStatus(TodoItemStatus.OPEN)
            .withTitle("Finish the course")
            .withVersion(1L)
            .build();

    /**
     * Contains the information that should be found from the second row of the <code>todo_item</code>
     * database table.
     */
    public static final TodoItemRow FinishAllExercises = TodoItemRow.getBuilder()
            .withId(2L)
            .withCreatedByUserId(UserAccounts.AnneOwens.getId())
            .withCreationTimeDb(TestDateTimeBuilder.transformUTCDateTimeToLocalDateTime("2023-07-07T12:46:00"))
            .withDescription("Do not use copy & paste")
            .withModificationTimeDb(TestDateTimeBuilder.transformUTCDateTimeToLocalDateTime("2023-07-07T12:46:00"))
            .withModifiedByUserId(UserAccounts.AnneOwens.getId())
            .withResolution(null)
            .withStatus(TodoItemStatus.OPEN)
            .withTitle("Finish all exercises")
            .withVersion(0L)
            .build();

    /**
     * Prevents instantiation.
     */
    private TodoItems() {}
}