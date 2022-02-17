package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This test class demonstrates how you can implement a custom {@link MessageConverter}
 * which provides arguments to your parameterized test method.
 */
@DisplayName("Should pass the arguments provided by the MessageConverter class")
class MessageConverterExampleTest {

    @DisplayName("Should use the arguments provided by the MessageConverter class")
    @ParameterizedTest(name = "{index} => actual=''{0}'', expected=''{1}''")
    @CsvSource({
            "Hello, Hello",
            "Hi, Hi",
    })
    void shouldUseArgumentsProvidedByMessageConverterClass(@ConvertWith(MessageConverter.class) Message actual,
                                                           @ConvertWith(MessageConverter.class) Message expected) {
        assertEquals(expected.getMessage(), actual.getMessage());
    }
}
