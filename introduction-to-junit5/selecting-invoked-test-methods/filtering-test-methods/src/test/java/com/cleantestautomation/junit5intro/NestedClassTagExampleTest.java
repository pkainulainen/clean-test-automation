package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NestedClassTagExampleTest {

    @Nested
    @DisplayName("When the test has the tag: A")
    @Tag("A")
    class WhenTestHasTagA {

        @Test
        @DisplayName("Should be invoked when we run tests which have the tag: A")
        void shouldBeInvokedInvokedWhenWeRunTestsWhichHaveTagA() {
            System.out.println("Should be invoked when we run tests which have the tag: A");
        }
    }

    @Nested
    @DisplayName("When the test has the tag: B")
    @Tag("B")
    class WhenTestHasTagB {

        @Test
        @DisplayName("Should be invoked when we run tests which have the tag: B")
        void shouldBeInvokedInvokedWhenWeRunTestsWhichHaveTagB() {
            System.out.println("Should be invoked when we run tests which have the tag: B");
        }
    }
}
