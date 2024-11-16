package com.cleantestautomation.assertjdb.useraccount;

import com.cleantestautomation.assertjdb.TestDateTimeBuilder;

/**
 * Contains the test data that's found from the <code>user_account</code> database table.
 */
public class UserAccounts {

    public static final Long DEFAULT_VERSION = 0L;
    public static final int USER_ACCOUNT_ROW_COUNT = 2;
    public static final Long UNKNOWN_ID = 99L;

    /**
     * Contains the information that should be found from the first row of the <code>user_account</code>
     * database table.
     */
    public static UserAccountRow AnneOwens = UserAccountRow.getBuilder()
            .withId(1L)
            .withCreationTimeDb(TestDateTimeBuilder.transformUTCDateTimeToLocalDateTime("2023-05-09T10:46:00"))
            .withDateOfBirth("2000-01-05")
            .withEmailAddress("anne.owens@example.com")
            .withGrantMarketingPermission(true)
            .withModificationTimeDb(TestDateTimeBuilder.transformUTCDateTimeToLocalDateTime("2023-05-09T10:46:00"))
            .withName("Anne Owens")
            .withPassword("$2a$12$7lPnFLWzaITkzOXHL62AI.NHkkdP52Nbea3HwJMYy2.NUGQAcu9T.")
            .withStatus(UserAccountStatus.ACTIVE)
            .withVersion(0L)
            .build();

    /**
     * Contains the information that should be found from the first row of the <code>user_account</code>
     * database table after the information of the user account has been updated successfully.
     */
    public static UserAccountRow UpdatedAnneOwens = UserAccountRow.getBuilder()
            .withId(1L)
            .withCreationTimeDb(TestDateTimeBuilder.transformUTCDateTimeToLocalDateTime("2023-05-09T10:46:00"))
            .withDateOfBirth("2000-02-02")
            .withEmailAddress("anne.owens@example.com")
            .withGrantMarketingPermission(false)
            //We don't set the modification time here because it depends on the "current time"
            //that's used when the integration tests is run.
            .withName("Owens Anne")
            .withPassword("$2a$12$7lPnFLWzaITkzOXHL62AI.NHkkdP52Nbea3HwJMYy2.NUGQAcu9T.")
            .withStatus(UserAccountStatus.ACTIVE)
            .withVersion(1L)
            .build();

    /**
     * Contains the information that should be found from the second row of the <code>user_account</code>
     * database table.
     */
    public static UserAccountRow LeoVirtanen = UserAccountRow.getBuilder()
            .withId(2L)
            .withCreationTimeDb(TestDateTimeBuilder.transformUTCDateTimeToLocalDateTime("2023-05-10T12:46:00"))
            .withDateOfBirth(null)
            .withEmailAddress("leo.virtanen@example.com")
            .withGrantMarketingPermission(false)
            .withModificationTimeDb(TestDateTimeBuilder.transformUTCDateTimeToLocalDateTime("2023-05-10T12:46:00"))
            .withName("Leo Virtanen")
            .withPassword("$2a$12$bH/96o9j919FaFCe9iN0h.91MyFF5CWlHrhp5YyRepwrRsVeK9uKO")
            .withStatus(UserAccountStatus.ACTIVE)
            .withVersion(0L)
            .build();

    /**
     * Prevents instantiation.
     */
    private UserAccounts() {}
}
