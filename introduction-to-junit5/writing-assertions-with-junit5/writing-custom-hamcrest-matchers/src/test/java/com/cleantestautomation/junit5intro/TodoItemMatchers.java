package com.cleantestautomation.junit5intro;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Contains custom Hamcrest matchers which allows you to
 * write assertions for the state of a {@link TodoItem}
 * object.
 */
public class TodoItemMatchers {

    /**
     * Creates a new Hamcrest matcher which ensures that the examined
     * {@link TodoItem} is open.
     * @return
     */
    public static TypeSafeMatcher<TodoItem> isOpen() {
        return new IsOpenMatcher();
    }

    /**
     * A custom hamcrest matcher which ensures that the examined
     * {@link TodoItem} is open.
     */
    private static class IsOpenMatcher extends TypeSafeMatcher<TodoItem> {

        @Override
        protected boolean matchesSafely(TodoItem actual) {
            if (actual.getStatus() == TodoItemStatus.OPEN &&
                    actual.getResolution() == null &&
                    actual.getCloserId() == null) {
                return true;
            }

            return false;
        }

        @Override
        public void describeTo(Description description) {
            description.appendText(String.format(
                    "an open todo item must have the status: %s, resolution: %s and closerId: %d",
                    TodoItemStatus.OPEN,
                    null,
                    null
            ));
        }

        @Override
        protected void describeMismatchSafely(TodoItem actual, Description mismatchDescription) {
            mismatchDescription.appendText(String.format(
                    "had the status: %s, resolution: %s, and closerId: %d",
                    actual.getStatus(),
                    actual.getResolution(),
                    actual.getCloserId()
            ));
        }
    }

    /**
     * Creates a new Hamcrest matcher which ensures that the examined
     * {@link TodoItem} was closed as a duplicate by the specified user.
     * @param expectedCloserId  The user id of the user who closed the examined
     *                          {@link TodoItem}.
     * @return
     */
    public static TypeSafeMatcher<TodoItem>wasClosedAsDuplicateByUser(Long expectedCloserId) {
        return new WasClosedAsDuplicateByUserMatcher(expectedCloserId);
    }

    /**
     * A custom Hamcrest matcher which ensures that the examined
     * {@link TodoItem} was closed as a duplicate by the specified
     * user.
     */
    private static class WasClosedAsDuplicateByUserMatcher extends TypeSafeMatcher<TodoItem> {

        private final Long expectedCloserId;

        private WasClosedAsDuplicateByUserMatcher(Long expectedCloserId) {
            this.expectedCloserId = expectedCloserId;
        }

        @Override
        protected boolean matchesSafely(TodoItem actual) {
            if (actual.getStatus() == TodoItemStatus.CLOSED &&
                    actual.getResolution() == TodoItemResolution.DUPLICATE &&
                    actual.getCloserId().equals(expectedCloserId)) {
                return true;
            }

            return false;
        }

        @Override
        public void describeTo(Description description) {
            description.appendText(String.format(
                    "a todo item that was closed as duplicate by the specified user must have the status: %s, resolution: %s and closerId: %d",
                    TodoItemStatus.CLOSED,
                    TodoItemResolution.DUPLICATE,
                    expectedCloserId
            ));
        }

        @Override
        protected void describeMismatchSafely(TodoItem actual, Description mismatchDescription) {
            mismatchDescription.appendText(String.format(
                    "had the status: %s, resolution: %s, and closerId: %d",
                    actual.getStatus(),
                    actual.getResolution(),
                    actual.getCloserId()
            ));
        }
    }
}
