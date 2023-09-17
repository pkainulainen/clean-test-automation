package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstanceFactory;
import org.junit.jupiter.api.extension.TestInstanceFactoryContext;
import org.junit.jupiter.api.extension.TestInstantiationException;

import java.lang.reflect.InvocationTargetException;

/**
 * This extension demonstrates when an extension that implements the
 * {@link TestInstanceFactory} interface is run by JUnit 5.
 */
public class TestInstanceFactoryExtension implements TestInstanceFactory {

    @Override
    public Object createTestInstance(TestInstanceFactoryContext testInstanceFactoryContext, ExtensionContext extensionContext) throws TestInstantiationException {
        System.out.println("Extension point: createTestInstance");
        try {
            //This is obviously a really horrible hack. Don't do this in your own code.
            return testInstanceFactoryContext.getTestClass().getDeclaredConstructors()[0].newInstance();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
