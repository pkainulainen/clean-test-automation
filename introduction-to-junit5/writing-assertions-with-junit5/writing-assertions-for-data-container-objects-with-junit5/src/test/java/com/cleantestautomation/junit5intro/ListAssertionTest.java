package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class demonstrates how you can write assertions for {@code List} objects
 * with JUnit 5 assertion API.
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
           assertTrue(new ArrayList<>().isEmpty());
        }

        @Test
        @DisplayName("Shouldn't be empty")
        void shouldNotBeEmpty() {
            assertFalse(DATA_CONTAINER.isEmpty());
        }

        @Test
        @DisplayName("Should contain two elements")
        void shouldContainTwoElements() {
            assertEquals(EXPECTED_SIZE, DATA_CONTAINER.size());
        }

        @Test
        @DisplayName("Should contain only the expected elements in the given order")
        void shouldContainOnlyExpectedElementsInGivenOrder() {
            assertIterableEquals(List.of(FIRST, SECOND), DATA_CONTAINER);
        }

        @Test
        @DisplayName("Should contain the expected elements in any order")
        void shouldContainExpectedElementsInAnyOrder() {
            assertTrue(DATA_CONTAINER.containsAll(List.of(SECOND, FIRST)));
        }

        @Test
        @DisplayName("Should contain the given element")
        void shouldContainGivenElement() {
            assertTrue(DATA_CONTAINER.contains(FIRST));
        }

        @Test
        @DisplayName("Shouldn't contain the given element")
        void shouldNotContainGivenElement() {
            assertFalse(DATA_CONTAINER.contains(new Object()));
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
                assertTrue(ACTUAL.equals(EXPECTED));
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
                assertFalse(ACTUAL.equals(UNEXPECTED));
            }
        }
    }
}
