package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This test class demonstrates how you can pass arguments to your
 * parameterized test method by using a custom {@link ArgumentsProvider}.
 */
@DisplayName("Should pass the arguments provided by the CustomArgumentProvider class")
class ArgumentsSourceExampleTest {

    @DisplayName("Should use the arguments provided by the CustomArgumentProvider")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @ArgumentsSource(CustomArgumentsProvider.class)
    void shouldUseArgumentsProvidedByCustomArgumentProvider(int a, int b, int sum) {
        assertEquals(sum, a + b);
    }
}