package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * This extension demonstrates when an extension that implements the
 * {@link ExecutionCondition} interface is run by JUnit 5.
 */
public class ExecutionConditionExtension implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
        System.out.println("Extension point: evaluateExecutionCondition");
        return ConditionEvaluationResult.enabled("We will run all tests");
    }
}
