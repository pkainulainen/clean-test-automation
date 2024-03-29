package com.cleantestautomation.junit5intro;

import org.assertj.core.api.SoftAssertions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

/**
 * This class demonstrates how you can write custom assertions
 * for {@link TodoItem} objects.
 */
public final class TodoItemAssert {

    private final TodoItem actual;

    private TodoItemAssert(TodoItem actual) {
        this.actual = actual;
    }

    /**
     * Creates a new assertion object.
     * @param actual    The actual todo item.
     * @return  Returns the created assertion object.
     */
    public static TodoItemAssert assertThatTodoItem(TodoItem actual) {
        return new TodoItemAssert(actual);
    }

    /**
     * Ensures that the actual todo item has the expected title.
     * @param expectedTitle The expected title.
     * @return  A reference to an assertion object which can be
     *          used for chaining assertions.
     */
    public TodoItemAssert hasTitle(String expectedTitle) {
        assertThat(actual.getTitle())
                .as("title")
                .isEqualTo(expectedTitle);
        return this;
    }

    /**
     * Ensures that the actual todo item is open.
     * @return  A reference to an assertion object which can be
     *          used for chaining assertions.
     */
    public TodoItemAssert isOpen() {
        assertSoftly((softAssertions) -> {
            softAssertions.assertThat(actual.getStatus())
                    .overridingErrorMessage(
                            "Expected that the status is: %s but was: %s",
                            TodoItemStatus.OPEN,
                            actual.getStatus()
                    )
                    .isEqualTo(TodoItemStatus.OPEN);

            softAssertions.assertThat(actual.getResolution())
                    .overridingErrorMessage(
                            "Expected that the resolution is null but was: %s",
                            actual.getStatus()
                    )
                    .isNull();

            softAssertions.assertThat(actual.getCloserId())
                    .overridingErrorMessage(
                            "Expected that the closerId is null but was: %d",
                            actual.getCloserId()
                    )
                    .isNull();
        });

        return this;
    }

    /**
     * Ensures that the actual todo item was closed as a duplicate
     * by the specified user.
     * @param expectedCloserId  The user id of the user who closed the task.
     * @return  A reference to an assertion object which can be
     *          used for chaining assertions.
     */
    public TodoItemAssert wasClosedAsDuplicateByUser(Long expectedCloserId) {
        assertSoftly((softAssertions) -> {
            softAssertions.assertThat(actual.getStatus())
                    .overridingErrorMessage(
                            "Expected that the status is: %s but was: %s",
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
                            expectedCloserId,
                            actual.getCloserId()
                    )
                    .isEqualByComparingTo(expectedCloserId);
        });

        return this;
    }
}
