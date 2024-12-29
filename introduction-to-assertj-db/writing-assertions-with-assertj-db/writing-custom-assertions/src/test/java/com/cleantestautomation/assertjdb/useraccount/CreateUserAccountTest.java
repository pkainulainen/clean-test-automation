package com.cleantestautomation.assertjdb.useraccount;

import com.cleantestautomation.assertjdb.IdColumnReset;
import com.cleantestautomation.assertjdb.common.ConstantDateTimeService;
import org.assertj.db.type.AssertDbConnectionFactory;
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

import static com.cleantestautomation.assertjdb.useraccount.UserAccountTableRowAssertions.assertThatUserAccount;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.assertj.db.api.Assertions.assertThat;

/**
 * This test class demonstrates how you can use a custom assertion class when you want to
 * ensure that the expected information is inserted into the database.
 */
@SpringBootTest
@ActiveProfiles("integrationTest")
@DisplayName("Create a new user account")
@Sql({
        "/db/clear-database.sql"
})
public class CreateUserAccountTest {

    private final CreateUserAccount INPUT = CreateUserAccount.getBuilder()
            .withDateOfBirth(UserAccounts.AnneOwens.getDateOfBirth())
            .withEmailAddress(UserAccounts.AnneOwens.getEmailAddress())
            .withGrantMarketingPermission(UserAccounts.AnneOwens.isGrantMarketingPermission())
            .withName(UserAccounts.AnneOwens.getName())
            .withPassword(UserAccounts.AnneOwens.getPassword())
            .withStatus(UserAccounts.AnneOwens.getStatus())
            .build();

    private final IdColumnReset idColumnReset;
    private final UserAccountRepository repository;
    private final Table userAccountTable;

    @Autowired
    CreateUserAccountTest(DataSource dataSource,
                          NamedParameterJdbcTemplate jdbcTemplate,
                          UserAccountRepository repository) {
        this.idColumnReset = new IdColumnReset(jdbcTemplate);
        this.repository = repository;
        this.userAccountTable = AssertDbConnectionFactory.of(dataSource)
                .create()
                .table(UserAccountTable.NAME)
                .build();
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
        assertThatUserAccount(userAccountTable, UserAccountTableRow.NEW_USER_ACCOUNT)
                .hasId(IdColumnReset.NEXT_ID);
    }

    @Test
    @DisplayName("Should insert the correct creation time into the database")
    void shouldInsertCorrectCreationTimeIntoDatabase() {
        repository.create(INPUT);
        assertThatUserAccount(userAccountTable, UserAccountTableRow.NEW_USER_ACCOUNT)
                .wasCreatedAt(ConstantDateTimeService.CURRENT_LOCAL_DATE_TIME);
    }

    @Test
    @DisplayName("Should insert the correct date of birth into the database")
    void shouldInsertCorrectDateOfBirthIntoDatabase() {
        repository.create(INPUT);
        assertThatUserAccount(userAccountTable, UserAccountTableRow.NEW_USER_ACCOUNT)
                .hasDateOfBirth(UserAccounts.AnneOwens.getDateOfBirthDb());
    }

    @Test
    @DisplayName("Should insert the correct email address into the database")
    void shouldInsertCorrectEmailAddressIntoDatabase() {
        repository.create(INPUT);
        assertThatUserAccount(userAccountTable, UserAccountTableRow.NEW_USER_ACCOUNT)
                .hasEmailAddress(UserAccounts.AnneOwens.getEmailAddress());
    }

    @Test
    @DisplayName("Should insert the correct grant marketing permission into the database")
    void shouldInsertCorrectGrantMarketingPermissionIntoDatabase() {
        repository.create(INPUT);
        assertThatUserAccount(userAccountTable, UserAccountTableRow.NEW_USER_ACCOUNT)
                .hasGrantMarketingPermission(UserAccounts.AnneOwens.isGrantMarketingPermission());
    }

    @Test
    @DisplayName("Should insert the correct modification time into the database")
    void shouldInsertCorrectModificationTimeIntoDatabase() {
        repository.create(INPUT);
        assertThatUserAccount(userAccountTable, UserAccountTableRow.NEW_USER_ACCOUNT)
                .wasModifiedAt(ConstantDateTimeService.CURRENT_LOCAL_DATE_TIME);
    }

    @Test
    @DisplayName("Should insert the correct name into the database")
    void shouldInsertCorrectNameIntoDatabase() {
        repository.create(INPUT);
        assertThatUserAccount(userAccountTable, UserAccountTableRow.NEW_USER_ACCOUNT)
                .hasName(UserAccounts.AnneOwens.getName());
    }

    @Test
    @DisplayName("Should insert the correct password into the database")
    void shouldInsertCorrectPasswordIntoTheDatabase() {
        repository.create(INPUT);
        assertThatUserAccount(userAccountTable, UserAccountTableRow.NEW_USER_ACCOUNT)
                .hasPassword(UserAccounts.AnneOwens.getPassword());
    }

    @Test
    @DisplayName("Should insert the correct status into the database")
    void shouldInsertCorrectStatusIntoDatabase() {
        repository.create(INPUT);
        assertThatUserAccount(userAccountTable, UserAccountTableRow.NEW_USER_ACCOUNT)
                .hasStatus(UserAccounts.AnneOwens.getStatus());
    }

    @Test
    @DisplayName("Should insert the correct version into the database")
    void shouldInsertCorrectVersionIntoDatabase() {
        repository.create(INPUT);
        assertThatUserAccount(userAccountTable, UserAccountTableRow.NEW_USER_ACCOUNT)
                .hasVersion(UserAccounts.DEFAULT_VERSION);
    }

    @Test
    @DisplayName("Should return the information of the created user account")
    void shouldReturnInformationOfCreatedUserAccount() {
        var created = repository.create(INPUT);
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(created.getId())
                    .as("id")
                    .isEqualByComparingTo(IdColumnReset.NEXT_ID);
            softAssertions.assertThat(created.getDateOfBirth())
                    .as("dateOfBirth")
                    .isEqualTo(UserAccounts.AnneOwens.getDateOfBirth());
            softAssertions.assertThat(created.getEmailAddress())
                    .as("emailAddress")
                    .isEqualTo(UserAccounts.AnneOwens.getEmailAddress());
            softAssertions.assertThat(created.isGrantMarketingPermission())
                    .as("grantMarketingPermission")
                    .isEqualTo(UserAccounts.AnneOwens.isGrantMarketingPermission());
            softAssertions.assertThat(created.getName())
                    .as("name")
                    .isEqualTo(UserAccounts.AnneOwens.getName());
            softAssertions.assertThat(created.getStatus())
                    .as("status")
                    .isEqualTo(UserAccounts.AnneOwens.getStatus());
        });
    }
}
