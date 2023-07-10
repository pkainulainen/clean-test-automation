package com.cleantestautomation.assertjdb.todoitem;

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
 * This exercise helps you understand how you can write assertions which ensure that
 * the correct information is inserted into a relational database.
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
            .withCreatorId(TodoItems.ReadAllLessons.CREATED_BY_USER_ID)
            .withDescription(TodoItems.ReadAllLessons.DESCRIPTION)
            .withTitle(TodoItems.ReadAllLessons.TITLE)
            .build();

    private final DataSource dataSource;
    private final IdColumnReset idColumnReset;
    private final TodoItemRepository repository;
    private final Table todoItemTable;

    @Autowired
    CreateTodoItemTest(DataSource dataSource,
                       NamedParameterJdbcTemplate jdbcTemplate,
                       TodoItemRepository repository) {
        this.dataSource = dataSource;
        this.idColumnReset = new IdColumnReset(jdbcTemplate);
        this.repository = repository;
        this.todoItemTable = new Table(this.dataSource, TodoItemTable.NAME);
    }

    @BeforeEach
    void resetIdColumn() {
        idColumnReset.resetIdColumns(TodoItemTable.NAME);
    }

    @Test
    @DisplayName("Should insert a new todo item into the database")
    void shouldInsertNewTodoItemIntoDatabase() {
        repository.create(INPUT);
        //TODO: Write the assertion which ensures that the todo_item table has one row.
    }

    @Test
    @DisplayName("Should use the next free id when a new todo is inserted into the database")
    void shouldUseNextFreeIdWhenNewTodoItemIsInsertedIntoDatabase() {
        repository.create(INPUT);
        //TODO: Write the assertion which ensures that the next free id is inserted into the database.
    }

    @Test
    @DisplayName("Should insert the correct creator ID into the database")
    void shouldInsertCorrectCreatorIdIntoDatabase() {
        repository.create(INPUT);
        //TODO: Write the assertion which ensures that the correct creator id is inserted into the database.
    }

    @Test
    @DisplayName("Should insert the correct creation time into the database")
    void shouldInsertCorrectCreationTimeIntoDatabase() {
        repository.create(INPUT);
        //TODO: Write the assertion which ensures that the correct creation time is inserted into the database.
    }

    @Test
    @DisplayName("Should insert the correct description into the database")
    void shouldInsertCorrectDescriptionIntoDatabase() {
        repository.create(INPUT);
        //TODO: Write the assertion which ensures that the correct description is inserted into the database.
    }

    @Test
    @DisplayName("Should insert the correct modification time into the database")
    void shouldInsertCorrectModificationTimeIntoDatabase() {
        repository.create(INPUT);
        //TODO: Write the assertion which ensures that the correct modification time is inserted into the database.
    }

    @Test
    @DisplayName("Should insert the correct modifier ID into the database")
    void shouldInsertCorrectModifierIdIntoDatabase() {
        repository.create(INPUT);
        //TODO: Write the assertion which ensures that the correct modifier id is inserted into the database.
    }

    @Test
    @DisplayName("Should insert an open todo item into the database")
    void shouldInsertOpenTodoItemIntoDatabase() {
        repository.create(INPUT);
        //TODO: Write the assertions which ensure that an open todo item is inserted into the database.
        //HINT: A todo is open when its status is: TodoItemStatus.OPEN and resolution is null.
    }

    @Test
    @DisplayName("Should insert the correct title into the database")
    void shouldInsertCorrectTitleIntoDatabase() {
        repository.create(INPUT);
        //TDDO: Write the assertions which ensure that the correct title is inserted into the database.
    }

    @Test
    @DisplayName("Should insert the correct version into the database")
    void shouldInsertCorrectVersionIntoDatabase() {
        repository.create(INPUT);
        //TODO: Write the assertion which ensures that the correct version is inserted into the database.
    }

    @Test
    @DisplayName("Should return the information of the created todo item")
    void shouldReturnInformationOfCreatedTodoItem() {
        var created = repository.create(INPUT);
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(created.getId())
                    .as("id")
                    .isEqualByComparingTo(IdColumnReset.NEXT_ID);
            softAssertions.assertThat(created.getDescription())
                    .as("description")
                    .isEqualTo(TodoItems.ReadAllLessons.DESCRIPTION);
            softAssertions.assertThat(created.getResolution())
                    .as("resolution")
                    .isNull();
            softAssertions.assertThat(created.getStatus())
                    .as("status")
                    .isEqualTo(TodoItems.ReadAllLessons.STATUS_OPEN);
            softAssertions.assertThat(created.getTitle())
                    .as("title")
                    .isEqualTo(TodoItems.ReadAllLessons.TITLE);
        });
    }
}
