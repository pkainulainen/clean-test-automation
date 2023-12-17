package com.cleantestautomation.junit5intro;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

/**
 * This JUnit 5 extension injects a new {@link MessageService} object into
 * every field of a test class (including super classes) that's annotated
 * with the {@link SysterUnderTest} annotation.
 */
public class MessageServiceExtension implements TestInstancePostProcessor {

    private static final boolean IGNORE_ACCESS_RESTRICTIONS = true;

    @Override
    public void postProcessTestInstance(Object testInstance,
                                        ExtensionContext extensionContext) throws Exception {
        var messageServiceFields = FieldUtils.getFieldsListWithAnnotation(testInstance.getClass(),
                SysterUnderTest.class
        );
        messageServiceFields.forEach(field -> {
            var config = field.getAnnotation(SysterUnderTest.class);
            var messageService = new MessageService(config.message());
            try {
                FieldUtils.writeField(field, testInstance, messageService, IGNORE_ACCESS_RESTRICTIONS);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
