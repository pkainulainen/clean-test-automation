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
 * This test class demonstrates how you can write assertions which ensure that a new row
 * is inserted into the database.
 */
@SpringBootTest
@ActiveProfiles("integrationTest")
@DisplayName("Create a new user account")
@Sql({
        "/db/clear-database.sql"
})
public class CreateUserAccountTest {

    private final CreateUserAccount INPUT = CreateUserAccount.getBuilder()
            .withEmailAddress(UserAccounts.AnneOwens.EMAIL_ADDRESS)
            .withName(UserAccounts.AnneOwens.NAME)
            .withPassword(UserAccounts.AnneOwens.PASSWORD)
            .withStatus(UserAccounts.AnneOwens.STATUS_ACTIVE)
            .build();

    private final DataSource dataSource;
    private final IdColumnReset idColumnReset;
    private final UserAccountRepository repository;
    private final Table userAccountTable;

    @Autowired
    CreateUserAccountTest(DataSource dataSource,
                          NamedParameterJdbcTemplate jdbcTemplate,
                          UserAccountRepository repository) {
        this.dataSource = dataSource;
        this.idColumnReset = new IdColumnReset(jdbcTemplate);
        this.repository = repository;
        this.userAccountTable = new Table(dataSource, UserAccountTable.NAME);
    }

    @BeforeEach
    void resetIdColumn() {
        idColumnReset.resetIdColumns(UserAccountTable.NAME);
    }

    @Test
    @DisplayName("Should insert a new user account into the database")
    void shouldInsertNewUserAccountIntoDatabase() {
        repository.create(INPUT);
        assertThat(userAccountTable).hasNumberOfRows(1);
    }

    @Test
    @DisplayName("Should use the next free id when a new user account is inserted into the database")
    void shouldUseNextFreeIdWhenNewUserAccountIsInsertedIntoDatabase() {
        repository.create(INPUT);
        assertThat(userAccountTable)
                .row(UserAccountTableRow.NEW_USER_ACCOUNT.getIndex())
                .value(UserAccountTable.COLUMN_NAME_ID)
                .isEqualTo(IdColumnReset.NEXT_ID);
    }

    @Test
    @DisplayName("Should insert the correct creation time into the database")
    void shouldInsertCorrectCreationTimeIntoDatabase() {
        repository.create(INPUT);
        assertThat(userAccountTable)
                .row(UserAccountTableRow.NEW_USER_ACCOUNT.getIndex())
                .value(UserAccountTable.COLUMN_NAME_CREATION_TIME)
                .isEqualTo(ConstantDateTimeService.CURRENT_LOCAL_DATE_TIME);
    }

    @Test
    @DisplayName("Should insert the correct email address into the database")
    void shouldInsertCorrectEmailAddressIntoDatabase() {
        repository.create(INPUT);
        assertThat(userAccountTable)
                .row(UserAccountTableRow.NEW_USER_ACCOUNT.getIndex())
                .value(UserAccountTable.COLUMN_NAME_EMAIL_ADDRESS)
                .isEqualTo(UserAccounts.AnneOwens.EMAIL_ADDRESS);
    }

    @Test
    @DisplayName("Should insert the correct modification time into the database")
    void shouldInsertCorrectModificationTimeIntoDatabase() {
        repository.create(INPUT);
        assertThat(userAccountTable)
                .row(UserAccountTableRow.NEW_USER_ACCOUNT.getIndex())
                .value(UserAccountTable.COLUMN_NAME_MODIFICATION_TIME)
                .isEqualTo(ConstantDateTimeService.CURRENT_LOCAL_DATE_TIME);
    }

    @Test
    @DisplayName("Should insert the correct name into the database")
    void shouldInsertCorrectNameIntoDatabase() {
        repository.create(INPUT);
        assertThat(userAccountTable)
                .row(UserAccountTableRow.NEW_USER_ACCOUNT.getIndex())
                .value(UserAccountTable.COLUMN_NAME_NAME)
                .isEqualTo(UserAccounts.AnneOwens.NAME);
    }

    @Test
    @DisplayName("Should insert the correct password into the database")
    void shouldInsertCorrectPasswordIntoTheDatabase() {
        repository.create(INPUT);
        assertThat(userAccountTable)
                .row(UserAccountTableRow.NEW_USER_ACCOUNT.getIndex())
                .value(UserAccountTable.COLUMN_NAME_PASSWORD)
                .isEqualTo(UserAccounts.AnneOwens.PASSWORD);
    }

    @Test
    @DisplayName("Should insert the correct status into the database")
    void shouldInsertCorrectStatusIntoDatabase() {
        repository.create(INPUT);
        assertThat(userAccountTable)
                .row(UserAccountTableRow.NEW_USER_ACCOUNT.getIndex())
                .value(UserAccountTable.COLUMN_NAME_STATUS)
                .isEqualTo(UserAccounts.AnneOwens.STATUS_ACTIVE.name());
    }

    @Test
    @DisplayName("Should insert the correct version into the database")
    void shouldInsertCorrectVersionIntoDatabase() {
        repository.create(INPUT);
        assertThat(userAccountTable)
                .row(UserAccountTableRow.NEW_USER_ACCOUNT.getIndex())
                .value(UserAccountTable.COLUMN_NAME_VERSION)
                .isEqualTo(UserAccounts.DEFAULT_VERSION);
    }

    @Test
    @DisplayName("Should return the information of the created user account")
    void shouldReturnInformationOfCreatedUserAccount() {
        var created = repository.create(INPUT);
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(created.getId())
                    .as("id")
                    .isEqualByComparingTo(IdColumnReset.NEXT_ID);
            softAssertions.assertThat(created.getEmailAddress())
                    .as("emailAddress")
                    .isEqualTo(UserAccounts.AnneOwens.EMAIL_ADDRESS);
            softAssertions.assertThat(created.getName())
                    .as("name")
                    .isEqualTo(UserAccounts.AnneOwens.NAME);
            softAssertions.assertThat(created.getStatus())
                    .as("status")
                    .isEqualTo(UserAccounts.AnneOwens.STATUS_ACTIVE);
        });
    }
}
