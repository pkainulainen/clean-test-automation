package com.cleantestautomation.junit5intro;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Write assertions with AssertJ")
@ExtendWith(SoftAssertionsExtension.class)
public class AssertJAssertionExampleTest {

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
        assertThat(actual.getTitle())
                .as("title")
                .isEqualTo(TITLE);
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
        void shouldBeOpen(SoftAssertions softAssertions) {
            softAssertions.assertThat(actual.getStatus())
                    .overridingErrorMessage(
                            "The status of an open task must be: %s",
                            TodoItemStatus.OPEN
                    )
                    .isEqualTo(TodoItemStatus.OPEN);

            softAssertions.assertThat(actual.getResolution())
                    .overridingErrorMessage(
                            "Expected that the resolution of an open task is null but was: %s",
                            actual.getStatus()
                    )
                    .isNull();

            softAssertions.assertThat(actual.getCloserId())
                    .overridingErrorMessage(
                            "Expected that the closerId of an open task is null but was: %d",
                            actual.getCloserId()
                    )
                    .isNull();
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
        void shouldBeClosedAsDuplicateByCorrectUser(SoftAssertions softAssertions) {
            softAssertions.assertThat(actual.getStatus())
                    .overridingErrorMessage(
                            "Expected thatthe status to be: %s but was: %s",
                            TodoItemStatus.CLOSED,
                            actual.getStatus()
                    )
                    .isEqualTo(TodoItemStatus.CLOSED);

            softAssertions.assertThat(actual.getResolution())
                    .overridingErrorMessage(
                            "Expected that the resolution is: %s but was: %s",
                            TodoItemResolution.DUPLICATE,
                            actual.getStatus()
                    )
                    .isEqualTo(TodoItemResolution.DUPLICATE);

            softAssertions.assertThat(actual.getCloserId())
                    .overridingErrorMessage(
                            "Expected that the closerId is: %d but was: %d",
                            CLOSER_ID,
                            actual.getCloserId()
                    )
                    .isEqualByComparingTo(CLOSER_ID);
        }
    }
}
