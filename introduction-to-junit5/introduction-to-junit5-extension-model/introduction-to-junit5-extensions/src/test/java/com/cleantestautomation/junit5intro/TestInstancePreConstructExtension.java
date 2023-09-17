package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstanceFactoryContext;
import org.junit.jupiter.api.extension.TestInstancePreConstructCallback;

/**
 * This extension demonstrates when an extension that implements the
 * {@link TestInstancePreConstructCallback} interface is run by JUnit 5.
 */
public class TestInstancePreConstructExtension implements TestInstancePreConstructCallback {

    @Override
    public void preConstructTestInstance(TestInstanceFactoryContext testInstanceFactoryContext,
                                         ExtensionContext extensionContext) throws Exception {
            System.out.println("Extension point: preConstructTestInstance");
    }
}
