package com.cleantestautomation.assertjdb.todoitem;

import org.assertj.db.type.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;

/**
 * This exercise helps you to understand how you can write soft assertions for the
 * data that's found from the specified database table.
 */
@SpringBootTest
@ActiveProfiles("integrationTest")
@DisplayName("Update the information of an existing todo item")
@Sql({
        "/db/clear-database.sql",
        "/db/init-user-accounts.sql",
        "/db/init-todo-items.sql"
})
class UpdateTodoItemTest {

    private final TodoItemRepository repository;
    private final Table todoItemTable;

    @Autowired
    UpdateTodoItemTest(DataSource dataSource, TodoItemRepository repository) {
        this.repository = repository;
        this.todoItemTable = new Table(dataSource, TodoItemTable.NAME);
    }

    @Nested
    @DisplayName("When the updated todo item isn't found")
    class WhenUpdatedTodoItemIsNotFound {

        private static final UpdateTodoItem INPUT = UpdateTodoItem.getBuilder()
                .withDescription(TodoItems.UpdatedReadAllLessons.getDescription())
                .withId(TodoItems.UNKNOWN_ID)
                .withModifierId(TodoItems.UpdatedReadAllLessons.getModifiedByUserId())
                .withTitle(TodoItems.UpdatedReadAllLessons.getTitle())
                .build();

        @Test
        @DisplayName("Shouldn't make any changes to the information of the Read all lessons todo item")
        void shouldNotMakeAnyChangesToInformationOfReadAllLessonsTodoItem() {
            repository.update(INPUT);
            //TODO: Write the soft assertions which ensure that the repository doesn't make any changes to the information
            //of the first todo item that's found from the todo_item table.
        }

        @Test
        @DisplayName("Shouldn't make any changes to the information of the Finish all exercises todo item")
        void shouldNotMakeAnyChangesToInformationOfFinishAllExercisesTodoItem() {
            repository.update(INPUT);
            //TODO: Write the soft assertions which ensure that the repository doesn't make any changes to the information
            //of the second todo item that's found from the todo_item table.
        }
    }

    @Nested
    @DisplayName("When the updated todo item is found")
    class WhenUpdatedTodoItemIsFound {

        private static final UpdateTodoItem INPUT = UpdateTodoItem.getBuilder()
                .withDescription(TodoItems.UpdatedReadAllLessons.getDescription())
                .withId(TodoItems.UpdatedReadAllLessons.getId())
                .withModifierId(TodoItems.UpdatedReadAllLessons.getModifiedByUserId())
                .withTitle(TodoItems.UpdatedReadAllLessons.getTitle())
                .build();

        @Test
        @DisplayName("Shouldn't make any changes to the information of the Finish all exercises todo item")
        void shouldNotMakeAnyChangesToInformationOfFinishAllExercisesTodoItem() {
            repository.update(INPUT);
            //TODO: Write the soft assertions which ensure that the repository doesn't make any changes to the information
            //of the second todo item that's found from the todo_item table.
        }
    }
}
