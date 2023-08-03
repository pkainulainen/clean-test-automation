package com.cleantestautomation.assertjdb.useraccount;

import com.cleantestautomation.assertjdb.TestDateTimeBuilder;

import java.time.LocalDate;

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
    public static class AnneOwens {

        public static final Long ID = 1L;
        public static final String CREATION_TIME_DB = TestDateTimeBuilder.transformUTCDateTimeToLocalDateTime("2023-05-09T10:46:00");
        public static final String DATE_OF_BIRTH_DB = "2000-01-05";
        public static final LocalDate DATE_OF_BIRTH = LocalDate.parse(DATE_OF_BIRTH_DB);
        public static final String UPDATED_DATE_OF_BIRTH_DB = "2000-02-02";
        public static final LocalDate UPDATED_DATE_OF_BIRTH = LocalDate.parse(UPDATED_DATE_OF_BIRTH_DB);
        public static final String EMAIL_ADDRESS = "anne.owens@example.com";
        public static final boolean GRANT_MARKETING_PERMISSION = true;
        public static final String MODIFICATION_TIME_DB = CREATION_TIME_DB;
        public static final boolean UPDATED_GRANT_MARKETING_PERMISSION = false;
        public static final String NAME = "Anne Owens";
        public static final String UPDATED_NAME = "Owens Anne";
        public static final String PASSWORD = "$2a$12$7lPnFLWzaITkzOXHL62AI.NHkkdP52Nbea3HwJMYy2.NUGQAcu9T.";
        public static final UserAccountStatus STATUS_ACTIVE = UserAccountStatus.ACTIVE;
        public static final Long VERSION = 0L;
    }

    /**
     * Contains the information that should be found from the second row of the <code>user_account</code>
     * database table.
     */
    public static class LeoVirtanen {

        public static final Long ID = 2L;
        public static final String CREATION_TIME_DB = TestDateTimeBuilder.transformUTCDateTimeToLocalDateTime("2023-05-10T12:46:00");
        public static final String EMAIL_ADDRESS = "leo.virtanen@example.com";
        public static final boolean GRANT_MARKETING_PERMISSION = false;
        public static final String MODIFICATION_TIME_DB = CREATION_TIME_DB;
        public static final String NAME = "Leo Virtanen";
        public static final String PASSWORD = "$2a$12$bH/96o9j919FaFCe9iN0h.91MyFF5CWlHrhp5YyRepwrRsVeK9uKO";
        public static final UserAccountStatus STATUS_ACTIVE = UserAccountStatus.ACTIVE;
        public static final Long VERSION = 0L;
    }

    /**
     * Prevents instantiation.
     */
    private UserAccounts() {}
}
