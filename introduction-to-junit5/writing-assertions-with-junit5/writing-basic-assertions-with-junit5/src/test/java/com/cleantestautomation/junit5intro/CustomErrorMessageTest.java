package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This class demonstrates how you can provide a custom error message
 * that is shown when an assertion fails when you are writing your
 * assertions with JUnit 5 assertion API.
 */
@DisplayName("Provide a custom error message")
class CustomErrorMessageTest {

    @Nested
    @DisplayName("When you use a string literal")
    class WhenYouUseStringLiteral {

        @Test
        @DisplayName("Should provide a custom error message")
        void shouldBeFalseWithCustomErrorMessage() {
            assertFalse(false, "The boolean isn't false");
        }
    }

    @Nested
    @DisplayName("When you use String.format()")
    class WhenYouUseStringFormat {

        private final String ACTUAL = "Hello World!";
        private final String EXPECTED = "Hello World!";

        @Test
        @DisplayName("Should provide a custom error message")
        void shouldProvideCustomErrorMessage() {
            assertEquals(EXPECTED,
                    ACTUAL,
                    String.format(
                            "Expected the message to be: %s but was: %s",
                            EXPECTED,
                            ACTUAL
                    )
            );
        }
    }

    @Nested
    @DisplayName("When you use a message supplier")
    class WhenYouUseMessageSupplier {

        private final String ACTUAL = "Hello World!";
        private final String EXPECTED = "Hello World!";

        @Test
        @DisplayName("Should provide a custom error message")
        void shouldProvideCustomErrorMessage() {
            assertEquals(EXPECTED,
                    ACTUAL,
                    () -> String.format(
                            "Expected the message to be: %s but was: %s",
                            EXPECTED,
                            ACTUAL
                    )
            );
        }
    }
}