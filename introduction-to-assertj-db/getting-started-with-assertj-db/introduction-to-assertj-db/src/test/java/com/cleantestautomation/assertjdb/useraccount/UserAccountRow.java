package com.cleantestautomation.assertjdb.useraccount;

import java.time.LocalDate;

/**
 * Contains the information of a database row that's found from
 * the <code>user_accounts</code> database table.
 */
public class UserAccountRow {

    private final Long id;
    private final String creationTimeDb;
    private final LocalDate dateOfBirth;
    private final String dateOfBirthDb;
    private final String emailAddress;
    private final boolean grantMarketingPermission;
    private final String modificationTimeDb;
    private final String name;
    private final String password;
    private final UserAccountStatus status;
    private final String statusDb;
    private final Long version;

    private UserAccountRow(Builder builder) {
        this.id = builder.id;
        this.creationTimeDb = builder.creationTimeDb;
        this.dateOfBirth = builder.dateOfBirth;
        this.dateOfBirthDb = builder.dateOfBirthDb;
        this.emailAddress = builder.emailAddress;
        this.grantMarketingPermission = builder.grantMarketingPermission;
        this.modificationTimeDb = builder.modificationTimeDb;
        this.name = builder.name;
        this.password = builder.password;
        this.status = builder.status;
        this.statusDb = builder.statusDb;
        this.version = builder.version;
    }

    static Builder getBuilder() {
        return new Builder();
    }

    /**
     * Returns the expected value of the <code>id</code> column.
     */
    public Long getId() {
        return id;
    }

    /**
     * Returns the expected value of the <code>creation_time</code> column.
     */
    public String getCreationTimeDb() {
        return creationTimeDb;
    }

    /**
     * Returns date of birth that's used to create test data that's passed
     * to the system under test.
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Returns the expected value of the <code>date_of_birth</code> column.
     */
    public String getDateOfBirthDb() {
        return dateOfBirthDb;
    }

    /**
     * Returns the expected value of the <code>email_address</code> column.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Returns the expected value of the <code>grant_marketing_permission</code> column.
     */
    public boolean isGrantMarketingPermission() {
        return grantMarketingPermission;
    }

    /**
     * Returns the expected value of the <code>modification_time</code> column.
     */
    public String getModificationTimeDb() {
        return modificationTimeDb;
    }

    /**
     * Returns the expected value of the <code>name</code> column.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the expected value of the <code>password</code> column.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the status of the user account. The returned enum value is
     * used to create the test data that's passed to the system under test.
     */
    public UserAccountStatus getStatus() {
        return status;
    }

    /**
     * Returns the expected value of the <code>status</code> column.
     */
    public String getStatusDb() {
        return statusDb;
    }

    /**
     * Returns the expected value of the <code>version</code> column.
     */
    public Long getVersion() {
        return version;
    }

    static class Builder {
        private Long id;
        private String creationTimeDb;
        private String dateOfBirthDb;
        private LocalDate dateOfBirth;
        private String emailAddress;
        private boolean grantMarketingPermission;
        private String modificationTimeDb;
        private String name;
        private String password;
        private UserAccountStatus status;
        private String statusDb;
        private Long version;

        Builder withId(Long id) {
            this.id = id;
            return this;
        }

        Builder withCreationTimeDb(String creationTimeDb) {
            this.creationTimeDb = creationTimeDb;
            return this;
        }

        Builder withDateOfBirth(String dateOfBirth) {
            this.dateOfBirthDb = dateOfBirth;
            this.dateOfBirth = dateOfBirth != null ? LocalDate.parse(dateOfBirth) : null;
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

        Builder withModificationTimeDb(String modificationTimeDb) {
            this.modificationTimeDb = modificationTimeDb;
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
            this.statusDb = status.name();
            return this;
        }

        Builder withVersion(Long version) {
            this.version = version;
            return this;
        }

        UserAccountRow build() {
            return new UserAccountRow(this);
        }
    }
}