package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This example demonstrates how you can write assertions
 * for {@code Optional} objects with JUnit 5 assertion API
 */
@DisplayName("Write assertions for Optional objects")
class OptionalAssertionTest {

    @Nested
    @DisplayName("When the optional is empty")
    class WhenOptionalIsEmpty {

        @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
            final Optional<Object> empty = Optional.empty();
            assertTrue(empty.isEmpty());
        }
    }

    @Nested
    @DisplayName("When the optional contains a value")
    class WhenOptionalContainsValue {

        private final String STRING = "object";

        @Test
        @DisplayName("Should contain a value")
        void shouldContainValue() {
            final Optional<Object> actual = Optional.of(STRING);
            assertTrue(actual.isPresent());
        }

        @Test
        @DisplayName("Should contain the correct object")
        void shouldContainCorrectObject() {
            final Optional<Object> actual = Optional.of(STRING);
            assertEquals(STRING, actual.get());
        }
    }
}
