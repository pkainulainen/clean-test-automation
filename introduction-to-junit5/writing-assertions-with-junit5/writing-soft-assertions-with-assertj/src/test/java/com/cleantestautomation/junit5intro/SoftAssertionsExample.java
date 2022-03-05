package com.cleantestautomation.junit5intro;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This example demonstrates how you can write soft assertions with
 * AssertJ if you want to use the manual approach.
 */
@DisplayName("Collect all assertion errors before displaying them")
class SoftAssertionsExample {

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
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(person.getFirstName())
                .as("firstName")
                .isEqualTo(FIRST_NAME);
        softAssertions.assertThat(person.getLastName())
                .as("lastName")
                .isEqualTo(LAST_NAME);

        softAssertions.assertAll();
    }
}
