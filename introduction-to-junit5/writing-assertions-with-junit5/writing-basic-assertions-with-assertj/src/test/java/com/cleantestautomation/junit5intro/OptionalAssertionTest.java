package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This example demonstrates how you can write assertions
 * for {@code Optional} objects with AssertJ.
 */
@DisplayName("Write assertions for Optional objects")
class OptionalAssertionTest {

    @Nested
    @DisplayName("When the optional is empty")
    class WhenOptionalIsEmpty {

        @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
            assertThat(Optional.empty()).isEmpty();
        }
    }

    @Nested
    @DisplayName("When the optional contains a value")
    class WhenOptionalContainsValue {

        private final Object OBJECT = new Object();

        @Test
        @DisplayName("Should contain a value")
        void shouldContainValue() {
            assertThat(Optional.of(OBJECT)).isPresent();
        }

        @Test
        @DisplayName("Should contain the correct object")
        void shouldContainCorrectObject() {
            assertThat(Optional.of(OBJECT)).contains(OBJECT);
        }
    }
}
