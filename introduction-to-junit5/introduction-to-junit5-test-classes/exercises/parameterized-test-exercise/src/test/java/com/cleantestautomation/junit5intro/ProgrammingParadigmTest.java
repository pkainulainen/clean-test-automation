package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Tests for the ProgrammingParadigm enum")
class ProgrammingParadigmTest {

    @Nested
    @DisplayName("Return the paradigm of the given programming language")
    class FromProgrammingLanguage {

        @ParameterizedTest(name = "If the programming language is: {0}, the paradigm must be: {1}")
        @DisplayName("Should return the correct programming paradigm")
        void shouldReturnCorrectProgrammingParadigm(ProgrammingLanguage language,
                                                    ProgrammingParadigm expectedParadigm) {
            assertThat(ProgrammingParadigm.fromProgrammingLanguage(language))
                    .isEqualTo(expectedParadigm);
        }
    }
}
