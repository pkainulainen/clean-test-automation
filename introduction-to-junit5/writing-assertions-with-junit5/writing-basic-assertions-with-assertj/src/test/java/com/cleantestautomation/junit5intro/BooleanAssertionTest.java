package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how you can write assertions for
 * booleans with AssertJ.
 */
@DisplayName("Write assertions for booleans")
class BooleanAssertionTest {

    @Nested
    @DisplayName("When boolean is false")
    class WhenBooleanIsFalse {

        @Test
        @DisplayName("Should be false")
        void shouldBeFalse() {
            assertThat(false).isFalse();
        }

        @Test
        @DisplayName("Should be false (with custom error message)")
        void shouldBeFalseWithCustomErrorMessage() {
            assertThat(false)
                    .overridingErrorMessage("The boolean is not false")
                    .isFalse();
        }
    }

    @Nested
    @DisplayName("When boolean is true")
    class WhenBooleanIsTrue {

        @Test
        @DisplayName("Should be true")
        void shouldBeTrue() {
            assertThat(true).isTrue();
        }

        @Test
        @DisplayName("Should be true (with custom error message)")
        void shouldBeTrueWithCustomErrorMessage() {
            assertThat(true)
                    .overridingErrorMessage("The boolean is not true")
                    .isTrue();
        }
    }
}
