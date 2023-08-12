package com.cleantestautomation.assertjdb.todoitem;

import com.cleantestautomation.assertjdb.IdColumnReset;
import org.assertj.core.api.Assertions;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

/**
 * This exercise helps you to understand how you can write the assertions which ensure
 * that only the information of the given todo item is updated to the database.
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
                .withDescription(TodoItems.ReadAllLessons.UPDATED_DESCRIPTION)
                .withId(TodoItems.UNKNOWN_ID)
                .withModifierId(TodoItems.ReadAllLessons.MODIFIED_BY_USER_ID)
                .withTitle(TodoItems.ReadAllLessons.UPDATED_TITLE)
                .build();

        @Test
        @DisplayName("Shouldn't insert new todo items into the database or delete todo items from the database")
        void shouldNotInsertNewTodoItemsIntoDatabaseOrDeleteTodoItemsFromDatabase() {
            repository.update(INPUT);
            //TODO: Write the assertion which ensures that the repository doesn't insert new todo items into the
            //todo_item table or delete todo items from the todo_item table.
        }

        @Test
        @DisplayName("Shouldn't make any changes to the information of the Read all lessons todo item")
        void shouldNotMakeAnyChangesToInformationOfReadAllLessonsTodoItem() {
            repository.update(INPUT);
            //TODO: Write the assertions which ensure that the repository doesn't make any changes to the information
            //of the first todo item that's found from the todo_item table.
        }

        @Test
        @DisplayName("Shouldn't make any changes to the information of the Finish all exercises todo item")
        void shouldNotMakeAnyChangesToInformationOfFinishAllExercisesTodoItem() {
            repository.update(INPUT);
            //TODO: Write the assertions which ensure that the repository doesn't make any changes to the information
            //of the second todo item that's found from the todo_item table.
        }

        @Test
        @DisplayName("Should return null")
        void shouldReturnNull() {
            var updated = repository.update(INPUT);
            Assertions.assertThat(updated).isNull();
        }
    }

    @Nested
    @DisplayName("When the updated todo item is found")
    class WhenUpdatedTodoItemIsFound {

        private static final UpdateTodoItem INPUT = UpdateTodoItem.getBuilder()
                .withDescription(TodoItems.ReadAllLessons.UPDATED_DESCRIPTION)
                .withId(TodoItems.ReadAllLessons.ID)
                .withModifierId(TodoItems.ReadAllLessons.MODIFIED_BY_USER_ID)
                .withTitle(TodoItems.ReadAllLessons.UPDATED_TITLE)
                .build();

        @Test
        @DisplayName("Shouldn't insert new todo items into the database or delete todo items from the database")
        void shouldNotInsertNewTodoItemsIntoDatabaseOrDeleteTodoItemsFromDatabase() {
            repository.update(INPUT);
            //TODO: Write the assertion which ensures that the repository doesn't insert new todo items into the
            //todo_item table or delete todo items from the todo_item table.
        }

        @Test
        @DisplayName("Shouldn't change the id of the updated todo item")
        void shouldNotChangeIdOfUpdatedTodoItem() {
            repository.update(INPUT);
            //TODO: Write the assertion which ensures that the repository doesn't change the id of the updated todo item.
        }

        @Test
        @DisplayName("Shouldn't update the creator ID of the updated todo item")
        void shouldNotUpdateCreatorIdOfUpdatedTodoItem() {
            repository.update(INPUT);
            //TODO: Write the assertion which ensures that the repository doesn't update the creator ID of the updated
            //todo item.
        }

        @Test
        @DisplayName("Shouldn't update the creation time of the updated todo item")
        void shouldNotUpdateCreationTimeOfUpdatedTodoItem() {
            repository.update(INPUT);
            //TODO: Write the assertion which ensures that the repository doesn't update the creation time of the updated
            //todo item.
        }

        @Test
        @DisplayName("Should update the description of the updated todo item")
        void shouldUpdateDescriptionOfUpdatedTodoItem() {
            repository.update(INPUT);
            //TODO: Write the assertion which ensures that the repository updates the description of the updated
            //todo item.
        }

        @Test
        @DisplayName("Should update the modification time of the updated todo item")
        void shouldUpdateModificationTimeOfUpdatedTodoItem() {
            repository.update(INPUT);
            //TODO: Write the assertion which ensures that the repository updates the modification time of the updated
            //todo item.
        }

        @Test
        @DisplayName("Should update the modifier id of the updated todo item")
        void shouldUpdateModifierIdOfUpdatedTodoItem() {
            repository.update(INPUT);
            //TODO: Write the assertion which ensures that the repository updates the modifier id of the updated todo item.
        }

        @Test
        @DisplayName("Shouldn't update the resolution of the updated todo item")
        void shouldNotUpdateResolutionOfUpdatedTodoItem() {
            repository.update(INPUT);
            //TODO: Write the assertion which ensures that the repository doesn't update the resolution of the updated
            //todo item.
        }

        @Test
        @DisplayName("Shouldn't update the status of the updated todo item")
        void shouldNotUpdateStatusOfUpdatedTodoItem() {
            repository.update(INPUT);
            //TODO: Write the assertion which ensures that the repository doesn't update the status of the updated
            //todo item.
        }

        @Test
        @DisplayName("Should update the title of the updated todo item")
        void shouldUpdateTitleOfUpdatedTodoItem() {
            repository.update(INPUT);
            //TODO: Write the assertion which ensures that the repository updates the title of the updated todo item.
        }

        @Test
        @DisplayName("Should increase the version of the updated todo item by one")
        void shouldIncreaseVersionOfUpdatedTodoItemByOne() {
            repository.update(INPUT);
            //TODO: Write the assertion which ensures that the repository increases the version of the updated
            //todo item by one.
        }

        @Test
        @DisplayName("Should return the information of the updated todo item")
        void shouldReturnInformationOfUpdatedTodoItem() {
            var updated = repository.update(INPUT);
            assertSoftly(softAssertions -> {
                softAssertions.assertThat(updated.getId())
                        .as("id")
                        .isEqualByComparingTo(IdColumnReset.NEXT_ID);
                softAssertions.assertThat(updated.getDescription())
                        .as("description")
                        .isEqualTo(TodoItems.ReadAllLessons.UPDATED_DESCRIPTION);
                softAssertions.assertThat(updated.getResolution())
                        .as("resolution")
                        .isEqualTo(TodoItems.ReadAllLessons.NO_RESOLUTION);
                softAssertions.assertThat(updated.getStatus())
                        .as("status")
                        .isEqualTo(TodoItems.ReadAllLessons.STATUS_OPEN);
                softAssertions.assertThat(updated.getTitle())
                        .as("title")
                        .isEqualTo(TodoItems.ReadAllLessons.UPDATED_TITLE);
            });
        }

        @Test
        @DisplayName("Shouldn't make any changes to the information of the Finish all exercises todo item")
        void shouldNotMakeAnyChangesToInformationOfFinishAllExercisesTodoItem() {
            repository.update(INPUT);
            //TODO: Write the assertions which ensure that the repository doesn't make any changes to the information
            //of the second todo item that's found from the todo_item table.
        }
    }
}
