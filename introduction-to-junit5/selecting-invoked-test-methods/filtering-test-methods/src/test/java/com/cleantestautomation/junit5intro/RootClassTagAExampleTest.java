package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("A")
class RootClassTagAExampleTest {

    @Test
    @DisplayName("Should be invoked when we run tests which have the tag: A")
    void shouldBeInvokedInvokedWhenWeRunTestsWhichHaveTagA() {
        System.out.println("Should be invoked when we run tests which have the tag: A");
    }
}
