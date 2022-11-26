package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This example demonstrates how you can group assertions
 * with JUnit 5 assertion API.
 */
@DisplayName("Group assertions with JUnit 5 assertion API")
class GroupAssertionsExampleTest {

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
    @DisplayName("Person should have the correct name")
    void personShouldHaveCorrectName() {
        assertAll(
                "Name",
                () -> assertEquals(FIRST_NAME, person.getFirstName()),
                () -> assertEquals(LAST_NAME, person.getLastName())
        );
    }
}
