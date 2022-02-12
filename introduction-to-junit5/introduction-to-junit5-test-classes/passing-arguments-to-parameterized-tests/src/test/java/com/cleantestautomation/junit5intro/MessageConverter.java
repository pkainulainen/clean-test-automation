package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

/**
 * This class demonstrates how you can implement a custom converter
 * that can convert {@code String} objects into {@link Message} objects.
 */
final class MessageConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        checkSource(source);

        String sourceString = (String) source;
        return new Message(sourceString);
    }

    private void checkSource(Object source) {
        if (source == null) {
            throw new ArgumentConversionException("Cannot convert null source object");
        }

        if (!source.getClass().equals(String.class)) {
            throw new ArgumentConversionException("Cannot convert source object because it's not a string");
        }

        String sourceString = (String) source;
        if (sourceString.trim().isEmpty()) {
            throw new ArgumentConversionException("Cannot convert an empty source string");
        }
    }
}
