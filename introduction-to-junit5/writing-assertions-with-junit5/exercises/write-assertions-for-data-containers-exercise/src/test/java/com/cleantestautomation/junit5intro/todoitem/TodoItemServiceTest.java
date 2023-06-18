package com.cleantestautomation.junit5intro.todoitem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("Tests for CRUD operations of todo items")
public class TodoItemServiceTest {

    private TodoItemRepository repository;
    private TodoItemService service;

    @BeforeEach
    void configureSystemUnderTest() {
        repository = mock(TodoItemRepository.class);
        service = new TodoItemService(repository);
    }

    @Nested
    @DisplayName("Find all todo items")
    class FindAll {

        @Nested
        @DisplayName("When no todo items is found")
        class WhenNoTodoItemsIsFound {

            @BeforeEach
            void todoItemQueryReturnsEmptyList() {
                given(repository.findAll()).willReturn(List.of());
            }

            @Test
            @DisplayName("Should return an empty list")
            void shouldReturnEmptyList() {
                var todoItems = service.findAll();
                //TODO: Write the required assertion
            }
        }

        @Nested
        @DisplayName("When two todo items are found")
        class WhenTwoTodoItemsAreFound {

            private final Long ID_ONE = 1L;
            private final String TITLE_ONE = "Write assertions";
            private final Long ID_TWO = 2L;
            private final String TITLE_TWO = "Run tests";

            private TodoItemListItem firstListItem;
            private TodoItemListItem secondListItem;

            @BeforeEach
            void todoItemQueryReturnsTwoTodoItems() {
                firstListItem = new TodoItemListItem();
                firstListItem.setId(ID_ONE);
                firstListItem.setTitle(TITLE_ONE);

                secondListItem = new TodoItemListItem();
                secondListItem.setId(ID_TWO);
                secondListItem.setTitle(TITLE_TWO);

                given(repository.findAll()).willReturn(List.of(firstListItem, secondListItem));
            }

            @Test
            @DisplayName("Should return two todo items")
            void shouldReturnTwoTodoItems() {
                var todoItems = service.findAll();
                //TODO: Write the required assertion
            }

            @Test
            @DisplayName("Should return the expected todo items in the correct order")
            void shouldReturnExpectedTodoItemsInCorrectOrder() {
                var todoItems = service.findAll();
                //TODO: Write the required assertion
            }

            @Test
            @DisplayName("Should return the correct first todo item")
            void shouldReturnCorrectFirstTwoItem() {
                var todoItems = service.findAll();
                //Todo: Write the required assertions. Hint: Write assertions for the property values
            }

            @Test
            @DisplayName("Should return the correct second todo item")
            void shouldReturnCorrectSecondItem() {
                var todoItems = service.findAll();
                //Todo: Write the required assertions. Hint: Write assertions for the property values
            }

            @Test
            @DisplayName("Should return a list that contains the first todo item")
            void shouldReturnListThatContainsFirstTodoItem() {
                var todoItems = service.findAll();
                //TODO: Write the required assertion
            }

            @Test
            @DisplayName("Should return a list doesn't contain the unknown todo item")
            void shouldReturnListThatDoesNotContainUnknownTodoItem() {
                var unknown = new TodoItemListItem();
                var todoItems = service.findAll();
                //TODO: Write the required assertion
            }
        }
    }
}
