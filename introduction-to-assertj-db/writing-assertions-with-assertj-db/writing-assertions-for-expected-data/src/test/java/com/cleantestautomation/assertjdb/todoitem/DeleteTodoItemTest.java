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

@SpringBootTest
@ActiveProfiles("integrationTest")
@DisplayName("Update the information of an existing todo item")
@Sql({
        "/db/clear-database.sql",
        "/db/init-user-accounts.sql",
        "/db/init-todo-items.sql"
})
class DeleteTodoItemTest {

    private final TodoItemRepository repository;
    private final Table todoItemTable;

    @Autowired
    DeleteTodoItemTest(DataSource dataSource, TodoItemRepository repository) {
        this.repository = repository;
        this.todoItemTable = new Table(dataSource, TodoItemTable.NAME);
    }

    @Nested
    @DisplayName("When the deleted todo item isn't found")
    class WhenDeletedTodoItemIsNotFound {

        @Test
        @DisplayName("Shouldn't delete todo items from the database")
        void shouldNotDeleteTodoItemsFromDatabase() {
            repository.delete(TodoItems.UNKNOWN_ID);
            //TODO: Write the assertion which ensures that the system under test doesn't delete todo items from the database.
        }

        @Test
        @DisplayName("Shouldn't make any changes to the information of the Read all lessons todo item")
        void shouldNotMakeAnyChangesToInformationOfReadAllLessonsTodoItem() {
            repository.delete(TodoItems.UNKNOWN_ID);
            //TODO: Write the assertions which ensure that the repository doesn't make any changes to the information
            //of the first todo item that's found from the todo_item table.
        }

        @Test
        @DisplayName("Shouldn't make any changes to the information of the Finish all exercises todo item")
        void shouldNotMakeAnyChangesToInformationOfFinishAllExercisesTodoItem() {
            repository.delete(TodoItems.UNKNOWN_ID);
            //TODO: Write the assertions which ensure that the repository doesn't make any changes to the information
            //of the second todo item that's found from the todo_item table.
        }

        @Test
        @DisplayName("Should return null")
        void shouldReturnNull() {
            var deleted = repository.delete(TodoItems.UNKNOWN_ID);
            //TODO: Write the assertion which ensures that the repository returns null.
        }
    }

    @Nested
    @DisplayName("When the deleted todo item is found")
    class WhenDeletedTodoItemIsFound {

        @Test
        @DisplayName("Should delete one todo item from the database")
        void shouldDeleteOneTodoItemFromDatabase() {
            repository.delete(TodoItems.FinishAllExercises.ID);
            //TODO: Write the assertion which ensures that the system under test deletes one todo item from the database.
        }

        @Test
        @DisplayName("Shouldn't make any changes to the information of the Read all lessons todo item")
        void shouldNotMakeAnyChangesToInformationOfReadAllLessonsTodoItem() {
            repository.delete(TodoItems.FinishAllExercises.ID);
            //TODO: Write the assertions which ensure that the repository doesn't make any changes to the information
            //of the first todo item that's found from the todo_item table.
        }

        @Test
        @DisplayName("Should return the information of the deleted todo item")
        void shouldReturnInformationOfDeletedTodoItem() {
            var deleted = repository.delete(TodoItems.FinishAllExercises.ID);
            //TODO: Write the assertions which ensure that the system under test returns the information of the
            //deleted todo item.
        }
    }
}
