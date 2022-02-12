package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This test class demonstrates how you can pass arguments to your
 * parameterized test method by using a custom {@link ArgumentsProvider}.
 */
@DisplayName("Should pass the arguments provided by the CustomArgumentProvider class")
class ArgumentsSourceExampleTest {

    @DisplayName("Should use the arguments provided by the CustomArgumentProvider")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @ArgumentsSource(CustomArgumentProvider.class)
    void shouldUseArgumentsProvidedByCustomArgumentProvider(int a, int b, int sum) {
        assertEquals(sum, a + b);
    }

    static class CustomArgumentProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(1, 1, 2),
                    Arguments.of(2, 3, 5)
            );
        }
    }
}