package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
/**
 * This extension demonstrates when an extension that implements the
 * {@link TestInstancePostProcessor} interface is run by JUnit 5.
 */
public class TestInstancePostProcessorExtension implements TestInstancePostProcessor {

    @Override
    public void postProcessTestInstance(Object o, ExtensionContext extensionContext) throws Exception {
        System.out.println("Extension point: postProcessTestInstance");
    }
}
