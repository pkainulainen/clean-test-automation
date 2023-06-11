package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Tests for the calculator")
class CalculatorTest {

    @Nested
    @DisplayName("Returns the sum of two numbers")
    class Sum {

        @DisplayName("Should return the correct sum")
        @ParameterizedTest(name = "{0} + {1} must be: {2}")
        void shouldReturnCorrectSum(long a, long b, long expectedSum) {
            long actualSum = Calculator.sum(a, b);
            assertThat(actualSum).isEqualByComparingTo(expectedSum);
        }
    }
}
