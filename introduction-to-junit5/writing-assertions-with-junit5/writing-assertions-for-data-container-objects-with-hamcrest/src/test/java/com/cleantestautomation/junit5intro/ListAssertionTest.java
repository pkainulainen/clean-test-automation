package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;

/**
 * This class demonstrates how you can write assertions for {@code List} objects
 * with Hamcrest.
 */
@DisplayName("Write assertions for lists")
class ListAssertionTest {

    @Nested
    @DisplayName("When you write assertions for elements")
    class WhenYouWriteAssertionsForElements {

        private final int EXPECTED_SIZE = 2;

        private final Object FIRST = new Object();
        private final Object SECOND = new Object();

        private final List<Object> DATA_CONTAINER = List.of(FIRST, SECOND);

        @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
            assertThat(new ArrayList<>(), empty());
        }

        @Test
        @DisplayName("Shouldn't be empty")
        void shouldNotBeEmpty() {
            assertThat(DATA_CONTAINER, not(empty()));
        }

        @Test
        @DisplayName("Should contain two elements")
        void shouldContainTwoElements() {
            assertThat(DATA_CONTAINER, hasSize(EXPECTED_SIZE));
        }

        @Test
        @DisplayName("Should contain only the expected elements in the given order")
        void shouldContainOnlyExpectedElementsInGivenOrder() {
            assertThat(DATA_CONTAINER, contains(FIRST, SECOND));
        }

        @Test
        @DisplayName("Should contain only the expected elements in any order")
        void shouldContainOnlyExpectedElementsInAnyOrder() {
            assertThat(DATA_CONTAINER, containsInAnyOrder(SECOND, FIRST));
        }

        @Test
        @DisplayName("Should contain the given element")
        void shouldContainGivenElement() {
            assertThat(DATA_CONTAINER, hasItem(FIRST));
        }

        @Test
        @DisplayName("Shouldn't contain the given element")
        void shouldNotContainGivenElement() {
            assertThat(DATA_CONTAINER, not(hasItem(new Object())));
        }
    }

    @Nested
    @DisplayName("When you compare two lists")
    class WhenYouCompareTwoLists {

        @Nested
        @DisplayName("When the lists are equal")
        class WhenListsAreEqual {

            private final List<Integer> ACTUAL = List.of(1, 2, 3);
            private final List<Integer> EXPECTED = List.of(1, 2, 3);

            @Test
            @DisplayName("Should contain the same elements")
            void shouldContainSameElements() {
                assertThat(ACTUAL, equalTo(EXPECTED));
            }
        }

        @Nested
        @DisplayName("When the lists aren't equal")
        class WhenListsAreNotEqual {

            private final List<Integer> ACTUAL = List.of(1, 2, 3);
            private final List<Integer> UNEXPECTED = List.of(4, 5, 6);

            @Test
            @DisplayName("Shouldn't contain the same elements")
            void shouldNotContainSameElements() {
                assertThat(ACTUAL, not(UNEXPECTED));
            }
        }
    }
}
