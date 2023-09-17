package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

/**
 * This extension demonstrates when an extension that implements the
 * {@link TestWatcher} interface is run by JUnit 5.
 */
public class TestWatcherExtension implements TestWatcher {

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("Extension point: testAborted");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Extension point: testFailed");
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("Extension point: testDisabled");
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Extension point: testSuccessful");
    }
}
