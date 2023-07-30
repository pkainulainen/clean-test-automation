package com.cleantestautomation.assertjdb.useraccount;

import java.time.LocalDate;

/**
 * Contains the new information of the updated user account.
 */
class UpdateUserAccount {

    private final Long id;
    private final LocalDate dateOfBirth;
    private final boolean grantMarketingPermission;
    private final String name;

    private UpdateUserAccount(Builder builder) {
        this.id = builder.id;
        this.dateOfBirth = builder.dateOfBirth;
        this.grantMarketingPermission = builder.grantMarketingPermission;
        this.name = builder.name;
    }

    static Builder getBuilder() {
        return new Builder();
    }

    LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    boolean isGrantMarketingPermission() {
        return grantMarketingPermission;
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
        private LocalDate dateOfBirth;
        private boolean grantMarketingPermission;
        private String name;

        Builder withId(Long id) {
            this.id = id;
            return this;
        }

        Builder withDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        Builder withGrantMarketingPermission(boolean grantMarketingPermission) {
            this.grantMarketingPermission = grantMarketingPermission;
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
