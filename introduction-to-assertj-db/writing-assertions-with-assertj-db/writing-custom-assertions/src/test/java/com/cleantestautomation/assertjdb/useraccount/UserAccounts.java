package com.cleantestautomation.assertjdb.useraccount;

import com.cleantestautomation.assertjdb.TestDateTimeBuilder;

/**
 * Contains the test data that's found from the <code>user_account</code> database table.
 */
public class UserAccounts {

    public static final Long DEFAULT_VERSION = 0L;
    public static final int USER_ACCOUNT_ROW_COUNT = 2;

    /**
     * Contains the information that should be found from the first row of the <code>user_account</code>
     * database table.
     */
    public static class AnneOwens {

        public static final Long ID = 1L;
        public static final String CREATION_TIME_DB = TestDateTimeBuilder.transformUTCDateToLocalDateTime("2023-05-09T10:46:00");
        public static String EMAIL_ADDRESS = "anne.owens@example.com";
        public static String NAME = "Anne Owens";
        public static String UPDATED_NAME = "Owens Anne";
        public static String PASSWORD = "$2a$12$7lPnFLWzaITkzOXHL62AI.NHkkdP52Nbea3HwJMYy2.NUGQAcu9T.";
        public static UserAccountStatus STATUS_ACTIVE = UserAccountStatus.ACTIVE;
        public static Long VERSION = 0L;
    }

    /**
     * Contains the information that should be found from the second row of the <code>user_account</code>
     * database table.
     */
    public static class LeoVirtanen {

        public static Long ID = 2L;
        public static final String CREATION_TIME_DB = TestDateTimeBuilder.transformUTCDateToLocalDateTime("2023-05-10T12:46:00");
        public static String EMAIL_ADDRESS = "leo.virtanen@example.com";
        public static final String MODIFICATION_TIME_DB = CREATION_TIME_DB;
        public static String NAME = "Leo Virtanen";
        public static String PASSWORD = "$2a$12$bH/96o9j919FaFCe9iN0h.91MyFF5CWlHrhp5YyRepwrRsVeK9uKO";
        public static UserAccountStatus STATUS_ACTIVE = UserAccountStatus.ACTIVE;
        public static Long VERSION = 0L;
    }
}
