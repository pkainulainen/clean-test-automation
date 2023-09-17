package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.LifecycleMethodExecutionExceptionHandler;

/**
 * This extension demonstrates when an extension that implements the
 * {@link LifecycleMethodExecutionExceptionHandler} interface is run by JUnit 5.
 */
public class LifecycleMethodExceptionHandlerExtension implements LifecycleMethodExecutionExceptionHandler {

    @Override
    public void handleBeforeAllMethodExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        System.out.println("Extension point: handleBeforeAllMethodExecutionException");
    }

    @Override
    public void handleBeforeEachMethodExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        System.out.println("Extension point: handleBeforeEachMethodExecutionException");
    }

    @Override
    public void handleAfterEachMethodExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        System.out.println("Extension point: handleAfterEachMethodExecutionException");
    }

    @Override
    public void handleAfterAllMethodExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        System.out.println("Extension point: handleAfterAllMethodExecutionException");
    }
}
