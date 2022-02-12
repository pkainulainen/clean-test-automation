package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This test class demonstrates how you can read the arguments
 * passed to your parameterized test method from a CSV file.
 */
@DisplayName("Should pass the method arguments found from a CSV file")
class CsvFileSourceExampleTest {

    @DisplayName("Should read the method arguments from a CSV file")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvFileSource(resources = "/test-data.csv")
    void shouldReadMethodArgumentsFromCsvFile(int a, int b, int sum) {
        assertEquals(sum, a + b);
    }
}