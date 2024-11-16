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
                .withDateOfBirth(UserAccounts.UpdatedAnneOwens.getDateOfBirth())
                .withGrantMarketingPermission(UserAccounts.UpdatedAnneOwens.isGrantMarketingPermission())
                .withName(UserAccounts.UpdatedAnneOwens.getName())
                .build();

        @Test
        @DisplayName("Shouldn't insert new user accounts into the database or delete user accounts from the database")
        void shouldNotInsertNewUserAccountsIntoDatabaseOrDeleteUserAccountsFromDatabase() {
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
                    .hasId(UserAccounts.AnneOwens.getId())
                    .wasCreatedAt(UserAccounts.AnneOwens.getCreationTimeDb())
                    .hasDateOfBirth(UserAccounts.AnneOwens.getDateOfBirthDb())
                    .hasEmailAddress(UserAccounts.AnneOwens.getEmailAddress())
                    .hasGrantMarketingPermission(UserAccounts.AnneOwens.isGrantMarketingPermission())
                    .wasModifiedAt(UserAccounts.AnneOwens.getModificationTimeDb())
                    .hasName(UserAccounts.AnneOwens.getName())
                    .hasPassword(UserAccounts.AnneOwens.getPassword())
                    .hasStatus(UserAccounts.AnneOwens.getStatus())
                    .hasVersion(UserAccounts.AnneOwens.getVersion());
        }

        @Test
        @DisplayName("Shouldn't make any changes to the information of Leo Virtanen (without soft assertions)")
        void shouldNotMakeAnyChangesToInformationOfLeoVirtanenWithoutSoftAssertions() {
            repository.update(INPUT);

            assertThatUserAccount(userAccountTable, UserAccountTableRow.LEO_VIRTANEN)
                    .hasId(UserAccounts.LeoVirtanen.getId())
                    .wasCreatedAt(UserAccounts.LeoVirtanen.getCreationTimeDb())
                    .doesNotHaveDateOfBirth()
                    .hasEmailAddress(UserAccounts.LeoVirtanen.getEmailAddress())
                    .hasGrantMarketingPermission(UserAccounts.LeoVirtanen.isGrantMarketingPermission())
                    .wasModifiedAt(UserAccounts.LeoVirtanen.getModificationTimeDb())
                    .hasName(UserAccounts.LeoVirtanen.getName())
                    .hasPassword(UserAccounts.LeoVirtanen.getPassword())
                    .hasStatus(UserAccounts.LeoVirtanen.getStatus())
                    .hasVersion(UserAccounts.LeoVirtanen.getVersion());
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
                .withId(UserAccounts.UpdatedAnneOwens.getId())
                .withDateOfBirth(UserAccounts.UpdatedAnneOwens.getDateOfBirth())
                .withGrantMarketingPermission(UserAccounts.UpdatedAnneOwens.isGrantMarketingPermission())
                .withName(UserAccounts.UpdatedAnneOwens.getName())
                .build();

        @Test
        @DisplayName("Shouldn't insert new user accounts into the database or delete user accounts from the database")
        void shouldNotInsertNewUserAccountsIntoDatabaseOrDeleteUserAccountsFromDatabase() {
            repository.update(INPUT);
            assertThat(userAccountTable).hasNumberOfRows(UserAccounts.USER_ACCOUNT_ROW_COUNT);
        }

        @Test
        @DisplayName("Shouldn't change the id of the updated user account")
        void shouldNotChangeIdOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasId(UserAccounts.UpdatedAnneOwens.getId());
        }

        @Test
        @DisplayName("Shouldn't update the creation time of the updated user account")
        void shouldNotUpdateCreationTimeOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .wasCreatedAt(UserAccounts.UpdatedAnneOwens.getCreationTimeDb());
        }

        @Test
        @DisplayName("Should update the date of birth of the updated user account")
        void shouldUpdateDateOfBirthOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasDateOfBirth(UserAccounts.UpdatedAnneOwens.getDateOfBirthDb());
        }

        @Test
        @DisplayName("Shouldn't update the email address of the updated user account")
        void shouldNotUpdateEmailAddressOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasEmailAddress(UserAccounts.UpdatedAnneOwens.getEmailAddress());
        }

        @Test
        @DisplayName("Should update the grant marketing permission of the updated user account")
        void shouldUpdateGrantMarketingPermissionOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasGrantMarketingPermission(UserAccounts.UpdatedAnneOwens.isGrantMarketingPermission());
        }

        @Test
        @DisplayName("Should update the modification time of the updated user account")
        void shouldUpdateModificationTimeOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .wasModifiedAt(UserAccounts.UpdatedAnneOwens.getModificationTimeDb());
        }

        @Test
        @DisplayName("Should update the name of the updated user account")
        void shouldUpdateNameOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasName(UserAccounts.UpdatedAnneOwens.getName());
        }

        @Test
        @DisplayName("Shouldn't update the password of the updated user account")
        void shouldNotUpdatePasswordOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasPassword(UserAccounts.UpdatedAnneOwens.getPassword());
        }

        @Test
        @DisplayName("Shouldn't change the status of the updated user account")
        void shouldNotChangeStatusOfUpdatedUserAccount() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasStatus(UserAccounts.UpdatedAnneOwens.getStatus());
        }

        @Test
        @DisplayName("Should increase the version of the updated user account by one")
        void shouldIncreaseVersionOfUpdatedUserAccountByOne() {
            repository.update(INPUT);
            assertThatUserAccount(userAccountTable, UserAccountTableRow.ANNE_OWENS)
                    .hasVersion(UserAccounts.UpdatedAnneOwens.getVersion());
        }

        @Test
        @DisplayName("Should return the information of the updated user account")
        void shouldReturnInformationOfUpdatedUserAccount() {
            var updated = repository.update(INPUT);
            assertSoftly(softAssertions -> {
                softAssertions.assertThat(updated.getId())
                        .as("id")
                        .isEqualByComparingTo(UserAccounts.UpdatedAnneOwens.getId());
                softAssertions.assertThat(updated.getDateOfBirth())
                        .as("dateOfBirth")
                        .isEqualTo(UserAccounts.UpdatedAnneOwens.getDateOfBirth());
                softAssertions.assertThat(updated.getEmailAddress())
                        .as("emailAddress")
                        .isEqualTo(UserAccounts.UpdatedAnneOwens.getEmailAddress());
                softAssertions.assertThat(updated.isGrantMarketingPermission())
                        .as("grantMarketingPermission")
                        .isEqualTo(UserAccounts.UpdatedAnneOwens.isGrantMarketingPermission());
                softAssertions.assertThat(updated.getName())
                        .as("name")
                        .isEqualTo(UserAccounts.UpdatedAnneOwens.getName());
                softAssertions.assertThat(updated.getStatus())
                        .as("status")
                        .isEqualTo(UserAccounts.UpdatedAnneOwens.getStatus());
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
                    .hasId(UserAccounts.LeoVirtanen.getId())
                    .wasCreatedAt(UserAccounts.LeoVirtanen.getCreationTimeDb())
                    .doesNotHaveDateOfBirth()
                    .hasEmailAddress(UserAccounts.LeoVirtanen.getEmailAddress())
                    .hasGrantMarketingPermission(UserAccounts.LeoVirtanen.isGrantMarketingPermission())
                    .wasModifiedAt(UserAccounts.LeoVirtanen.getModificationTimeDb())
                    .hasName(UserAccounts.LeoVirtanen.getName())
                    .hasPassword(UserAccounts.LeoVirtanen.getPassword())
                    .hasStatus(UserAccounts.LeoVirtanen.getStatus())
                    .hasVersion(UserAccounts.LeoVirtanen.getVersion());
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
