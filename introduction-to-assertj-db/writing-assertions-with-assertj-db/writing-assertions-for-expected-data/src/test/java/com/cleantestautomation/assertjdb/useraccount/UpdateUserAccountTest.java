package com.cleantestautomation.assertjdb.useraccount;

import com.cleantestautomation.assertjdb.IdColumnReset;
import com.cleantestautomation.assertjdb.common.ConstantDateTimeService;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.assertj.db.api.Assertions.assertThat;

/**
 * This test class demonstrates how you can write assertions which ensure that the
 * column values of the correct table row were updated.
 */
@SpringBootTest
@ActiveProfiles("integrationTest")
@DisplayName("Update the information of an existing user account")
@Sql({
        "/db/clear-database.sql",
        "/db/init-user-accounts.sql"
})
public class UpdateUserAccountTest {

    private final UpdateUserAccount INPUT = UpdateUserAccount.getBuilder()
            .withId(UserAccounts.AnneOwens.ID)
            .withName(UserAccounts.AnneOwens.UPDATED_NAME)
            .build();

    private final DataSource dataSource;
    private final UserAccountRepository repository;
    private final Table userAccountTable;

    @Autowired
    UpdateUserAccountTest(DataSource dataSource, UserAccountRepository repository) {
        this.dataSource = dataSource;
        this.repository = repository;
        this.userAccountTable = new Table(this.dataSource, UserAccountTable.NAME);
    }

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
        assertThat(userAccountTable)
                .row(UserAccountTableRow.ANNE_OWENS.getIndex())
                .value(UserAccountTable.COLUMN_NAME_ID)
                .isEqualTo(UserAccounts.AnneOwens.ID);
    }

    @Test
    @DisplayName("Shouldn't update the creation time of the updated user account")
    void shouldNotUpdateCreationTimeOfUpdatedUserAccount() {
        repository.update(INPUT);
        assertThat(userAccountTable)
                .row(UserAccountTableRow.ANNE_OWENS.getIndex())
                .value(UserAccountTable.COLUMN_NAME_CREATION_TIME)
                .isEqualTo(UserAccounts.AnneOwens.CREATION_TIME_DB);
    }

    @Test
    @DisplayName("Shouldn't update the email address of the updated user account")
    void shouldNotUpdateEmailAddressOfUpdatedUserAccount() {
        repository.update(INPUT);
        assertThat(userAccountTable)
                .row(UserAccountTableRow.ANNE_OWENS.getIndex())
                .value(UserAccountTable.COLUMN_NAME_EMAIL_ADDRESS)
                .isEqualTo(UserAccounts.AnneOwens.EMAIL_ADDRESS);
    }

    @Test
    @DisplayName("Should update the modification time of the updated user account")
    void shouldUpdateModificationTimeOfUpdatedUserAccount() {
        repository.update(INPUT);
        assertThat(userAccountTable)
                .row(UserAccountTableRow.ANNE_OWENS.getIndex())
                .value(UserAccountTable.COLUMN_NAME_MODIFICATION_TIME)
                .isEqualTo(ConstantDateTimeService.CURRENT_LOCAL_DATE_TIME);
    }

    @Test
    @DisplayName("Should update the name of the updated user account")
    void shouldUpdateNameOfUpdatedUserAccount() {
        repository.update(INPUT);
        assertThat(userAccountTable)
                .row(UserAccountTableRow.ANNE_OWENS.getIndex())
                .value(UserAccountTable.COLUMN_NAME_NAME)
                .isEqualTo(UserAccounts.AnneOwens.UPDATED_NAME);
    }

    @Test
    @DisplayName("Shouldn't update the password of the updated user account")
    void shouldNotUpdatePasswordOfUpdatedUserAccount() {
        repository.update(INPUT);
        assertThat(userAccountTable)
                .row(UserAccountTableRow.ANNE_OWENS.getIndex())
                .value(UserAccountTable.COLUMN_NAME_PASSWORD)
                .isEqualTo(UserAccounts.AnneOwens.PASSWORD);
    }

    @Test
    @DisplayName("Shouldn't change the status of the updated user account")
    void shouldNotChangeStatusOfUpdatedUserAccount() {
        repository.update(INPUT);
        assertThat(userAccountTable)
                .row(UserAccountTableRow.ANNE_OWENS.getIndex())
                .value(UserAccountTable.COLUMN_NAME_STATUS)
                .isEqualTo(UserAccounts.AnneOwens.STATUS_ACTIVE.name());
    }

    @Test
    @DisplayName("Should increase the version of the updated user account by one")
    void shouldIncreaseVersionOfUpdatedUserAccountByOne() {
        repository.update(INPUT);
        assertThat(userAccountTable)
                .row(UserAccountTableRow.ANNE_OWENS.getIndex())
                .value(UserAccountTable.COLUMN_NAME_VERSION)
                .isEqualTo(UserAccounts.AnneOwens.VERSION + 1);
    }

    @Test
    @DisplayName("Should return the information of the updated user account")
    void shouldReturnInformationOfUpdatedUserAccount() {
        var updated = repository.update(INPUT);
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(updated.getId())
                    .as("id")
                    .isEqualByComparingTo(IdColumnReset.NEXT_ID);
            softAssertions.assertThat(updated.getEmailAddress())
                    .as("emailAddress")
                    .isEqualTo(UserAccounts.AnneOwens.EMAIL_ADDRESS);
            softAssertions.assertThat(updated.getName())
                    .as("name")
                    .isEqualTo(UserAccounts.AnneOwens.UPDATED_NAME);
            softAssertions.assertThat(updated.getStatus())
                    .as("status")
                    .isEqualTo(UserAccounts.AnneOwens.STATUS_ACTIVE);
        });
    }

    @Test
    @DisplayName("Shouldn't make any changes to the information of Leo Virtanen")
    void shouldNotMakeAnyChangesToInformationOfLeoVirtanen() {
        repository.update(INPUT);

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
                .value(UserAccountTable.COLUMN_NAME_EMAIL_ADDRESS)
                .isEqualTo(UserAccounts.LeoVirtanen.EMAIL_ADDRESS);
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
                .value(UserAccountTable.COLUMN_NAME_PASSWORD);
        assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_STATUS)
                .isEqualTo(UserAccounts.LeoVirtanen.STATUS_ACTIVE.name());
        assertThat(userAccountTable)
                .row(rowIndex)
                .value(UserAccountTable.COLUMN_NAME_VERSION)
                .isEqualTo(UserAccounts.LeoVirtanen.VERSION);
    }
}
