package com.cleantestautomation.assertjdb;

import org.assertj.db.type.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

import static org.assertj.db.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("integrationTest")
@DisplayName("Tests for the content of the user_account database table")
class UserAccountTableTest {

    private final Table userAccountTable;

    @Autowired
    UserAccountTableTest(DataSource dataSource) {
        this.userAccountTable = new Table(dataSource, "user_account");
    }

    @Test
    @DisplayName("The user_account table should have no rows")
    void shouldHaveNoRows() {
        assertThat(userAccountTable).isEmpty();
    }
}
