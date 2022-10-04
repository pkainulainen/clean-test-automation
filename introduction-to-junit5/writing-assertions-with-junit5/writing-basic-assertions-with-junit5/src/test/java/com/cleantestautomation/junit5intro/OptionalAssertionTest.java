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

        @Test
        @DisplayName("Should be empty (with custom error message)")
        void shouldBeEmptyWithCustomErrorMessage() {
            final Optional<Object> empty = Optional.empty();
            assertTrue(empty.isEmpty(),
                    String.format("Expected optional to be empty but it was: %s", empty)
            );
        }
    }

    @Nested
    @DisplayName("When the optional is not empty")
    class WhenOptionalIsNotEmpty {

        private final String STRING = "object";

        @Test
        @DisplayName("Should not be empty")
        void shouldNotBeEmpty() {
            final Optional<Object> actual = Optional.of(STRING);
            assertFalse(actual.isEmpty());
        }

        @Test
        @DisplayName("Should not be empty (with custom error message)")
        void shouldNotBeEmptyWithCustomErrorMessage() {
            final Optional<Object> actual = Optional.of(STRING);
            assertFalse(actual.isEmpty(),
                    "Expected optional to not be empty but it was empty"
            );
        }

        @Test
        @DisplayName("Should contain the correct object")
        void shouldContainCorrectObject() {
            final Optional<Object> actual = Optional.of(STRING);
            assertEquals(STRING, actual.get());
        }

        @Test
        @DisplayName("Should contain the correct object (with custom error message)")
        void shouldContainCorrectObjectWithCustomErrorMessage() {
            final Optional<Object> actual = Optional.of(STRING);
            assertEquals(STRING,
                    actual.get(),
                    String.format(
                            "Expected optional to contain the string: %s but it contained the string: %s",
                            STRING,
                            actual.get()
                    )
            );
        }
    }
}
