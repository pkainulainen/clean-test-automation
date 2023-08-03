package com.cleantestautomation.assertjdb.useraccount;

import org.assertj.db.api.SoftAssertions;
import org.assertj.db.type.Table;

/**
 * An assertion utility class which allows you to write "table level" assertions for the
 * <code>user_account</code> database table.
 */
public class UserAccountTableAssertions {

    private final Table userAccountTable;

    private UserAccountTableAssertions(Table userAccountTable) {
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
    public static UserAccountTableAssertions assertThatUserAccountTable(Table userAccountTable) {
        return new UserAccountTableAssertions(userAccountTable);
    }

    /**
     * Ensures that information of Anne Owens that's found from the <code>user_account</code>
     * database table hasn't been changed after it was inserted into the database. This assertion
     * method uses soft assertions.
     */
    public void hasDefaultInformationOfAnneOwens() {
        var rowIndex = UserAccountTableRow.ANNE_OWENS.getIndex();
        var softAssertions = new SoftAssertions();

        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_ID)
                .as("id")
                .isEqualTo(UserAccounts.AnneOwens.ID);
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_CREATION_TIME)
                .as("creation_time")
                .isEqualTo(UserAccounts.AnneOwens.CREATION_TIME_DB);
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_DATE_OF_BIRTH)
                .as("date_of_birth")
                .isEqualTo(UserAccounts.AnneOwens.DATE_OF_BIRTH_DB);
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_EMAIL_ADDRESS)
                .as("email_address")
                .isEqualTo(UserAccounts.AnneOwens.EMAIL_ADDRESS);
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_GRANT_MARKETING_PERMISSION)
                .isEqualTo(UserAccounts.AnneOwens.GRANT_MARKETING_PERMISSION);
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_MODIFICATION_TIME)
                .as("modification_time")
                .isEqualTo(UserAccounts.AnneOwens.MODIFICATION_TIME_DB);
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_NAME)
                .as("name")
                .isEqualTo(UserAccounts.AnneOwens.NAME);
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_PASSWORD)
                .as("password")
                .isEqualTo(UserAccounts.AnneOwens.PASSWORD);
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_STATUS)
                .as("status")
                .isEqualTo(UserAccounts.AnneOwens.STATUS_ACTIVE.name());
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_VERSION)
                .as("version")
                .isEqualTo(UserAccounts.AnneOwens.VERSION);

        softAssertions.assertAll();
    }

    /**
     * Ensures that information of Leo Virtanen that's found from the <code>user_account</code>
     * database table hasn't been changed after it was inserted into the database. This assertion
     * method uses soft assertions.
     */
    public void hasDefaultInformationOfLeoVirtanen() {
        var rowIndex = UserAccountTableRow.LEO_VIRTANEN.getIndex();
        var softAssertions = new SoftAssertions();

        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_ID)
                .as("id")
                .isEqualTo(UserAccounts.LeoVirtanen.ID);
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_CREATION_TIME)
                .as("creation_time")
                .isEqualTo(UserAccounts.LeoVirtanen.CREATION_TIME_DB);
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_DATE_OF_BIRTH)
                .as("date_of_birth")
                .isNull();
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_EMAIL_ADDRESS)
                .as("email_address")
                .isEqualTo(UserAccounts.LeoVirtanen.EMAIL_ADDRESS);
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_GRANT_MARKETING_PERMISSION)
                .isEqualTo(UserAccounts.LeoVirtanen.GRANT_MARKETING_PERMISSION);
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_MODIFICATION_TIME)
                .as("modification_time")
                .isEqualTo(UserAccounts.LeoVirtanen.MODIFICATION_TIME_DB);
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_NAME)
                .as("name")
                .isEqualTo(UserAccounts.LeoVirtanen.NAME);
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_PASSWORD)
                .as("password")
                .isEqualTo(UserAccounts.LeoVirtanen.PASSWORD);
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_STATUS)
                .as("status")
                .isEqualTo(UserAccounts.LeoVirtanen.STATUS_ACTIVE.name());
        softAssertions.assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_VERSION)
                .as("version")
                .isEqualTo(UserAccounts.LeoVirtanen.VERSION);

        softAssertions.assertAll();
    }
}
