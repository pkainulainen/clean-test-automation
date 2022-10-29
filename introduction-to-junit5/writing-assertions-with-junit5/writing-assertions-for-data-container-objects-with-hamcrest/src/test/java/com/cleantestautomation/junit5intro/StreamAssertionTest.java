package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class demonstrates how you can write assertions for {@code Stream} objects
 * with Hamcrest.
 */
@DisplayName("Write assertions for streams")
class StreamAssertionTest {

    @Nested
    @DisplayName("When you write assertions for elements")
    class WhenYouWriteAssertionsForElements {

        private final long EMPTY_STREAM_ELEMENT_COUNT = 0L;
        private final long EXPECTED_NUMBER_OF_ELEMENTS = 2L;

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
            assertThat(Stream.of().count(), equalTo(EMPTY_STREAM_ELEMENT_COUNT));
        }

        @Test
        @DisplayName("Shouldn't be empty")
        void shouldNotBeEmpty() {
            assertThat(dataStream.count(), greaterThan(EMPTY_STREAM_ELEMENT_COUNT));
        }

        @Test
        @DisplayName("Should contain two elements")
        void shouldContainTwoElements() {
            assertThat(dataStream.count(), equalTo(EXPECTED_NUMBER_OF_ELEMENTS));
        }

        @Test
        @DisplayName("Should contain only the given elements in the given order")
        void shouldContainOnlyGivenElementsInGivenOrder() {
            assertThat(dataStream.collect(Collectors.toList()), equalTo(List.of(FIRST, SECOND)));
        }

        @Test
        @DisplayName("Should contain the given elements in any order")
        void shouldContainGivenElementsInAnyOrder() {
            final boolean containElements = dataStream.allMatch(candidate -> candidate.equals(SECOND) || candidate.equals(FIRST));
            assertThat(containElements, is(true));
        }

        @Test
        @DisplayName("Should contain the given element")
        void shouldContainGivenElement() {
            final boolean containsElement = dataStream.anyMatch(candidate -> candidate.equals(FIRST));
            assertThat(containsElement, is(true));
        }

        @Test
        @DisplayName("Shouldn't contain the given element")
        void shouldNotContainGivenElement() {
            final Object unknown = new Object();
            final boolean doesNotContainElement = dataStream.noneMatch(candidate -> candidate.equals(unknown));
            assertThat(doesNotContainElement, is(true));
        }
    }
}
