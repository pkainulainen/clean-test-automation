package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how you can write assertions for {@code Stream} objects
 * with AssertJ.
 */
@DisplayName("Write assertions for streams")
class StreamAssertionTest {

    @Nested
    @DisplayName("When you write assertions for elements")
    class WhenYouWriteAssertionsForElements {

        private final int EXPECTED_NUMBER_OF_ELEMENTS = 2;

        private Object first;
        private Object second;

        private Stream<Object> stream;

        @BeforeEach
        void createAndInitializeList() {
            first = new Object();
            second = new Object();

            stream = Stream.of(first, second);
        }

        @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
            assertThat(Stream.of()).isEmpty();
        }

        @Test
        @DisplayName("Shouldn't be empty")
        void shouldNotBeEmpty() {
            assertThat(stream).isNotEmpty();
        }

        @Test
        @DisplayName("Should contain two elements")
        void shouldContainTwoElements() {
            assertThat(stream).hasSize(EXPECTED_NUMBER_OF_ELEMENTS);
        }

        @Test
        @DisplayName("Should contain two elements (with custom error message)")
        void shouldContainTwoElementsWithCustomErrorMessage() {
            assertThat(stream)
                    .overridingErrorMessage(
                            "Incorrect number of elements. Expected that the stream has: %d elements",
                            EXPECTED_NUMBER_OF_ELEMENTS
                    )
                    .hasSize(EXPECTED_NUMBER_OF_ELEMENTS);
        }

        @Test
        @DisplayName("Should contain the correct elements in the given order")
        void shouldContainCorrectElementsInGivenOrder() {
            assertThat(stream).containsExactly(first, second);
        }

        @Test
        @DisplayName("Should contain the correct elements in the given order (with custom error message)")
        void shouldContainCorrectElementsInGivenOrderWithCustomErrorMessage() {
            assertThat(stream)
                    .overridingErrorMessage(
                            "Incorrect elements. Expected the stream to contain the elements: %s and %s",
                            first,
                            second
                    )
                    .containsExactly(first, second);
        }

        @Test
        @DisplayName("Should contain the correct elements in any order")
        void shouldContainCorrectElementsInAnyOrder() {
            assertThat(stream).containsExactlyInAnyOrder(second, first);
        }

        @Test
        @DisplayName("Should contain the correct elements in any order (with custom error message)")
        void shouldContainCorrectElementsInAnyWithCustomErrorMessage() {
            assertThat(stream)
                    .overridingErrorMessage(
                            "Incorrect elements. Expected the stream to contain the elements: %s and %s in any order",
                            second,
                            first
                    )
                    .containsExactlyInAnyOrder(second, first);
        }

        @Test
        @DisplayName("Should contain the correct element once")
        void shouldContainCorrectElementOnce() {
            assertThat(stream).containsOnlyOnce(first);
        }

        @Test
        @DisplayName("Should contain the correct element once (with custom error message)")
        void shouldContainCorrectElementOnceWithCustomErrorMessage() {
            assertThat(stream)
                    .overridingErrorMessage(
                            "Expected that the stream contains the element: %s only once",
                            first
                    )
                    .containsOnlyOnce(first);
        }

        @Test
        @DisplayName("Should not contain an incorrect element")
        void shouldNotContainIncorrectElement() {
            assertThat(stream).doesNotContain(new Object());
        }

        @Test
        @DisplayName("Should not contain an incorrect element (with custom error message)")
        void shouldNotContainIncorrectElementWithCustomErrorMessage() {
            Object incorrect = new Object();
            assertThat(stream)
                    .overridingErrorMessage(
                            "Expected the stream to not contain the element: %s",
                            incorrect
                    )
                    .doesNotContain(incorrect);
        }
    }
}
