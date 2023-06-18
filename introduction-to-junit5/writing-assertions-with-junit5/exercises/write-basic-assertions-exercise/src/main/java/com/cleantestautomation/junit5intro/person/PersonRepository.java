package com.cleantestautomation.junit5intro.person;

/**
 * Provides finder methods for persons.
 */
interface PersonRepository {

    /**
     * Gets the information of a person from the database by using id as search
     * criteria.
     * @param id    The id of the returned person.
     * @return      The information of the found person. If the person isn't
     *              found from the database, this method returns <code>null</code>.
     */
    Person findById(Long id);
}
