package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how you can provide a custom error message
 * that is shown when an assertion fails.
 */
@DisplayName("Provide a custom error message")
class CustomErrorMessageTest {

    @Nested
    @DisplayName("When you provide only the description")
    class WhenYouProvideOnlyDescription {

        @Test
        @DisplayName("Should override only the description")
        void shouldBeFalseWithCustomDescription() {
            assertThat(false)
                    .as("boolean")
                    .isFalse();
        }
    }

    @Nested
    @DisplayName("When you provide the entire error message")
    class WhenYouProvideEntireErrorMessage {

        @Test
        @DisplayName("Should override entire error message")
        void shouldBeFalseWithCustomErrorMessage() {
            assertThat(false)
                    .overridingErrorMessage("The boolean is not false")
                    .isFalse();
        }
    }
}