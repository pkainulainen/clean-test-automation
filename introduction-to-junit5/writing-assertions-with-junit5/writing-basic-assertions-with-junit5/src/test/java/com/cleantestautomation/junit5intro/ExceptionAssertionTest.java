package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This class demonstrates how you can write assertions for the
 * exceptions thrown by the system under test with JUnit 5 assertion
 * API.
 */
@DisplayName("Write assertions for exceptions")
class ExceptionAssertionTest {

    @Nested
    @DisplayName("When the system under test throws the correct exception")
    class WhenSystemUnderTestThrowsException {

        @Test
        @DisplayName("Should throw the correct exception")
        void shouldThrowCorrectException() {
            assertThrows(NullPointerException.class,
                    () -> { throw new NullPointerException(); }
            );
        }
    }

    @Nested
    @DisplayName("When the system under test throws the correct exception that has the correct message")
    class WhenSystemUnderTestThrowsCorrectExceptionWithCorrectMessage {

        @Test
        @DisplayName("Should throw the correct exception that has the correct message")
        void shouldThrowCorrectExceptionWithCorrectMessage() {
            final NullPointerException thrown = assertThrows(NullPointerException.class,
                    () -> { throw new NullPointerException("Hello World!"); }
            );
            assertEquals("Hello World!", thrown.getMessage());
        }
    }
}
