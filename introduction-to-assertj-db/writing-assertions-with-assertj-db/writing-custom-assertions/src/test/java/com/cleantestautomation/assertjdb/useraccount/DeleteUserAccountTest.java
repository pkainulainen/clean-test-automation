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

import static com.cleantestautomation.assertjdb.useraccount.UserAccountTableDefaultDataAssertions.assertThatUserAccountTable;
import static com.cleantestautomation.assertjdb.useraccount.UserAccountTableRowAssertions.assertThatUserAccount;
import static org.assertj.db.api.Assertions.assertThat;

/**
 * This test class demonstrates how you can use a custom assertion class when you want
 * to verify that the correct row was deleted from the database.
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
    @DisplayName("When the deleted user account isn't found")
    class WhenDeletedUserAccountIsNotFound {

        @Test
        @DisplayName("Shouldn't delete user accounts from the database")
        void shouldNotDeleteUserAccountsFromDatabase() {
            repository.delete(UserAccounts.UNKNOWN_ID);
            assertThat(userAccountTable).hasNumberOfRows(UserAccounts.USER_ACCOUNT_ROW_COUNT);
        }

        /**
         * I want to point out a few things:
         * <ul>
         *     <li>
         *         This test method doesn't use soft assertions. Thus, if it fails, you might have to run it
         *         multiple times before you have fixed all problems. That being said, it's not likely that
         *         this test method will fail. That's why this might be an acceptable compromise.
         *     </li>
         *     <li>
         *         If you have to write multiple tests which ensure that the data found from a specific table
         *         row hasn't changed, you should consider writing a custom assertion method because writing
         *         the same assertions multiple times makes your tests hard to write and maintain.
         *     </li>
         * </ul>
         */
        @Test
        @DisplayName("Shouldn't make any changes to the information of Anne Owens (without soft assertions)")
        void shouldNotMakeAnyChangesToInformationOfAnneOwensWithoutSoftAssertions() {
            repository.delete(UserAccounts.UNKNOWN_ID);

            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasId(UserAccounts.AnneOwens.ID)
                    .wasCreatedAt(UserAccounts.AnneOwens.CREATION_TIME_DB)
                    .hasDateOfBirth(UserAccounts.AnneOwens.DATE_OF_BIRTH_DB)
                    .hasEmailAddress(UserAccounts.AnneOwens.EMAIL_ADDRESS)
                    .hasGrantMarketingPermission(UserAccounts.AnneOwens.GRANT_MARKETING_PERMISSION)
                    .wasModifiedAt(UserAccounts.AnneOwens.MODIFICATION_TIME_DB)
                    .hasName(UserAccounts.AnneOwens.NAME)
                    .hasPassword(UserAccounts.AnneOwens.PASSWORD)
                    .hasStatus(UserAccounts.AnneOwens.STATUS_ACTIVE)
                    .hasVersion(UserAccounts.AnneOwens.VERSION);
        }

        @Test
        @DisplayName("Shouldn't make any changes to the information of Leo Virtanen (without soft assertions)")
        void shouldNotMakeAnyChangesToInformationOfLeoVirtanenWithoutSoftAssertions() {
            repository.delete(UserAccounts.UNKNOWN_ID);

            assertThatUserAccount(userAccountTable, UserAccountTableRow.LEO_VIRTANEN)
                    .hasId(UserAccounts.LeoVirtanen.ID)
                    .wasCreatedAt(UserAccounts.LeoVirtanen.CREATION_TIME_DB)
                    .doesNotHaveDateOfBirth()
                    .hasEmailAddress(UserAccounts.LeoVirtanen.EMAIL_ADDRESS)
                    .hasGrantMarketingPermission(UserAccounts.LeoVirtanen.GRANT_MARKETING_PERMISSION)
                    .wasModifiedAt(UserAccounts.LeoVirtanen.MODIFICATION_TIME_DB)
                    .hasName(UserAccounts.LeoVirtanen.NAME)
                    .hasPassword(UserAccounts.LeoVirtanen.PASSWORD)
                    .hasStatus(UserAccounts.LeoVirtanen.STATUS_ACTIVE)
                    .hasVersion(UserAccounts.LeoVirtanen.VERSION);
        }

        /**
         * A separate assertion method has these benefits:
         * <ul>
         *     <li>It can use soft assertions. THis means that you have to run it only once.</li>
         *     <li>
         *         The assertion logic is found from one place. If you have to make changes to that logic,
         *         you don't have to make the same change to multiple places. Instead, you can make the
         *         required changes to your custom assertion class.
         *     </li>
         * </ul>
         *
         * However, because writing custom code has always a cost, you should always make a conscious
         * decision to use this approach.
         */
        @Test
        @DisplayName("Shouldn't make any changes to the information of Anne Owens (with soft assertions)")
        void shouldNotMakeAnyChangesToInformationOfAnneOwensWithSoftAssertions() {
            repository.delete(UserAccounts.UNKNOWN_ID);
            assertThatUserAccountTable(userAccountTable).hasDefaultInformationOfAnneOwens();
        }

        @Test
        @DisplayName("Shouldn't make any changes to the information of Leo Virtanen (with soft assertions)")
        void shouldNotMakeAnyChangesToInformationOfLeoVirtanenWithSoftAssertions() {
            repository.delete(UserAccounts.UNKNOWN_ID);
            assertThatUserAccountTable(userAccountTable).hasDefaultInformationOfLeoVirtanen();
        }

        @Test
        @DisplayName("Should return null")
        void shouldReturnNull() {
            var deleted = repository.delete(UserAccounts.UNKNOWN_ID);
            Assertions.assertThat(deleted).isNull();
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

        /**
         * I want to point out a few things:
         * <ul>
         *     <li>
         *         This test method doesn't use soft assertions. Thus, if it fails, you might have to run it
         *         multiple times before you have fixed all problems. That being said, it's not likely that
         *         this test method will fail. That's why this might be an acceptable compromise.
         *     </li>
         *     <li>
         *         If you have to write multiple tests which ensure that the data found from a specific table
         *         row hasn't changed, you should consider writing a custom assertion method because writing
         *         the same assertions multiple times makes your tests hard to write and maintain.
         *     </li>
         * </ul>
         */
        @Test
        @DisplayName("Shouldn't make any changes to the information of Anne Owens (without soft assertions)")
        void shouldNotMakeAnyChangesToInformationOfAnneOwensWithoutSoftAssertions() {
            repository.delete(UserAccounts.UNKNOWN_ID);

            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasId(UserAccounts.AnneOwens.ID)
                    .wasCreatedAt(UserAccounts.AnneOwens.CREATION_TIME_DB)
                    .hasDateOfBirth(UserAccounts.AnneOwens.DATE_OF_BIRTH_DB)
                    .hasEmailAddress(UserAccounts.AnneOwens.EMAIL_ADDRESS)
                    .hasGrantMarketingPermission(UserAccounts.AnneOwens.GRANT_MARKETING_PERMISSION)
                    .wasModifiedAt(UserAccounts.AnneOwens.MODIFICATION_TIME_DB)
                    .hasName(UserAccounts.AnneOwens.NAME)
                    .hasPassword(UserAccounts.AnneOwens.PASSWORD)
                    .hasStatus(UserAccounts.AnneOwens.STATUS_ACTIVE)
                    .hasVersion(UserAccounts.AnneOwens.VERSION);
        }

        /**
         * A separate assertion method has these benefits:
         * <ul>
         *     <li>It can use soft assertions. THis means that you have to run it only once.</li>
         *     <li>
         *         The assertion logic is found from one place. If you have to make changes to that logic,
         *         you don't have to make the same change to multiple places. Instead, you can make the
         *         required changes to your custom assertion class.
         *     </li>
         * </ul>
         *
         * However, because writing custom code has always a cost, you should always make a conscious
         * decision to use this approach.
         */
        @Test
        @DisplayName("Shouldn't make any changes to the information of Anne Owens (with soft assertions)")
        void shouldNotMakeAnyChangesToInformationOfAnneOwensWithSoftAssertions() {
            repository.delete(UserAccounts.UNKNOWN_ID);
            assertThatUserAccountTable(userAccountTable).hasDefaultInformationOfAnneOwens();
        }
    }
}
