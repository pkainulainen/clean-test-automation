package com.cleantestautomation.junit5intro.person;

import java.util.Optional;

/**
 *  Provides finder methods for persons.
 */
public class PersonFinder {

    private final PersonRepository repository;

    public PersonFinder(PersonRepository repository) {
        this.repository = repository;
    }

    /**
     * Finds the information of a person by using its id as search
     * criteria.
     *
     * @param id    The id of the requested person.
     * @return      An {@link Optional} object that contains the found
     *              {@link Person} object. If no person is found from the
     *              database, this method returns an empty {@link Optional}.
     */
    public Optional<Person> findById(Long id) {
        var person = repository.findById(id);

        if (person == null) {
            return Optional.empty();
        }

        return Optional.of(person);
    }
}
