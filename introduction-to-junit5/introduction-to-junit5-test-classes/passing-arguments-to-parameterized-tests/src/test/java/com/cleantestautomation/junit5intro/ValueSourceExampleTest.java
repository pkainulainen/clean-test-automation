package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This test class demonstrates how you can pass arguments to your
 * parameterized test method by using the {@link ValueSource} annotation.
 */
@DisplayName("Should pass the arguments provided by the @ValueSource annotation")
class ValueSourceExampleTest {

    @DisplayName("Should pass a non-null message to your test method")
    @ParameterizedTest(name = "{index} => message=''{0}''")
    @ValueSource(strings = {"Hello", "World"})
    void shouldPassNonNullMessageAsArgument(String message) {
        assertNotNull(message);
    }
}