package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This test class demonstrates how you can pass arguments to your
 * parameterized test method by using the {@link CsvSource} annotation.
 */
@DisplayName("Should pass the arguments provided by the @CsvSource annotation")
class CsvSourceExampleTest {

    @DisplayName("Should parse the arguments from a CSV line")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5"
    })
    void shouldParseArgumentsFromCsvLine(int a, int b, int sum) {
        assertEquals(sum, a + b);
    }
}