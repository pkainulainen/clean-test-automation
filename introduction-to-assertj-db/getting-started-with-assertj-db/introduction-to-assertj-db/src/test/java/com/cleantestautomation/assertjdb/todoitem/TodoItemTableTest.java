package com.cleantestautomation.assertjdb.todoitem;

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
@DisplayName("Tests for the content of the todo_item database table")
class TodoItemTableTest {

    @Autowired
    TodoItemTableTest(DataSource dataSource) {

    }
}
