package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

/**
 * This extension demonstrates when an extension that implements the
 * {@link ParameterResolver} interface is run by JUnit 5.
 */
public class ParameterResolverExtension implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        //It's a better idea to annotate the parameter with a "marker" annotation
        //and check if this parameter has the "marker" annotation. I use this approach
        //here because it doesn't require extra code.
        return parameterContext.getParameter().getType().isAssignableFrom(String.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        System.out.println("Extension point: resolveParameter");
        return "Hello world!";
    }
}
