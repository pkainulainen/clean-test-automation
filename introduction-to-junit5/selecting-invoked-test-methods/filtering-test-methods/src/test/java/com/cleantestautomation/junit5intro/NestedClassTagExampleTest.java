package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NestedClassTagExampleTest {

    @Nested
    @DisplayName("When the test has the tag A")
    @Tag("A")
    class WhenTestHasTagA {

        @Test
        @DisplayName("This test method has the tag A")
        void testHasTagA() {
            System.out.println("This test method has the tag A");
        }
    }

    @Nested
    @DisplayName("When the test has the tag B")
    @Tag("B")
    class WhenTestHasTagB {

        @Test
        @DisplayName("This test method has the tag B")
        void testHasTagB() {
            System.out.println("This test method has the tag B");
        }
    }
}
