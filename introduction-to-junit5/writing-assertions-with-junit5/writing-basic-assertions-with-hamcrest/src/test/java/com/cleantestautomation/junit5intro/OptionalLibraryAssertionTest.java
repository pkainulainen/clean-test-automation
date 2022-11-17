package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.github.npathai.hamcrestopt.OptionalMatchers.isEmpty;
import static com.github.npathai.hamcrestopt.OptionalMatchers.isPresent;
import static com.github.npathai.hamcrestopt.OptionalMatchers.isPresentAndIs;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This example demonstrates how you can write assertions
 * for {@code Optional} objects with Hamcrest and Hamcrest
 * Optional library.
 */
@DisplayName("Write assertions for Optional objects")
class OptionalLibraryAssertionTest {

    @Nested
    @DisplayName("When the optional is empty")
    class WhenOptionalIsEmpty {

        @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
            final Optional<Object> empty = Optional.empty();
            assertThat(empty, isEmpty());
        }

        @Test
        @DisplayName("Should be empty (with custom error message)")
        void shouldBeEmptyWithCustomErrorMessage() {
            final Optional<Object> empty = Optional.empty();
            assertThat(String.format("Expected optional to be empty but it was: %s", empty),
                    empty,
                    isEmpty()
            );
        }
    }

    @Nested
    @DisplayName("When the optional isn't empty")
    class WhenOptionalIsNotEmpty {

        private final String STRING = "object";

        @Test
        @DisplayName("Should be present")
        void shouldBePresent() {
            final Optional<Object> actual = Optional.of(STRING);
            assertThat(actual, isPresent());
        }

        @Test
        @DisplayName("Should contain the correct object")
        void shouldContainCorrectObject() {
            final Optional<Object> actual = Optional.of(STRING);
            assertThat(actual, isPresentAndIs(STRING));
        }
    }
}
