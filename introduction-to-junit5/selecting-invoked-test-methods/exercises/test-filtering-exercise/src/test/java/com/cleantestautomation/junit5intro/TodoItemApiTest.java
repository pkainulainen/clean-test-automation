package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for the todo item API")
@Tag("unitTest")
@Tag("apiTest")
class TodoItemApiTest {

    @Test
    @DisplayName("API test")
    void apiTest() {
        System.out.println("API test");
    }
}
