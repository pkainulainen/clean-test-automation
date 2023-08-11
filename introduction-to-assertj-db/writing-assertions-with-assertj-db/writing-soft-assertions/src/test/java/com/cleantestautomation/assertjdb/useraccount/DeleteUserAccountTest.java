package com.cleantestautomation.assertjdb.useraccount;

import org.assertj.core.api.Assertions;
import org.assertj.db.api.SoftAssertions;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;

import static org.assertj.db.api.Assertions.assertThat;

/**
 * This test class demonstrates how you can write assertions which ensure that
 * the correct user account was deleted from the database.
 */
@SpringBootTest
@ActiveProfiles("integrationTest")
@DisplayName("Delete the information of an existing user account")
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
    @DisplayName("When the deleted user account isn't found from the database")
    class WhenDeletedUserAccountIsNotFoundFromDatabase {

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
                    .as("grant_marketing_permission")
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

        @Test
        @DisplayName("Shouldn't make any changes to the information of Leo Virtanen")
        void shouldNotMakeAnyChangesToInformationOfLeoVirtanen() {
            repository.delete(UserAccounts.UNKNOWN_ID);

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
                    .as("grant_marketing_permission")
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

        @Test
        @DisplayName("Should return null")
        void shouldReturnNull() {
            var deleted = repository.delete(UserAccounts.UNKNOWN_ID);
            Assertions.assertThat(deleted).isNull();
        }
    }

    @Nested
    @DisplayName("When the deleted user account is found from the database")
    class WhenDeletedUserAccountIsFoundFromDatabase {

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
                        .as("grant_marketing_permission")
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
        }
    }
}
