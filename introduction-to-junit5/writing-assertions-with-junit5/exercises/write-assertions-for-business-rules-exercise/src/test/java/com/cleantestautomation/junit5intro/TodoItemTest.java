package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for the state transitions of todo items")
class TodoItemTest {

    private TodoItem todoItem;

    @BeforeEach
    void createNewTodoItem() {
        todoItem = new TodoItem();
    }

    @Nested
    @DisplayName("Close the todo item as done")
    class CloseAsDone {

        private final Long CLOSER_ID = 91L;

        @Test
        @DisplayName("Should close the todo item as done")
        void shouldCloseTodoItemAsDone() {
            todoItem.closeAsDone(CLOSER_ID);
            //TODO: Write the assertions which ensure that todo item was closed as done.
        }
    }
}
