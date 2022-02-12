package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This test class demonstrates how you can pass arguments to your parameterized
 * test method by using a factory method.
 */
@DisplayName("Should pass the arguments provided by the sumProvider() method")
class MethodSourceExampleTest {

    @DisplayName("Should use the arguments provided by the sumProvider() method")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @MethodSource("sumProvider")
    void shouldUseArgumentsProvidedBySumProviderMethod(int a, int b, int sum) {
        assertEquals(sum, a + b);
    }

    private static Stream<Arguments> sumProvider() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(2, 3, 5)
        );
    }
}