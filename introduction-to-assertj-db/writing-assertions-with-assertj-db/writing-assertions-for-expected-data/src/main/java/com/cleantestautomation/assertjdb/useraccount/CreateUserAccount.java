package com.cleantestautomation.assertjdb.useraccount;

import java.time.LocalDate;

/**
 * Contains the information of the created user account.
 */
class CreateUserAccount {

    private final LocalDate dateOfBirth;
    private final String emailAddress;
    private final boolean grantMarketingPermission;
    private final String name;
    private final String password;
    private final UserAccountStatus status;

    private CreateUserAccount(Builder builder) {
        this.dateOfBirth = builder.dateOfBirth;
        this.emailAddress = builder.emailAddress;
        this.grantMarketingPermission = builder.grantMarketingPermission;
        this.name = builder.name;
        this.password = builder.password;
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

    String getName() {
        return name;
    }

    String getPassword() {
        return password;
    }

    UserAccountStatus getStatus() {
        return status;
    }

    /**
     * Allows you to build new {@link CreateUserAccount} objects.
     */
    static class Builder {

        private LocalDate dateOfBirth;
        private String emailAddress;
        private boolean grantMarketingPermission;
        private String name;
        private String password;
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

        Builder withName(String name) {
            this.name = name;
            return this;
        }

        Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        Builder withStatus(UserAccountStatus status) {
            this.status = status;
            return this;
        }

        CreateUserAccount build() {
            //Typically this method would check that the state of the created object
            //is correct. I omitted these checks because I wanted to keep this class
            //as simple as possible.
            return new CreateUserAccount(this);
        }
    }
}
