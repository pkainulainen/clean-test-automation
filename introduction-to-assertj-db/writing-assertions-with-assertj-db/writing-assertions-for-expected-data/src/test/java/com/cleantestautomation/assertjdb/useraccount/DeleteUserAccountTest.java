package com.cleantestautomation.assertjdb.useraccount;

import org.assertj.core.api.Assertions;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.assertj.db.api.Assertions.assertThat;

/**
 * This test demonstrates how you can write assertions which ensure that
 * the correct user account was deleted from the database.
 */
@SpringBootTest
@ActiveProfiles("integrationTest")
@DisplayName("Delete an existing user account from the database")
@Sql({
        "/db/clear-database.sql",
        "/db/init-user-accounts.sql"
})
class DeleteUserAccountTest {

    private final UserAccountRepository repository;
    private final Table userAccountTable;

    @Autowired
    DeleteUserAccountTest(DataSource dataSource, UserAccountRepository repository) {
        this.repository = repository;
        this.userAccountTable = new Table(dataSource, UserAccountTable.NAME);
    }

    @Nested
    @DisplayName("When the deleted user account isn't found")
    class WhenDeletedUserAccountIsNotFound {

        @Test
        @DisplayName("Shouldn't delete user accounts from the database")
        void shouldNotDeleteUserAccountsFromDatabase() {
            repository.delete(UserAccounts.UNKNOWN_ID);
            assertThat(userAccountTable).hasNumberOfRows(UserAccounts.USER_ACCOUNT_ROW_COUNT);
        }

        @Test
        @DisplayName("Shouldn't make any changes to the information of Anne Owens")
        void shouldNotMakeAnyChangesToInformationOfAnneOwens() {
            repository.delete(UserAccounts.UNKNOWN_ID);

            var rowIndex = UserAccountTableRow.ANNE_OWENS.getIndex();
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_ID)
                    .isEqualTo(UserAccounts.AnneOwens.ID);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_CREATION_TIME)
                    .isEqualTo(UserAccounts.AnneOwens.CREATION_TIME_DB);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_DATE_OF_BIRTH)
                    .isEqualTo(UserAccounts.AnneOwens.DATE_OF_BIRTH_DB);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_EMAIL_ADDRESS)
                    .isEqualTo(UserAccounts.AnneOwens.EMAIL_ADDRESS);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_GRANT_MARKETING_PERMISSION)
                    .isEqualTo(UserAccounts.AnneOwens.GRANT_MARKETING_PERMISSION);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_MODIFICATION_TIME)
                    .isEqualTo(UserAccounts.AnneOwens.MODIFICATION_TIME_DB);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_NAME)
                    .isEqualTo(UserAccounts.AnneOwens.NAME);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_PASSWORD)
                    .isEqualTo(UserAccounts.AnneOwens.PASSWORD);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_STATUS)
                    .isEqualTo(UserAccounts.AnneOwens.STATUS_ACTIVE.name());
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_VERSION)
                    .isEqualTo(UserAccounts.AnneOwens.VERSION);
        }

        @Test
        @DisplayName("Shouldn't make any changes to the information of Leo Virtanen")
        void shouldNotMakeAnyChangesToInformationOfLeoVirtanen() {
            repository.delete(UserAccounts.UNKNOWN_ID);

            var rowIndex = UserAccountTableRow.LEO_VIRTANEN.getIndex();
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_ID)
                    .isEqualTo(UserAccounts.LeoVirtanen.ID);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_CREATION_TIME)
                    .isEqualTo(UserAccounts.LeoVirtanen.CREATION_TIME_DB);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_DATE_OF_BIRTH)
                    .isNull();
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_EMAIL_ADDRESS)
                    .isEqualTo(UserAccounts.LeoVirtanen.EMAIL_ADDRESS);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_GRANT_MARKETING_PERMISSION)
                    .isEqualTo(UserAccounts.LeoVirtanen.GRANT_MARKETING_PERMISSION);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_MODIFICATION_TIME)
                    .isEqualTo(UserAccounts.LeoVirtanen.MODIFICATION_TIME_DB);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_NAME)
                    .isEqualTo(UserAccounts.LeoVirtanen.NAME);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_PASSWORD)
                    .isEqualTo(UserAccounts.LeoVirtanen.PASSWORD);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_STATUS)
                    .isEqualTo(UserAccounts.LeoVirtanen.STATUS_ACTIVE.name());
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_VERSION)
                    .isEqualTo(UserAccounts.LeoVirtanen.VERSION);
        }

        @Test
        @DisplayName("Should return null")
        void shouldReturnNull() {
            var returned = repository.delete(UserAccounts.UNKNOWN_ID);
            Assertions.assertThat(returned).isNull();
        }
    }

    @Nested
    @DisplayName("When the deleted user account is found")
    class WhenDeletedUserAccountIsFound {

        @Test
        @DisplayName("Should delete one user account from the database")
        void shouldDeleteOneUserAccountFromDatabase() {
            repository.delete(UserAccounts.LeoVirtanen.ID);
            assertThat(userAccountTable).hasNumberOfRows(UserAccounts.USER_ACCOUNT_ROW_COUNT - 1);
        }

        @Test
        @DisplayName("Shouldn't make any changes to the information of Anne Owens")
        void shouldNotMakeAnyChangesToInformationOfAnneOwens() {
            repository.delete(UserAccounts.LeoVirtanen.ID);

            var rowIndex = UserAccountTableRow.ANNE_OWENS.getIndex();
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_ID)
                    .isEqualTo(UserAccounts.AnneOwens.ID);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_CREATION_TIME)
                    .isEqualTo(UserAccounts.AnneOwens.CREATION_TIME_DB);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_DATE_OF_BIRTH)
                    .isEqualTo(UserAccounts.AnneOwens.DATE_OF_BIRTH_DB);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_EMAIL_ADDRESS)
                    .isEqualTo(UserAccounts.AnneOwens.EMAIL_ADDRESS);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_GRANT_MARKETING_PERMISSION)
                    .isEqualTo(UserAccounts.AnneOwens.GRANT_MARKETING_PERMISSION);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_MODIFICATION_TIME)
                    .isEqualTo(UserAccounts.AnneOwens.MODIFICATION_TIME_DB);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_NAME)
                    .isEqualTo(UserAccounts.AnneOwens.NAME);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_PASSWORD)
                    .isEqualTo(UserAccounts.AnneOwens.PASSWORD);
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_STATUS)
                    .isEqualTo(UserAccounts.AnneOwens.STATUS_ACTIVE.name());
            assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_VERSION)
                    .isEqualTo(UserAccounts.AnneOwens.VERSION);
        }

        @Test
        @DisplayName("Should return the information of the deleted user account")
        void shouldReturnInformationOfDeletedUserAccount() {
            var deleted = repository.delete(UserAccounts.LeoVirtanen.ID);
            assertSoftly(softAssertions -> {
                softAssertions.assertThat(deleted.getId())
                        .as("id")
                        .isEqualByComparingTo(UserAccounts.LeoVirtanen.ID);
                softAssertions.assertThat(deleted.getDateOfBirth())
                        .as("dateOfBirth")
                        .isNull();
                softAssertions.assertThat(deleted.getEmailAddress())
                        .as("emailAddress")
                        .isEqualTo(UserAccounts.LeoVirtanen.EMAIL_ADDRESS);
                softAssertions.assertThat(deleted.isGrantMarketingPermission())
                        .as("grantMarketingPermission")
                        .isEqualTo(UserAccounts.LeoVirtanen.GRANT_MARKETING_PERMISSION);
                softAssertions.assertThat(deleted.getName())
                        .as("name")
                        .isEqualTo(UserAccounts.LeoVirtanen.NAME);
                softAssertions.assertThat(deleted.getStatus())
                        .as("status")
                        .isEqualTo(UserAccounts.LeoVirtanen.STATUS_ACTIVE);
            });
        }
    }
}
