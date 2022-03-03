package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.BeforeEach;
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

        private Object first;
        private Object second;

        private List<Object> list;

        @BeforeEach
        void createAndInitializeList() {
            first = new Object();
            second = new Object();

            list = Arrays.asList(first, second);
        }

        @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
            assertThat(new ArrayList<>()).isEmpty();
        }

        @Test
        @DisplayName("Shouldn't be empty")
        void shouldNotBeEmpty() {
            assertThat(list).isNotEmpty();
        }

        @Test
        @DisplayName("Should contain two elements")
        void shouldContainTwoElements() {
            assertThat(list).hasSize(EXPECTED_SIZE);
        }

        @Test
        @DisplayName("Should contain the correct elements in the given order")
        void shouldContainCorrectElementsInGivenOrder() {
            assertThat(list).containsExactly(first, second);
        }

        @Test
        @DisplayName("Should contain the correct elements in any order")
        void shouldContainCorrectElementsInAnyOrder() {
            assertThat(list).containsExactlyInAnyOrder(second, first);
        }

        @Test
        @DisplayName("Should contain the correct element once")
        void shouldContainCorrectElementOnce() {
            assertThat(list).containsOnlyOnce(first);
        }

        @Test
        @DisplayName("Should not contain an incorrect element")
        void shouldNotContainIncorrectElement() {
            assertThat(list).doesNotContain(new Object());
        }
    }

    @Nested
    @DisplayName("When you compare two lists")
    class WhenYouCompareTwoLists {

        private final List<Integer> FIRST = Arrays.asList(1, 2, 3);
        private final List<Integer> SECOND = Arrays.asList(1, 2, 3);

        @Test
        @DisplayName("Should contain the same elements")
        void shouldContainSameElements() {
            assertThat(FIRST).isEqualTo(SECOND);
        }
    }
}
