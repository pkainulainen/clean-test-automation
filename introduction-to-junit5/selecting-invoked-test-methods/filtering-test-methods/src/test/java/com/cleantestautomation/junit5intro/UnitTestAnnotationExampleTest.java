package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@UnitTest
class UnitTestAnnotationExampleTest {

    @Test
    @DisplayName("Should be invoked when we run unit tests")
    void shouldBeInvokedInvokedWhenWeRunUnitTests() {
        System.out.println("Should be invoked when we run unit tests");
    }
}
