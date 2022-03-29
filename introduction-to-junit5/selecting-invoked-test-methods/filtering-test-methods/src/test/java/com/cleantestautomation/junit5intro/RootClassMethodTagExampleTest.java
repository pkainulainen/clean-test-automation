package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RootClassMethodTagExampleTest {

    @Test
    @DisplayName("Should be invoked when we run tests which have the tag: A")
    @Tag("A")
    void shouldBeInvokedInvokedWhenWeRunTestsWhichHaveTagA() {
        System.out.println("Should be invoked when we run tests which have the tag: A");
    }

    @Test
    @DisplayName("Should be invoked when we run tests which have the tag: B")
    @Tag("B")
    void shouldBeInvokedInvokedWhenWeRunTestsWhichHaveTagB() {
        System.out.println("Should be invoked when we run tests which have the tag: B");
    }
}
