package com.cleantestautomation.assertjdb;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

/**
 * This exercise help you to understand how you can configure AssertJ-DB.
 */
@SpringBootTest
@ActiveProfiles("integrationTest")
@DisplayName("Tests for the content of the user_account database table")
class TodoItemTableTest {

    private final DataSource dataSource;

    @Autowired
    TodoItemTableTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
