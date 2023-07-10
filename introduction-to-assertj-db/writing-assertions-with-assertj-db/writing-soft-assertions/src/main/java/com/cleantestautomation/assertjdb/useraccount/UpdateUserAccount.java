package com.cleantestautomation.assertjdb.useraccount;

/**
 * Contains the new information of the updated user account.
 */
class UpdateUserAccount {

    private final Long id;
    private final String name;

    private UpdateUserAccount(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    static Builder getBuilder() {
        return new Builder();
    }

    Long getId() {
        return id;
    }

    String getName() {
        return name;
    }

    /**
     * Allows you to build new {@link UpdateUserAccount} objects.
     */
    static class Builder {

        private Long id;
        private String name;

        Builder withId(Long id) {
            this.id = id;
            return this;
        }

        Builder withName(String name) {
            this.name = name;
            return this;
        }

        UpdateUserAccount build() {
            //Typically this method would check that the state of the created object
            //is correct. I omitted these checks because I wanted to keep this class
            //as simple as possible.
            return new UpdateUserAccount(this);
        }
    }
}
