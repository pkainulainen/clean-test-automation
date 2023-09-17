package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Extension point example")
@ExtendWith({
        TestInstancePreConstructExtension.class,
        TestInstanceFactoryExtension.class,
        TestInstancePostProcessorExtension.class,
        ExecutionConditionExtension.class,
        ParameterResolverExtension.class,
        TestLifecycleCallbackExtension.class,
        LifecycleMethodExceptionHandlerExtension.class,
        TestWatcherExtension.class,
        TestMethodExceptionHandlerExtension.class,
        TestInstancePreDestroyExtension.class
})
class ExtensionPointExampleTest {

    ExtensionPointExampleTest() {
        System.out.println("Constructor");
    }

    @BeforeAll
    static void beforeAll(String message) {
        System.out.println("Lifecycle callback: @BeforeAll");
    }

    @BeforeEach
    void beforeEach(String message) {
        System.out.println("Lifecycle callback: @BeforeEach");
    }

    @AfterEach
    void afterEach(String message) {
        System.out.println("Lifecycle callback: @AfterEach");
    }

    @AfterAll
    static void afterAll(String message) {
        System.out.println("Lifecycle callback: @AfterAll");
    }

    @Test
    @DisplayName("Test method")
    void test(String message) {
        System.out.println("Test method");
    }
}
