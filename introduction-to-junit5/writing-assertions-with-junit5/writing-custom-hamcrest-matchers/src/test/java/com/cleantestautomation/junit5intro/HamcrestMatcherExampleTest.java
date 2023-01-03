package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.nullValue;

/**
 * This test class demonstrates how you can write assertions for
 * {@link TodoItem} object by using Hamcrest matchers.
 */
@DisplayName("Write assertions with Hamcrest")
class HamcrestMatcherExampleTest {

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
        assertThat(actual.getTitle(), equalTo(TITLE));
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
            assertThat(actual, allOf(
                    hasProperty("status", equalTo(TodoItemStatus.OPEN)),
                    hasProperty("resolution", nullValue()),
                    hasProperty("closerId", nullValue())
            ));
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
            assertThat(actual, allOf(
                    hasProperty("status", equalTo(TodoItemStatus.CLOSED)),
                    hasProperty("resolution", equalTo(TodoItemResolution.DUPLICATE)),
                    hasProperty("closerId", equalTo(CLOSER_ID))
            ));
        }
    }
}
