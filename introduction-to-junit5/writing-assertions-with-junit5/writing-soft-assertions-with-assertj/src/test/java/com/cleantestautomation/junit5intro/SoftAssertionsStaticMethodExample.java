package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

/**
 * This example demonstrates how you can write soft assertions
 * by using the the {@link org.assertj.core.api.SoftAssertions#assertSoftly(Consumer)}
 * method.
 */
@DisplayName("Collect all assertion errors before displaying them")
class SoftAssertionsStaticMethodExample {

    private static final String FIRST_NAME = "Jane";
    private static final String LAST_NAME = "Doe";

    private Person person;

    @BeforeEach
    void createPerson() {
        person = new Person();
        person.setFirstName(FIRST_NAME);
        person.setLastName(LAST_NAME);
    }

    @Test
    @DisplayName("Should have the correct name")
    void shouldHaveCorrectName() {
        assertSoftly((softAssertions) -> {
            softAssertions.assertThat(person.getFirstName())
                    .as("firstName")
                    .isEqualTo(FIRST_NAME);
            softAssertions.assertThat(person.getLastName())
                    .as("lastName")
                    .isEqualTo(LAST_NAME);
        });
    }
}
