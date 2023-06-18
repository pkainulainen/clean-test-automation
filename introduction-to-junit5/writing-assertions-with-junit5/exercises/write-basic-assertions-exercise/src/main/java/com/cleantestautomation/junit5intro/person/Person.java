package com.cleantestautomation.junit5intro.person;

/**
 * Contains the information of one person.
 */
public class Person {

    private Long id;
    private String name;

    public Person() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
