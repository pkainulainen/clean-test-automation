package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * This class demonstrates how you can provide a custom error message
 * that is shown when an assertion fails when you are writing your
 * assertions with Hamcrest
 */
@DisplayName("Provide a custom error message")
class CustomErrorMessageTest {

    @Nested
    @DisplayName("When you provide a hard-coded string")
    class WhenYouProvideHardCodedString {

        @Test
        @DisplayName("Should provide custom error message")
        void shouldBeFalseWithCustomErrorMessage() {
            assertThat("The boolean isn't false", false, is(false));
        }
    }

    @Nested
    @DisplayName("When you use String.format()")
    class WhenYouUseStringFormat {

        private final String ACTUAL = "Hello World!";
        private final String EXPECTED = "Hello World!";

        @Test
        @DisplayName("Should provide custom error message")
        void shouldReturnExpectedMessageWithCustomErrorMessage() {
            assertThat(
                    String.format(
                            "Expected the message to be: %s but was: %s",
                            EXPECTED,
                            ACTUAL
                    ),
                    ACTUAL,
                    equalTo(EXPECTED)
            );
        }
    }
}