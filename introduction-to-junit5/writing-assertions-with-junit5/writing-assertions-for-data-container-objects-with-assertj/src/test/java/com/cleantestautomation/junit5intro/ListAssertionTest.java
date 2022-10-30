package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how you can write assertions for {@code List} objects
 * with AssertJ.
 */
@DisplayName("Write assertions for lists")
class ListAssertionTest {

    @Nested
    @DisplayName("When you write assertions for elements")
    class WhenYouWriteAssertionsForElements {

        private final int EXPECTED_SIZE = 2;

        private final Object FIRST = new Object();
        private final Object SECOND = new Object();

        private final List<Object> LIST = Arrays.asList(FIRST, SECOND);

        @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
            assertThat(new ArrayList<>()).isEmpty();
        }

        @Test
        @DisplayName("Shouldn't be empty")
        void shouldNotBeEmpty() {
            assertThat(LIST).isNotEmpty();
        }

        @Test
        @DisplayName("Should contain two elements")
        void shouldContainTwoElements() {
            assertThat(LIST).hasSize(EXPECTED_SIZE);
        }

        @Test
        @DisplayName("Should contain only the expected elements in the given order")
        void shouldContainOnlyExpectedElementsInGivenOrder() {
            assertThat(LIST).containsExactly(FIRST, SECOND);
        }

        @Test
        @DisplayName("Should contain only the expected elements in any order")
        void shouldContainOnlyExpectedElementsInAnyOrder() {
            assertThat(LIST).containsExactlyInAnyOrder(SECOND, FIRST);
        }

        @Test
        @DisplayName("Should contain the given element once")
        void shouldContainGivenElementOnce() {
            assertThat(LIST).containsOnlyOnce(FIRST);
        }

        @Test
        @DisplayName("Shouldn't contain the given element")
        void shouldNotContainGivenElement() {
            assertThat(LIST).doesNotContain(new Object());
        }
    }

    @Nested
    @DisplayName("When you compare two lists")
    class WhenYouCompareTwoLists {

        @Nested
        @DisplayName("When the lists are equal")
        class WhenListsAreEqual {

            private final List<Integer> FIRST = Arrays.asList(1, 2, 3);
            private final List<Integer> SECOND = Arrays.asList(1, 2, 3);

            @Test
            @DisplayName("Should contain the same elements")
            void shouldContainSameElements() {
                assertThat(FIRST).isEqualTo(SECOND);
            }
        }

        @Nested
        @DisplayName("When the lists aren't equal")
        class WhenListsAreNotEqual {

            private final List<Integer> FIRST = Arrays.asList(1, 2, 3);
            private final List<Integer> UNEXPECTED = Arrays.asList(4, 5, 6);

            @Test
            @DisplayName("Shouldn't contain the same elements")
            void shouldNotContainSameElements() {
                assertThat(FIRST).isNotEqualTo(UNEXPECTED);
            }
        }
    }
}
