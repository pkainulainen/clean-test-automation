package com.cleantestautomation.junit5intro.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("Tests for person finder operations")
class PersonFinderTest {

    private PersonRepository repository;
    private PersonFinder finder;

    @BeforeEach
    void configureSystemUnderTest() {
        repository = mock(PersonRepository.class);
        finder = new PersonFinder(repository);
    }

    @Nested
    @DisplayName("Find person by using id as search criteria")
    class FindById {

        private final Long ID = 1L;

        @Nested
        @DisplayName("When the person isn't found")
        class WhenPersonIsNotFound {

            @BeforeEach
            void personQueryReturnsNull() {
                given(repository.findById(ID)).willReturn(null);
            }

            @Test
            @DisplayName("Should return an empty optional")
            void shouldReturnEmptyOptional() {
                var found = finder.findById(ID);
                //TODO: Write the required assertion
            }
        }

        @Nested
        @DisplayName("When the person is found")
        class WhenPersonIsFound {

            private final String NAME = "Sonic the Hedgehog";

            @BeforeEach
            void personQueryReturnsFoundPerson() {
                var found = new Person();
                found.setId(ID);
                found.setName(NAME);

                given(repository.findById(ID)).willReturn(found);
            }

            @Test
            @DisplayName("Should return an optional that contains the found person")
            void shouldReturnOptionalThatContainsFoundPerson() {
                var found = finder.findById(ID);
                //TODO: Write the required assertion. Hint: check that optional isn't empty.
            }

            @Test
            @DisplayName("Should return the correct person")
            void shouldReturnCorrectPerson() {
                var found = finder.findById(ID);
                //TODO: Write the required assertion. Hint: The value of the id property identifies a person.
            }

            @Test
            @DisplayName("Should return a person that has the correct name")
            void shouldReturnPersonThatHasCorrectName() {
                var found = finder.findById(ID);
                //TODO: Write the required assertion.
            }
        }
    }
}
