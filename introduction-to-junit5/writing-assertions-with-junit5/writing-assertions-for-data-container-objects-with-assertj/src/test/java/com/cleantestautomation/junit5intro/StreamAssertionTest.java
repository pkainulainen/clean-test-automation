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
        void createAndInitializeStream() {
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
        @DisplayName("Should contain the given elements in the given order")
        void shouldContainGivenElementsInGivenOrder() {
            assertThat(stream).containsExactly(first, second);
        }

        @Test
        @DisplayName("Should contain the given elements in any order")
        void shouldContainGivenElementsInAnyOrder() {
            assertThat(stream).containsExactlyInAnyOrder(second, first);
        }

        @Test
        @DisplayName("Should contain the given element once")
        void shouldContainGivenElementOnce() {
            assertThat(stream).containsOnlyOnce(first);
        }

        @Test
        @DisplayName("Shouldn't contain the given element")
        void shouldNotContainGivenElement() {
            assertThat(stream).doesNotContain(new Object());
        }
    }
}
