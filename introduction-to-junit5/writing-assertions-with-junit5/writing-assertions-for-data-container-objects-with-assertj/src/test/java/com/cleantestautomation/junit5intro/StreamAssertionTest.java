package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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

        private final Object FIRST = new Object();
        private final Object SECOND = new Object();

        private Stream<Object> dataStream;

        @BeforeEach
        void createTestData() {
            dataStream = Stream.of(FIRST, SECOND);
        }

        @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
            assertThat(Stream.of()).isEmpty();
        }

        @Test
        @DisplayName("Shouldn't be empty")
        void shouldNotBeEmpty() {
            assertThat(dataStream).isNotEmpty();
        }

        @Test
        @DisplayName("Should contain two elements")
        void shouldContainTwoElements() {
            assertThat(dataStream).hasSize(EXPECTED_NUMBER_OF_ELEMENTS);
        }

        @Test
        @DisplayName("Should contain only the given elements in the given order")
        void shouldContainOnlyGivenElementsInGivenOrder() {
            assertThat(dataStream).containsExactly(FIRST, SECOND);
        }

        @Test
        @DisplayName("Should contain only the given elements in any order")
        void shouldContainOnlyGivenElementsInAnyOrder() {
            assertThat(dataStream).containsExactlyInAnyOrder(SECOND, FIRST);
        }

        @Test
        @DisplayName("Should contain the given element once")
        void shouldContainGivenElementOnce() {
            assertThat(dataStream).containsOnlyOnce(FIRST);
        }

        @Test
        @DisplayName("Shouldn't contain the given element")
        void shouldNotContainGivenElement() {
            assertThat(dataStream).doesNotContain(new Object());
        }
    }
}
