package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NestedClassMethodMultipleTagsExampleTest {

    @Nested
    @DisplayName("Contains tagged test method")
    class ContainsTaggedTestMethod {

        @Test
        @DisplayName("Should be invoked when we run tests which have the tag: A")
        @Tag("A")
        @Tag("B")
        void shouldBeRunWeRunTestsWhichEitherTagAOrB() {
            System.out.println("Should be run when we run tests which have either the tag A or B");
        }
    }
}
