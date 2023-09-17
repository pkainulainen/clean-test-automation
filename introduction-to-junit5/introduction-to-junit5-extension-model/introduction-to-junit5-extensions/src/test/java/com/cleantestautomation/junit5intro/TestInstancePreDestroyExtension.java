package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePreDestroyCallback;

/**
 * This extension demonstrates when an extension that implements
 * the {@link TestInstancePreDestroyCallback} interface is run by JUnit 5.
 */
public class TestInstancePreDestroyExtension implements TestInstancePreDestroyCallback {

    @Override
    public void preDestroyTestInstance(ExtensionContext extensionContext) throws Exception {
        System.out.println("Extension point: preDestroyTestInstance");
    }
}
