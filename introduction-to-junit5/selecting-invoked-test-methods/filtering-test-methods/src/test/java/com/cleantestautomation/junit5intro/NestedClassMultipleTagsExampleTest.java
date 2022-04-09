package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NestedClassMultipleTagsExampleTest {

    @Nested
    @DisplayName("When the test has the tags A and B")
    @Tag("A")
    @Tag("B")
    class WhenTestHasTagAAndB {

        @Test
        @DisplayName("This test method has the tags A and B")
        void testHasTagsAAndB() {
            System.out.println("This test method has the tags A and B");
        }
    }
}
