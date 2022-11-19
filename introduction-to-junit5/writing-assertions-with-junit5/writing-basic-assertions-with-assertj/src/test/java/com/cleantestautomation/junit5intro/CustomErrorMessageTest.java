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
    @DisplayName("When you provide only description")
    class WhenYouProvideOnlyDescription {

        @Test
        @DisplayName("Should provide description")
        void shouldProvideOnlyDescription() {
            assertThat(false)
                    .as("boolean")
                    .isFalse();
        }
    }

    @Nested
    @DisplayName("When you provide the entire error message")
    class WhenYouProvideEntireErrorMessage {

        @Nested
        @DisplayName("When you use a string literal")
        class WhenYouUseStringLiteral {

            @Test
            @DisplayName("Should override entire error message")
            void shouldOverrideEntireErrorMessage() {
                assertThat(false)
                        .overridingErrorMessage("The boolean is not false")
                        .isFalse();
            }
        }

        @Nested
        @DisplayName("When you use String.format()")
        class WhenYouUseStringFormat {

            private final String ACTUAL = "Foo";
            private final String EXPECTED = "Foo";

            @Test
            @DisplayName("Should override entire error message")
            void shouldOverrideEntireErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected the object to be: %s but it was: %s",
                                EXPECTED,
                                ACTUAL
                        )
                        .isEqualTo(EXPECTED);
            }
        }

        @Nested
        @DisplayName("When you use a message supplier")
        class WhenYouUseMessageSupplier {

            private final String ACTUAL = "Foo";
            private final String EXPECTED = "Foo";

            @Test
            @DisplayName("Should override entire error message")
            void shouldOverrideEntireErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                () -> String.format(
                                        "Expected the object to be: %s but it was: %s",
                                        EXPECTED,
                                        ACTUAL
                                )
                        )
                        .isEqualTo(EXPECTED);
            }
        }
    }
}