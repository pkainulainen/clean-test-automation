package com.cleantestautomation.junit5intro;

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

        private final Stream<Object> STREAM = Stream.of(FIRST, SECOND);

        @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
            assertTrue(toObjectList(Stream.of()).isEmpty());
        }

        @Test
        @DisplayName("Shouldn't be empty")
        void shouldNotBeEmpty() {
            assertFalse(toObjectList(STREAM).isEmpty());
        }

        @Test
        @DisplayName("Should contain two elements")
        void shouldContainTwoElements() {
            assertEquals(EXPECTED_NUMBER_OF_ELEMENTS, toObjectList(STREAM).size());
        }

        @Test
        @DisplayName("Should contain the given elements in the given order")
        void shouldContainGivenElementsInGivenOrder() {
            assertTrue(toObjectList(STREAM).equals(List.of(FIRST, SECOND)));
        }

        @Test
        @DisplayName("Should contain the given elements in any order")
        void shouldContainGivenElementsInAnyOrder() {
            assertTrue(toObjectList(STREAM).containsAll(List.of(SECOND, FIRST)));
        }

        @Test
        @DisplayName("Should contain the given element")
        void shouldContainGivenElement() {
            assertTrue(toObjectList(STREAM).contains(FIRST));
        }

        @Test
        @DisplayName("Shouldn't contain the given element")
        void shouldNotContainGivenElement() {
            assertFalse(toObjectList(STREAM).contains(new Object()));
        }

        private List<Object> toObjectList(Stream<Object> stream) {
            return stream.collect(Collectors.toList());
        }
    }
}
