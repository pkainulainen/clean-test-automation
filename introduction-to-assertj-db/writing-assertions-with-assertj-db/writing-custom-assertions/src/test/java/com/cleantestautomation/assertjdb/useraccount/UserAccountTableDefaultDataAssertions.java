package com.cleantestautomation.assertjdb.useraccount;

import org.assertj.db.api.SoftAssertions;
import org.assertj.db.type.Table;

/**
 * An assertion utility class which allows you to ensure that no changes were made to
 * the test data that was inserted into the <code>user_account</code> database table.
 */
public final class UserAccountTableDefaultDataAssertions {

    private final Table userAccountTable;

    private UserAccountTableDefaultDataAssertions(Table userAccountTable) {
        this.userAccountTable = userAccountTable;
    }


    /**
     * Creates a new assertion object.
     * @param userAccountTable  The {@link Table} object which allows you to write assertions for
     *                          the data that's found from the <code>user_account</code> database
     *                          table.
     * @return  The created assertion object which allows you to write assertions for the data
     *          that's found from the <code>user_account</code> database table.
     */
    public static UserAccountTableDefaultDataAssertions assertThatUserAccountTable(Table userAccountTable) {
        return new UserAccountTableDefaultDataAssertions(userAccountTable);
    }

    /**
     * Ensures that information of Anne Owens that's found from the <code>user_account</code>
     * database table hasn't been changed after it was inserted into the database. This assertion
     * method uses soft assertions.
     */
    public void hasDefaultInformationOfAnneOwens() {
        hasUser(UserAccountTableRow.ANNE_OWENS, UserAccounts.AnneOwens);
    }

    /**
     * Ensures that information of Leo Virtanen that's found from the <code>user_account</code>
     * database table hasn't been changed after it was inserted into the database. This assertion
     * method uses soft assertions.
     */
    public void hasDefaultInformationOfLeoVirtanen() {
       hasUser(UserAccountTableRow.LEO_VIRTANEN, UserAccounts.LeoVirtanen);
    }

    private void hasUser(UserAccountTableRow targetRow, UserAccountRow expectedUser) {
        var rowIndex = targetRow.getIndex();
        var softAssertions = new SoftAssertions();

        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_ID)
                .as(UserAccountTable.COLUMN_NAME_ID)
                .isEqualTo(expectedUser.getId());
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_CREATION_TIME)
                .as(UserAccountTable.COLUMN_NAME_CREATION_TIME)
                .isEqualTo(expectedUser.getCreationTimeDb());
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_DATE_OF_BIRTH)
                .as(UserAccountTable.COLUMN_NAME_DATE_OF_BIRTH)
                .isEqualTo(expectedUser.getDateOfBirthDb());
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_EMAIL_ADDRESS)
                .as(UserAccountTable.COLUMN_NAME_EMAIL_ADDRESS)
                .isEqualTo(expectedUser.getEmailAddress());
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_GRANT_MARKETING_PERMISSION)
                .as(UserAccountTable.COLUMN_NAME_GRANT_MARKETING_PERMISSION)
                .isEqualTo(expectedUser.isGrantMarketingPermission());
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_MODIFICATION_TIME)
                .as(UserAccountTable.COLUMN_NAME_MODIFICATION_TIME)
                .isEqualTo(expectedUser.getModificationTimeDb());
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_NAME)
                .as(UserAccountTable.COLUMN_NAME_NAME)
                .isEqualTo(expectedUser.getName());
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_PASSWORD)
                .as(UserAccountTable.COLUMN_NAME_PASSWORD)
                .isEqualTo(expectedUser.getPassword());
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_STATUS)
                .as(UserAccountTable.COLUMN_NAME_STATUS)
                .isEqualTo(expectedUser.getStatusDb());
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_VERSION)
                .as(UserAccountTable.COLUMN_NAME_VERSION)
                .isEqualTo(expectedUser.getVersion());

        softAssertions.assertAll();
    }
}
