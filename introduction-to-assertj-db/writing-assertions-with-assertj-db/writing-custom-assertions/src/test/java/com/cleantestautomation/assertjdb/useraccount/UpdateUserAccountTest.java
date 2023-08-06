package com.cleantestautomation.assertjdb.useraccount;

import com.cleantestautomation.assertjdb.IdColumnReset;
import com.cleantestautomation.assertjdb.common.ConstantDateTimeService;
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
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.assertj.db.api.Assertions.assertThat;

/**
 * This test class demonstrates how you can use custom assertion classes when you want to
 * ensure that the column values of the correct table row were updated.
 */
@SpringBootTest
@ActiveProfiles("integrationTest")
@DisplayName("Update the information of an existing user account")
@Sql({
        "/db/clear-database.sql",
        "/db/init-user-accounts.sql"
})
public class UpdateUserAccountTest {

    private final UserAccountRepository repository;
    private final Table userAccountTable;

    @Autowired
    UpdateUserAccountTest(DataSource dataSource, UserAccountRepository repository) {
        this.repository = repository;
        this.userAccountTable = new Table(dataSource, UserAccountTable.NAME);
    }

    @Nested
    @DisplayName("When the updated user account isn't found")
    class WhenUpdatedUSerAccountIsNotFound {

        private final UpdateUserAccount INPUT = UpdateUserAccount.getBuilder()
                .withId(UserAccounts.UNKNOWN_ID)
                .withDateOfBirth(UserAccounts.AnneOwens.UPDATED_DATE_OF_BIRTH)
                .withGrantMarketingPermission(UserAccounts.AnneOwens.UPDATED_GRANT_MARKETING_PERMISSION)
                .withName(UserAccounts.AnneOwens.UPDATED_NAME)
                .build();

        @Test
        @DisplayName("Shouldn't insert new user accounts into the database")
        void shouldNotInsertNewUserAccountsIntoDatabase() {
            repository.update(INPUT);
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
            repository.update(INPUT);

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
            repository.update(INPUT);

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
            repository.update(INPUT);
            assertThatUserAccountTable(userAccountTable).hasDefaultInformationOfAnneOwens();
        }

        @Test
        @DisplayName("Shouldn't make any changes to the information of Leo Virtanen (with soft assertions)")
        void shouldNotMakeAnyChangesToInformationOfLeoVirtanenWithSoftAssertions() {
            repository.update(INPUT);
            assertThatUserAccountTable(userAccountTable).hasDefaultInformationOfLeoVirtanen();
        }

        @Test
        @DisplayName("Should return null")
        void shouldReturnNull() {
            var updated = repository.update(INPUT);
            Assertions.assertThat(updated).isNull();
        }
    }

    @Nested
    @DisplayName("When the updated user account is found")
    class WhenUpdatedUserAccountIsFound {

        private final UpdateUserAccount INPUT = UpdateUserAccount.getBuilder()
                .withId(UserAccounts.AnneOwens.ID)
                .withDateOfBirth(UserAccounts.AnneOwens.UPDATED_DATE_OF_BIRTH)
                .withGrantMarketingPermission(UserAccounts.AnneOwens.UPDATED_GRANT_MARKETING_PERMISSION)
                .withName(UserAccounts.AnneOwens.UPDATED_NAME)
                .build();

        @Test
        @DisplayName("Shouldn't insert new user accounts into the database")
        void shouldNotInsertNewUserAccountsIntoDatabase() {
            repository.update(INPUT);
            assertThat(userAccountTable).hasNumberOfRows(UserAccounts.USER_ACCOUNT_ROW_COUNT);
        }

        @Test
        @DisplayName("Shouldn't change the id of the updated user account")
        void shouldNotChangeIdOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasId(UserAccounts.AnneOwens.ID);
        }

        @Test
        @DisplayName("Shouldn't update the creation time of the updated user account")
        void shouldNotUpdateCreationTimeOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .wasCreatedAt(UserAccounts.AnneOwens.CREATION_TIME_DB);
        }

        @Test
        @DisplayName("Should update the date of birth of the updated user account")
        void shouldUpdateDateOfBirthOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasDateOfBirth(UserAccounts.AnneOwens.UPDATED_DATE_OF_BIRTH_DB);
        }

        @Test
        @DisplayName("Shouldn't update the email address of the updated user account")
        void shouldNotUpdateEmailAddressOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasEmailAddress(UserAccounts.AnneOwens.EMAIL_ADDRESS);
        }

        @Test
        @DisplayName("Should update the grant marketing permission of the updated user account")
        void shouldUpdateGrantMarketingPermissionOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasGrantMarketingPermission(UserAccounts.AnneOwens.UPDATED_GRANT_MARKETING_PERMISSION);
        }

        @Test
        @DisplayName("Should update the modification time of the updated user account")
        void shouldUpdateModificationTimeOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .wasModifiedAt(ConstantDateTimeService.CURRENT_LOCAL_DATE_TIME);
        }

        @Test
        @DisplayName("Should update the name of the updated user account")
        void shouldUpdateNameOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasName(UserAccounts.AnneOwens.UPDATED_NAME);
        }

        @Test
        @DisplayName("Shouldn't update the password of the updated user account")
        void shouldNotUpdatePasswordOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasPassword(UserAccounts.AnneOwens.PASSWORD);
        }

        @Test
        @DisplayName("Shouldn't change the status of the updated user account")
        void shouldNotChangeStatusOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasStatus(UserAccounts.AnneOwens.STATUS_ACTIVE);
        }

        @Test
        @DisplayName("Should increase the version of the updated user account by one")
        void shouldIncreaseVersionOfUpdatedUserAccountByOne() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasVersion(UserAccounts.AnneOwens.VERSION + 1);
        }

        @Test
        @DisplayName("Should return the information of the updated user account")
        void shouldReturnInformationOfUpdatedUserAccount() {
            var updated = repository.update(INPUT);
            assertSoftly(softAssertions -> {
                softAssertions.assertThat(updated.getId())
                        .as("id")
                        .isEqualByComparingTo(IdColumnReset.NEXT_ID);
                softAssertions.assertThat(updated.getDateOfBirth())
                        .as("dateOfBirth")
                        .isEqualTo(UserAccounts.AnneOwens.UPDATED_DATE_OF_BIRTH_DB);
                softAssertions.assertThat(updated.getEmailAddress())
                        .as("emailAddress")
                        .isEqualTo(UserAccounts.AnneOwens.EMAIL_ADDRESS);
                softAssertions.assertThat(updated.isGrantMarketingPermission())
                        .as("grantMarketingPermission")
                        .isEqualTo(UserAccounts.AnneOwens.UPDATED_GRANT_MARKETING_PERMISSION);
                softAssertions.assertThat(updated.getName())
                        .as("name")
                        .isEqualTo(UserAccounts.AnneOwens.UPDATED_NAME);
                softAssertions.assertThat(updated.getStatus())
                        .as("status")
                        .isEqualTo(UserAccounts.AnneOwens.STATUS_ACTIVE);
            });
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
        @DisplayName("Shouldn't make any changes to the information of Leo Virtanen (without soft assertions)")
        void shouldNotMakeAnyChangesToInformationOfLeoVirtanenWithoutSoftAssertions() {
            repository.update(INPUT);

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
        @DisplayName("Shouldn't make any changes to the information of Leo Virtanen (with soft assertions)")
        void shouldNotMakeAnyChangesToInformationOfLeoVirtanenWithSoftAssertions() {
            repository.update(INPUT);
            assertThatUserAccountTable(userAccountTable).hasDefaultInformationOfLeoVirtanen();
        }
    }
}
