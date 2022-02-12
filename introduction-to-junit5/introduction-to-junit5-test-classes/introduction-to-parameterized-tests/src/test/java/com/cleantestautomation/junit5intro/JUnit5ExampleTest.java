package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This test class demonstrates how you can write a
 * simple parameterized test with JUnit 5 and customize
 * the display name of each method invocation.
 */
@DisplayName("JUnit 5 Parameterized Test Example")
class JUnit5ExampleTest {

    @DisplayName("Should pass a non-null message to your test method")
    @ParameterizedTest
    @ValueSource(strings = {"Hello", "World"})
    void shouldPassNonNullMessageAsMethodParameter(String message) {
        assertNotNull(message);
    }

    @DisplayName("Should pass a non-null message to your test method")
    @ParameterizedTest(name = "{index} => message=''{0}''")
    @ValueSource(strings = {"Hello", "World"})
    void shouldPassNonNullMessageAsMethodParameterWithCustomInvocationDescription(String message) {
        assertNotNull(message);
    }
}
