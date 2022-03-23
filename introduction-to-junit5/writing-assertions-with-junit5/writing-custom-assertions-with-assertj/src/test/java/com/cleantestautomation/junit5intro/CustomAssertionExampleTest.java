package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.cleantestautomation.junit5intro.TodoItemAssertion.assertThatTodoItem;

@DisplayName("Write assertions by using custom assertions")
public class CustomAssertionExampleTest {

    private final String TITLE = "Write a new lesson";

    private TodoItem actual;

    @BeforeEach
    void createTodoItemAndSetTitle() {
        actual = new TodoItem();
        actual.setTitle(TITLE);
    }

    @Test
    @DisplayName("Should have the correct title")
    void shouldHaveCorrectTitle() {
        assertThatTodoItem(actual).hasTitle(TITLE);
    }

    @Nested
    @DisplayName("When the todo item is open")
    class WhenTodoItemIsOpen {

        @BeforeEach
        void ensureThatTodoItemIsOpen() {
            actual.setCloserId(null);
            actual.setStatus(TodoItemStatus.OPEN);
            actual.setResolution(null);
        }

        @Test
        @DisplayName("Should be open")
        void shouldBeOpen() {
            assertThatTodoItem(actual).isOpen();
        }
    }

    @Nested
    @DisplayName("When the todo item was closed as a duplicate")
    class WhenTodoItemWasClosedAsDuplicate {

        private final Long CLOSER_ID = 99L;

        @BeforeEach
        void ensureThatTodoItemWasClosedAsDuplicate() {
            actual.setCloserId(CLOSER_ID);
            actual.setStatus(TodoItemStatus.CLOSED);
            actual.setResolution(TodoItemResolution.DUPLICATE);
        }

        @Test
        @DisplayName("Should be closed as duplicate by the correct user")
        void shouldBeClosedAsDuplicateByCorrectUser() {
            assertThatTodoItem(actual).wasClosedAsDuplicateByUser(CLOSER_ID);
        }
    }
}
