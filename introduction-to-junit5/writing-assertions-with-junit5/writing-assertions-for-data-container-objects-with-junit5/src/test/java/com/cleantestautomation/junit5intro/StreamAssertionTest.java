package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class demonstrates how you can write assertions for {@code Stream} objects
 * with JUnit 5 assertion API.
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
            assertEquals(0, Stream.of().count());
        }

        @Test
        @DisplayName("Shouldn't be empty")
        void shouldNotBeEmpty() {
            assertTrue(dataStream.count() > 0);
        }

        @Test
        @DisplayName("Should contain two elements")
        void shouldContainTwoElements() {
            assertEquals(EXPECTED_NUMBER_OF_ELEMENTS, dataStream.count());
        }

        @Test
        @DisplayName("Should contain the given elements in the given order")
        void shouldContainGivenElementsInGivenOrder() {
            assertTrue(dataStream.collect(Collectors.toList()).equals(List.of(FIRST, SECOND)));
        }

        @Test
        @DisplayName("Should contain the given elements in any order")
        void shouldContainGivenElementsInAnyOrder() {
            boolean containElements = dataStream.allMatch(candidate -> candidate.equals(SECOND) || candidate.equals(FIRST));
            assertTrue(containElements);
        }

        @Test
        @DisplayName("Should contain the given element")
        void shouldContainGivenElement() {
            boolean containsElement = dataStream.anyMatch(candidate -> candidate.equals(FIRST));
            assertTrue(containsElement);
        }

        @Test
        @DisplayName("Shouldn't contain the given element")
        void shouldNotContainGivenElement() {
            Object unknown = new Object();
            boolean doesNotContainElement = dataStream.noneMatch(candidate -> candidate.equals(unknown));
            assertTrue(doesNotContainElement);
        }
    }
}