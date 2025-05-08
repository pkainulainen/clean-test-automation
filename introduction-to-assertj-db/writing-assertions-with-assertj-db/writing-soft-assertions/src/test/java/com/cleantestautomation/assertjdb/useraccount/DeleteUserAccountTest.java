package com.cleantestautomation.assertjdb.useraccount;

import com.cleantestautomation.assertjdb.IdColumnReset;
import org.assertj.core.api.Assertions;
import org.assertj.db.api.SoftAssertions;
import org.assertj.db.type.AssertDbConnectionFactory;
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
 * This test class demonstrates how you can write assertions which ensure that
 * the correct user account was deleted from the specified database table.
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
        this.userAccountTable = AssertDbConnectionFactory.of(dataSource)
                .create()
                .table(UserAccountTable.NAME)
                .build();
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
                    .as(UserAccountTable.COLUMN_NAME_ID)
                    .isEqualTo(UserAccounts.AnneOwens.getId());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_CREATION_TIME)
                    .as(UserAccountTable.COLUMN_NAME_CREATION_TIME)
                    .isEqualTo(UserAccounts.AnneOwens.getCreationTimeDb());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_DATE_OF_BIRTH)
                    .as(UserAccountTable.COLUMN_NAME_DATE_OF_BIRTH)
                    .isEqualTo(UserAccounts.AnneOwens.getDateOfBirthDb());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_EMAIL_ADDRESS)
                    .as(UserAccountTable.COLUMN_NAME_EMAIL_ADDRESS)
                    .isEqualTo(UserAccounts.AnneOwens.getEmailAddress());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_GRANT_MARKETING_PERMISSION)
                    .as(UserAccountTable.COLUMN_NAME_GRANT_MARKETING_PERMISSION)
                    .isEqualTo(UserAccounts.AnneOwens.isGrantMarketingPermission());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_MODIFICATION_TIME)
                    .as(UserAccountTable.COLUMN_NAME_MODIFICATION_TIME)
                    .isEqualTo(UserAccounts.AnneOwens.getModificationTimeDb());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_NAME)
                    .as(UserAccountTable.COLUMN_NAME_NAME)
                    .isEqualTo(UserAccounts.AnneOwens.getName());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_PASSWORD)
                    .as(UserAccountTable.COLUMN_NAME_PASSWORD)
                    .isEqualTo(UserAccounts.AnneOwens.getPassword());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_STATUS)
                    .as(UserAccountTable.COLUMN_NAME_STATUS)
                    .isEqualTo(UserAccounts.AnneOwens.getStatusDb());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_VERSION)
                    .as(UserAccountTable.COLUMN_NAME_VERSION)
                    .isEqualTo(UserAccounts.AnneOwens.getVersion());
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
                    .as(UserAccountTable.COLUMN_NAME_ID)
                    .isEqualTo(UserAccounts.LeoVirtanen.getId());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_CREATION_TIME)
                    .as(UserAccountTable.COLUMN_NAME_CREATION_TIME)
                    .isEqualTo(UserAccounts.LeoVirtanen.getCreationTimeDb());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_DATE_OF_BIRTH)
                    .as(UserAccountTable.COLUMN_NAME_DATE_OF_BIRTH)
                    .isEqualTo(UserAccounts.LeoVirtanen.getDateOfBirthDb());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_EMAIL_ADDRESS)
                    .as(UserAccountTable.COLUMN_NAME_EMAIL_ADDRESS)
                    .isEqualTo(UserAccounts.LeoVirtanen.getEmailAddress());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_GRANT_MARKETING_PERMISSION)
                    .as(UserAccountTable.COLUMN_NAME_GRANT_MARKETING_PERMISSION)
                    .isEqualTo(UserAccounts.LeoVirtanen.isGrantMarketingPermission());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_MODIFICATION_TIME)
                    .as(UserAccountTable.COLUMN_NAME_MODIFICATION_TIME)
                    .isEqualTo(UserAccounts.LeoVirtanen.getModificationTimeDb());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_NAME)
                    .as(UserAccountTable.COLUMN_NAME_NAME)
                    .isEqualTo(UserAccounts.LeoVirtanen.getName());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_PASSWORD)
                    .as(UserAccountTable.COLUMN_NAME_PASSWORD)
                    .isEqualTo(UserAccounts.LeoVirtanen.getPassword());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_STATUS)
                    .as(UserAccountTable.COLUMN_NAME_STATUS)
                    .isEqualTo(UserAccounts.LeoVirtanen.getStatusDb());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_VERSION)
                    .as(UserAccountTable.COLUMN_NAME_VERSION)
                    .isEqualTo(UserAccounts.LeoVirtanen.getVersion());
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

        @Test
        @DisplayName("Should delete one user account from the database")
        void shouldDeleteOneUserAccountFromDatabase() {
            repository.delete(UserAccounts.LeoVirtanen.getId());
            assertThat(userAccountTable).hasNumberOfRows(UserAccounts.USER_ACCOUNT_ROW_COUNT - 1);
        }

        @Test
        @DisplayName("Shouldn't make any changes to the information of Anne Owens")
        void shouldNotMakeAnyChangesToInformationOfAnneOwens() {
            repository.delete(UserAccounts.LeoVirtanen.getId());

            var rowIndex = UserAccountTableRow.ANNE_OWENS.getIndex();
            var softAssertions = new SoftAssertions();
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_ID)
                    .as("id")
                    .isEqualTo(UserAccounts.AnneOwens.getId());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_CREATION_TIME)
                    .as("creation_time")
                    .isEqualTo(UserAccounts.AnneOwens.getCreationTimeDb());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_DATE_OF_BIRTH)
                    .as("date_of_birth")
                    .isEqualTo(UserAccounts.AnneOwens.getDateOfBirthDb());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_EMAIL_ADDRESS)
                    .as("email_address")
                    .isEqualTo(UserAccounts.AnneOwens.getEmailAddress());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_GRANT_MARKETING_PERMISSION)
                    .as("grant_marketing_permission")
                    .isEqualTo(UserAccounts.AnneOwens.isGrantMarketingPermission());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_MODIFICATION_TIME)
                    .as("modification_time")
                    .isEqualTo(UserAccounts.AnneOwens.getModificationTimeDb());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_NAME)
                    .as("name")
                    .isEqualTo(UserAccounts.AnneOwens.getName());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_PASSWORD)
                    .as("password")
                    .isEqualTo(UserAccounts.AnneOwens.getPassword());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_STATUS)
                    .as("status")
                    .isEqualTo(UserAccounts.AnneOwens.getStatusDb());
            softAssertions.assertThat(userAccountTable)
                    .row(rowIndex)
                    .value(UserAccountTable.COLUMN_NAME_VERSION)
                    .as("version")
                    .isEqualTo(UserAccounts.AnneOwens.getVersion());
            softAssertions.assertAll();
        }

        @Test
        @DisplayName("Should return the information of the deleted user account")
        void shouldReturnInformationOfDeletedUserAccount() {
            var deleted = repository.delete(UserAccounts.LeoVirtanen.getId());
            assertSoftly(softAssertions -> {
                softAssertions.assertThat(deleted.getId())
                        .as("id")
                        .isEqualByComparingTo(UserAccounts.LeoVirtanen.getId());
                softAssertions.assertThat(deleted.getDateOfBirth())
                        .as("dateOfBirth")
                        .isEqualTo(UserAccounts.LeoVirtanen.getDateOfBirth());
                softAssertions.assertThat(deleted.getEmailAddress())
                        .as("emailAddress")
                        .isEqualTo(UserAccounts.LeoVirtanen.getEmailAddress());
                softAssertions.assertThat(deleted.isGrantMarketingPermission())
                        .as("grantMarketingPermission")
                        .isEqualTo(UserAccounts.LeoVirtanen.isGrantMarketingPermission());
                softAssertions.assertThat(deleted.getName())
                        .as("name")
                        .isEqualTo(UserAccounts.LeoVirtanen.getName());
                softAssertions.assertThat(deleted.getStatus())
                        .as("status")
                        .isEqualTo(UserAccounts.LeoVirtanen.getStatus());
            });
        }
    }
}
