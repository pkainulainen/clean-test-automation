package com.cleantestautomation.assertjdb.todoitem;

import com.cleantestautomation.assertjdb.IdColumnReset;
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

/**
 * This exercise helps you understand how you can write soft assertions for the data
 * that's found from the specified database table.
 */
@SpringBootTest
@ActiveProfiles("integrationTest")
@DisplayName("Create a new todo item")
@Sql({
        "/db/clear-database.sql",
        "/db/init-user-accounts.sql"
})
class CreateTodoItemTest {

    private static final CreateTodoItem INPUT = CreateTodoItem.getBuilder()
            .withCreatorId(TodoItems.ReadAllLessons.getCreatedByUserId())
            .withDescription(TodoItems.ReadAllLessons.getDescription())
            .withTitle(TodoItems.ReadAllLessons.getTitle())
            .build();

    private final IdColumnReset idColumnReset;
    private final TodoItemRepository repository;
    private final Table todoItemTable;

    @Autowired
    CreateTodoItemTest(DataSource dataSource,
                       NamedParameterJdbcTemplate jdbcTemplate,
                       TodoItemRepository repository) {
        this.idColumnReset = new IdColumnReset(jdbcTemplate);
        this.repository = repository;
        this.todoItemTable = new Table(dataSource, TodoItemTable.NAME);
    }

    @BeforeEach
    void resetIdColumn() {
        idColumnReset.resetIdColumns(TodoItemTable.NAME);
    }

    @Test
    @DisplayName("Should insert an open todo item into the database")
    void shouldInsertOpenTodoItemIntoDatabase() {
        repository.create(INPUT);
        //TODO: Write the soft assertions which ensure that an open todo item is inserted into the database.
        //HINT: A todo is open when its status is: TodoItemStatus.OPEN and resolution is null.
    }
}
