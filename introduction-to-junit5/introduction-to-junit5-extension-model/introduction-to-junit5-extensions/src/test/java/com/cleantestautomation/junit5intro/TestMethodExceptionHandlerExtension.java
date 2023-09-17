package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

/**
 * This extension demonstrates when an extension that implements the
 * {@link TestExecutionExceptionHandler} interface is run by JUnit 5.
 */
public class TestMethodExceptionHandlerExtension implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        System.out.println("Extension point: handleTestExecutionException");
    }
}
