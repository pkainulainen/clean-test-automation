
package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RootClassMethodMultipleTagsExampleTest {

    @Test
    @DisplayName("Should be invoked when we run tests which have the tag: A")
    @Tag("A")
    @Tag("B")
    void shouldBeRunWeRunTestsWhichEitherTagAOrB() {
        System.out.println("Should be run when we run tests which have either the tag A or B");
    }
}
