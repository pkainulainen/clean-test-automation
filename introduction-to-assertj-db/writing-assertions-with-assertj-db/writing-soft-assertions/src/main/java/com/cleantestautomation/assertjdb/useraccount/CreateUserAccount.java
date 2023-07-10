package com.cleantestautomation.assertjdb.useraccount;

/**
 * Contains the information of the created user account.
 */
class CreateUserAccount {

    private final String emailAddress;
    private final String name;
    private final String password;
    private final UserAccountStatus status;

    private CreateUserAccount(Builder builder) {
        this.emailAddress = builder.emailAddress;
        this.name = builder.name;
        this.password = builder.password;
        this.status = builder.status;
    }

    static Builder getBuilder() {
        return new Builder();
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UserAccountStatus getStatus() {
        return status;
    }

    /**
     * Allows you to build new {@link CreateUserAccount} objects.
     */
    static class Builder {

        private String emailAddress;
        private String name;
        private String password;
        private UserAccountStatus status;

        Builder withEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
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
