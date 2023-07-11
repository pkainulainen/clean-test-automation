package com.cleantestautomation.assertjdb.useraccount;

import org.assertj.db.type.Table;

import static org.assertj.db.api.Assertions.assertThat;

/**
 * An assertion utility class which allows you to write assertions for the column values
 * of the specified database row which is found from the <code>user_account</code> database
 * table.
 */
public class UserAccountTableRowAssertions {

    private final int tableRowIndex;
    private final Table userAccountTable;

    private UserAccountTableRowAssertions(Table userAccountTable, UserAccountTableRow tableRow) {
        this.tableRowIndex = tableRow.getIndex();
        this.userAccountTable = userAccountTable;
    }

    /**
     * Creates a new assertion object.
     * @param userAccountTable  The {@link Table} object which allows you to write assertions for
     *                          the data that's found from the <code>user_account</code> database
     *                          table.
     * @param tableRow          Identifies the table row which contains the expected data.
     * @return  The created assertion object which allows you to write assertions for the data
     *          that's found from the <code>user_account</code> database table.
     */
    public static UserAccountTableRowAssertions assertThatUserAccount(Table userAccountTable, UserAccountTableRow tableRow) {
        return new UserAccountTableRowAssertions(userAccountTable, tableRow);
    }

    /**
     * Ensures that the email address of the user account (the value of the <code>email_address</code>
     * column) is equal to the expected email address.
     * @param expectedEmailAddress  The expected email address.
     * @return  A reference to the assertion object which allows you to leverage its fluent API when
     *          you have to add multiple assertions to one test method.
     */
    public UserAccountTableRowAssertions hasEmailAddress(String expectedEmailAddress) {
        assertThat(userAccountTable)
                .row(tableRowIndex)
                .value(UserAccountTable.COLUMN_NAME_EMAIL_ADDRESS)
                .isEqualTo(expectedEmailAddress);
        return this;
    }

    /**
     * Ensures that the id of the user account (the value of the <code>id</code> column) is equal to
     * the expected id.
     * @param expectedId    The expected id.
     * @return  A reference to the assertion object which allows you to leverage its fluent API when
     *          you have to add multiple assertions to one test method.
     */
    public UserAccountTableRowAssertions hasId(Long expectedId) {
        assertThat(userAccountTable)
                .row(tableRowIndex)
                .value(UserAccountTable.COLUMN_NAME_ID)
                .isEqualTo(expectedId);
        return this;
    }

    /**
     * Ensures that the name of the user account (the value of the <code>name</code> column) is equal
     * to the expected name.
     * @param expectedName  The expected name.
     * @return  A reference to the assertion object which allows you to leverage its fluent API when
     *          you have to add multiple assertions to one test method.
     */
    public UserAccountTableRowAssertions hasName(String expectedName) {
        assertThat(userAccountTable)
                .row(tableRowIndex)
                .value(UserAccountTable.COLUMN_NAME_NAME)
                .isEqualTo(expectedName);
        return this;
    }

    /**
     * Ensures that the password of the user account (the value of the <code>password</code> column)
     * is equal to the expected password.
     * @param expectedPassword  The expected password.
     * @return  A reference to the assertion object which allows you to leverage its fluent API when
     *          you have to add multiple assertions to one test method.
     */
    public UserAccountTableRowAssertions hasPassword(String expectedPassword) {
        assertThat(userAccountTable)
                .row(tableRowIndex)
                .value(UserAccountTable.COLUMN_NAME_PASSWORD)
                .isEqualTo(expectedPassword);
        return this;
    }

    /**
     * Ensures that the status of the user account (the value of the <code>status</code> column)
     * is equal to the expected status.
     * @param expectedStatus    The expected status.
     * @return  A reference to the assertion object which allows you to leverage its fluent API when
     *          you have to add multiple assertions to one test method.
     */
    public UserAccountTableRowAssertions hasStatus(UserAccountStatus expectedStatus) {
        assertThat(userAccountTable)
                .row(tableRowIndex)
                .value(UserAccountTable.COLUMN_NAME_STATUS)
                .isEqualTo(expectedStatus.name());
        return this;
    }

    /**
     * Ensures that the version of the user account (the value of the <code>version</code> column)
     * is equal to the expected version.
     * @param expectedVersion   The expected version.
     * @return  A reference to the assertion object which allows you to leverage its fluent API when
     *          you have to add multiple assertions to one test method.
     */
    public UserAccountTableRowAssertions hasVersion(Long expectedVersion) {
        assertThat(userAccountTable)
                .row(tableRowIndex)
                .value(UserAccountTable.COLUMN_NAME_VERSION)
                .isEqualTo(expectedVersion);
        return this;
    }

    /**
     * Ensures that the creation time of the user account (the value of the <code>creation_time</code>
     * column) is equal to the expected creation time.
     * @param expectedCreationTime  The expected creation time. This timestamp must use the same format
     *                              as {@link java.time.format.DateTimeFormatter#ISO_LOCAL_DATE_TIME}.
     * @return  A reference to the assertion object which allows you to leverage its fluent API when
     *          you have to add multiple assertions to one test method.
     */
    public UserAccountTableRowAssertions wasCreatedAt(String expectedCreationTime) {
        assertThat(userAccountTable)
                .row(tableRowIndex)
                .value(UserAccountTable.COLUMN_NAME_CREATION_TIME)
                .isEqualTo(expectedCreationTime);
        return this;
    }

    /**
     * Ensures that the modification time of the user account (the value of the <code>modification_time</code>
     * column) is equal to the expected creation time.
     * @param expectedModificationTime  The expected modification time. This timestamp must use the same format
     *      *                           as {@link java.time.format.DateTimeFormatter#ISO_LOCAL_DATE_TIME}.
     * @return  A reference to the assertion object which allows you to leverage its fluent API when
     *          you have to add multiple assertions to one test method.
     */
    public UserAccountTableRowAssertions wasModifiedAt(String expectedModificationTime) {
        assertThat(userAccountTable)
                .row(tableRowIndex)
                .value(UserAccountTable.COLUMN_NAME_MODIFICATION_TIME)
                .isEqualTo(expectedModificationTime);
        return this;
    }
}
