package com.cleantestautomation.assertjdb.useraccount;

import java.time.LocalDate;

/**
 * Contains the information of a user account.
 */
class UserAccount {

    private final Long id;
    private final LocalDate dateOfBirth;
    private final String emailAddress;
    private final boolean grantMarketingPermission;
    private final String name;
    private final UserAccountStatus status;

    private UserAccount(Builder builder) {
        this.id = builder.id;
        this.dateOfBirth = builder.dateOfBirth;
        this.emailAddress = builder.emailAddress;
        this.grantMarketingPermission = builder.grantMarketingPermission;
        this.name = builder.name;
        this.status = builder.status;
    }

    static Builder getBuilder() {
        return new Builder();
    }

    LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    String getEmailAddress() {
        return emailAddress;
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

    UserAccountStatus getStatus() {
        return status;
    }

    /**
     * Allows you to build new {@link UserAccount} objects.
     */
    static class Builder {

        private LocalDate dateOfBirth;
        private String emailAddress;
        private boolean grantMarketingPermission;
        private Long id;
        private String name;
        private UserAccountStatus status;

        Builder withDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        Builder withEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        Builder withGrantMarketingPermission(boolean grantMarketingPermission) {
            this.grantMarketingPermission = grantMarketingPermission;
            return this;
        }

        Builder withId(Long id) {
            this.id = id;
            return this;
        }

        Builder withName(String name) {
            this.name = name;
            return this;
        }

        Builder withStatus(UserAccountStatus status) {
            this.status = status;
            return this;
        }

        UserAccount build() {
            //Typically this method would check that the state of the created object
            //is correct. I omitted these checks because I wanted to keep this class
            //as simple as possible.
            return new UserAccount(this);
        }
    }
}
