package com.cleantestautomation.junit5intro.todoitem;

import org.junit.jupiter.api.*;

import java.util.Optional;

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
    @DisplayName("Find todo item by using its id as search criteria")
    class FindById {

        private final Long ID = 1L;

        @Nested
        @DisplayName("When the todo item isn't found")
        class WhenTodoItemIsNotFound {

            @BeforeEach
            void todoItemQueryReturnsEmptyOptional() {
                given(repository.findById(ID)).willReturn(Optional.empty());
            }

            @Test
            @DisplayName("Should throw the correct exception")
            void shouldThrowCorrectException() {
                //TODO: Write the assertion
            }

            @Test
            @DisplayName("Should throw an exception that has the correct message")
            void shouldThrowExceptionThatHasCorrectMessage() {
                //TODO: Write the assertion
            }
        }

        @Nested
        @DisplayName("When the todo item is found")
        class WhenTodoItemIsFound {

            private final String DESCRIPTION = "Learn how to write assertions.";
            private final String TITLE = "Write assertions";

            @BeforeEach
            void todoItemQueryReturnsTodoItem() {
                var found = new TodoItem();
                found.setId(ID);
                found.setDescription(DESCRIPTION);
                found.setTitle(TITLE);

                given(repository.findById(ID)).willReturn(Optional.of(found));
            }

            @Test
            @DisplayName("Should return the correct todo item")
            void shouldReturnCorrectTodoItem() {
                var found = service.findById(ID);
                //TODO: Write the required assertion. Hint: The value of the id property identifies a todo item.
            }

            @Test
            @DisplayName("Should return a todo item that has the correct description")
            void shouldReturnTodoItemThatHasCorrectDescription() {
                var found = service.findById(ID);
                //TODO: Write the required assertion.
            }

            @Test
            @DisplayName("Should return a todo item that has the correct title")
            void shouldReturnTodoItemThatHasCorrectTitle() {
                var found = service.findById(ID);
                //TODO: Write the required assertion.
            }
        }
    }
}
