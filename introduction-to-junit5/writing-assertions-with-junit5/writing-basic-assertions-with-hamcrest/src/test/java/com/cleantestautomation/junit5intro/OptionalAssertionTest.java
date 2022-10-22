package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * This example demonstrates how you can write assertions
 * for {@code Optional} objects with Hamcrest.
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
            assertThat(empty.isEmpty(), is(true));
        }

        @Test
        @DisplayName("Should be empty (with custom error message)")
        void shouldBeEmptyWithCustomErrorMessage() {
            final Optional<Object> empty = Optional.empty();
            assertThat(String.format("Expected optional to be empty but it was: %s", empty),
                    empty.isEmpty(),
                    is(true)
            );
        }
    }

    @Nested
    @DisplayName("When the contains a value")
    class WhenOptionalContainsValue {

        private final String STRING = "object";

        @Test
        @DisplayName("Should contain a value")
        void shouldContainValue() {
            final Optional<Object> actual = Optional.of(STRING);
            assertThat(actual.isPresent(), is(true));
        }

        @Test
        @DisplayName("Should contain a value (with custom error message)")
        void shouldContainValueWithCustomErrorMessage() {
            final Optional<Object> actual = Optional.of(STRING);
            assertThat("Expected optional to contain a value but it was empty",
                    actual.isPresent(),
                    is(true)
            );
        }

        @Test
        @DisplayName("Should contain the correct object")
        void shouldContainCorrectObject() {
            final Optional<Object> actual = Optional.of(STRING);
            assertThat(actual.get(), equalTo(STRING));
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
                    actual.get(),
                    equalTo(STRING)
            );
        }
    }
}
