package com.cleantestautomation.assertjdb.todoitem;

import com.cleantestautomation.assertjdb.common.DateTimeService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static com.cleantestautomation.assertjdb.jooq.Tables.TODO_ITEM;

/**
 * Provides CRUD operations for todo items.
 */
@Repository
public class TodoItemRepository {

    private final DateTimeService dateTimeService;
    private final DSLContext jooq;

    @Autowired
    TodoItemRepository(DateTimeService dateTimeService, DSLContext jooq) {
        this.dateTimeService = dateTimeService;
        this.jooq = jooq;
    }

    /**
     * Creates a new todo item.
     * @param input The information of the created todo item.
     * @return  The information of the created todo item.
     */
    @Transactional
    public TodoItem create(CreateTodoItem input) {
        var currentDateAndTime = dateTimeService.getCurrentDateAndTime().toOffsetDateTime();
        var result = jooq.insertInto(TODO_ITEM)
                .columns(
                        TODO_ITEM.CREATED_BY_USER_ID,
                        TODO_ITEM.CREATION_TIME,
                        TODO_ITEM.DESCRIPTION,
                        TODO_ITEM.MODIFICATION_TIME,
                        TODO_ITEM.MODIFIED_BY_USER_ID,
                        TODO_ITEM.STATUS,
                        TODO_ITEM.TITLE
                )
                .values(
                        input.getCreatorId(),
                        currentDateAndTime,
                        input.getDescription(),
                        currentDateAndTime,
                        input.getCreatorId(),
                        input.getStatus().name(),
                        input.getTitle()
                )
                .returning(
                        TODO_ITEM.ID,
                        TODO_ITEM.DESCRIPTION,
                        TODO_ITEM.RESOLUTION,
                        TODO_ITEM.STATUS,
                        TODO_ITEM.TITLE
                )
                .fetchOptional().get();

        return TodoItem.getBuilder()
                .withId(result.getId())
                .withDescription(result.getDescription())
                .withResolution(parseResolution(result.getResolution()))
                .withStatus(TodoItemStatus.valueOf(result.getStatus()))
                .withTitle(result.getTitle())
                .build();
    }

    /**
     * Updates the information of an existing todo item.
     * @param input The new information of the updated todo item.
     * @return  The information of the updated todo item.
     */
    @Transactional
    public TodoItem update(UpdateTodoItem input) {
        var currentDateAndTime = dateTimeService.getCurrentDateAndTime().toOffsetDateTime();
        var result = jooq.update(TODO_ITEM)
                .set(TODO_ITEM.DESCRIPTION, input.getDescription())
                .set(TODO_ITEM.MODIFICATION_TIME, currentDateAndTime)
                .set(TODO_ITEM.MODIFIED_BY_USER_ID, input.getModifierId())
                .set(TODO_ITEM.TITLE, input.getTitle())
                .set(TODO_ITEM.VERSION, TODO_ITEM.VERSION.add(1))
                .where(TODO_ITEM.ID.eq(input.getId()))
                .returning(
                        TODO_ITEM.ID,
                        TODO_ITEM.DESCRIPTION,
                        TODO_ITEM.RESOLUTION,
                        TODO_ITEM.STATUS,
                        TODO_ITEM.TITLE
                )
                .fetchOptional().get();

        return TodoItem.getBuilder()
                .withId(result.getId())
                .withDescription(result.getDescription())
                .withResolution(parseResolution(result.getResolution()))
                .withStatus(TodoItemStatus.valueOf(result.getStatus()))
                .withTitle(result.getTitle())
                .build();
    }

    private TodoItemResolution parseResolution(String input) {
        if (input == null) {
            return null;
        }
        else {
            return TodoItemResolution.valueOf(input);
        }
    }
}