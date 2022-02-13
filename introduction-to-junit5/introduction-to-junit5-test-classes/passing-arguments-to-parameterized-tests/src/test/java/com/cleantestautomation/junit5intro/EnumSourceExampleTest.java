package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This test class demonstrates how you can pass enum values to
 * your parameterized test methods.
 */
@DisplayName("Pass enum values to your test method")
class EnumSourceExampleTest {

    @DisplayName("Should pass non-null enum values as method arguments")
    @ParameterizedTest(name = "{index} => programmingLanguage=''{0}''")
    @EnumSource(ProgrammingLanguage.class)
    void shouldPassNonNullEnumValuesAsMethodArgument(ProgrammingLanguage programmingLanguage) {
        assertNotNull(programmingLanguage);
    }

    @DisplayName("Should pass only the specified enum value as a method argument")
    @ParameterizedTest(name = "{index} => programmingLanguage=''{0}''")
    @EnumSource(value = ProgrammingLanguage.class, names = {"JAVA"})
    void shouldPassNonNullEnumValueAsMethodArgument(ProgrammingLanguage programmingLanguage) {
        assertNotNull(programmingLanguage);
    }
}