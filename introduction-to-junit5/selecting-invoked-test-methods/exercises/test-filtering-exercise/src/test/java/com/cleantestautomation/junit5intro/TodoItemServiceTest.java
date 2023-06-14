package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for CRUD operations of todo items")
@Tag("unitTest")
@Tag("serviceTest")
class TodoItemServiceTest {

    @Test
    @DisplayName("Service test")
    void serviceTest() {
        System.out.println("Service test");
    }
}
