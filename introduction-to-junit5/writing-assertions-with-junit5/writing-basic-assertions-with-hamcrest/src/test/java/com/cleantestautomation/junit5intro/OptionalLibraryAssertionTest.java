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
    @DisplayName("When the optional is not empty")
    class WhenOptionalIsNotEmpty {

        private final String STRING = "object";

        @Test
        @DisplayName("Should be present")
        void shouldBePresent() {
            final Optional<Object> actual = Optional.of(STRING);
            assertThat(actual, isPresent());
        }

        @Test
        @DisplayName("Should be present (with custom error message)")
        void shouldBePresentWithCustomErrorMessage() {
            final Optional<Object> actual = Optional.of(STRING);
            assertThat("Expected optional to not be empty but it was empty",
                    actual,
                    isPresent()
            );
        }

        @Test
        @DisplayName("Should contain the correct object")
        void shouldContainCorrectObject() {
            final Optional<Object> actual = Optional.of(STRING);
            assertThat(actual, isPresentAndIs(STRING));
        }

        @Test
        @DisplayName("Should contain the correct object (with custom error message)")
        void shouldContainCorrectObjectWithCustomErrorMessage() {
            final Optional<Object> actual = Optional.of(STRING);
            assertThat(
                    String.format(
                            "Expected optional to contain the string: %s but it contained the string: %s",
                            STRING,
                            actual.get()
                    ),
                    actual,
                    isPresentAndIs(STRING)
            );
        }
    }
}
