package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * This test class demonstrates the invocation order of
 * setup, teardown, and test methods when you are writing
 * nested tests with JUnit 5.
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

    @Nested
    @DisplayName("Tests for the method A")
    class A {

        @BeforeEach
        void beforeEach() {
            System.out.println("Before each test method of the A class");
        }

        @AfterEach
        void afterEach() {
            System.out.println("After each test method of the A class");
        }

        @Test
        @DisplayName("Example test for method A")
        void sampleTestForMethodA() {
            System.out.println("Example test for method A");
        }

        @Nested
        @DisplayName("When X is true")
        class WhenX {

            @BeforeEach
            void beforeEach() {
                System.out.println("Before each test method of the WhenX class");
            }

            @AfterEach
            void afterEach() {
                System.out.println("After each test method of the WhenX class");
            }

            @Test
            @DisplayName("Example test for method A when X is true")
            void sampleTestForMethodAWhenX() {
                System.out.println("Example test for method A when X is true");
            }
        }

        @Nested
        @DisplayName("When Y is true")
        class WhenY {

            @BeforeEach
            void beforeEach() {
                System.out.println("Before each test method of the WhenY class");
            }

            @AfterEach
            void afterEach() {
                System.out.println("After each test method of the WhenY class");
            }

            @Test
            @DisplayName("Example test for method A when Y is true")
            void sampleTestForMethodAWhenY() {
                System.out.println("Example test for method A when Y is true");
            }
        }
    }
}
