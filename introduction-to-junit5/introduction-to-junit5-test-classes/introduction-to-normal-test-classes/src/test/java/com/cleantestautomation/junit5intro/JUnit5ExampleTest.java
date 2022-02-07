package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This test class demonstrates the invocation order of
 * setup, teardown, and test methods.
 */
@DisplayName("JUnit 5 Example")
class JUnit5ExampleTest {

    /**
     * This setup method is run once before any test
     * method is run.
     */
    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all test methods");
    }

    /**
     * This setup method is run before a test method is run.
     */
    @BeforeEach
    void beforeEach() {
        System.out.println("Before each test method");
    }

    /**
     * This teardown method is run after a test method has been
     * run.
     */
    @AfterEach
    void afterEach() {
        System.out.println("After each test method");
    }

    /**
     * This teardown method is run once after all test methods
     * have been run.
     */
    @AfterAll
    static void afterAll() {
        System.out.println("After all test methods");
    }

    @Test
    @DisplayName("First test")
    void firstTest() {
        System.out.println("First test method");
    }

    @Test
    @DisplayName("Second test")
    void secondTest() {
        System.out.println("Second test method");
    }
}
