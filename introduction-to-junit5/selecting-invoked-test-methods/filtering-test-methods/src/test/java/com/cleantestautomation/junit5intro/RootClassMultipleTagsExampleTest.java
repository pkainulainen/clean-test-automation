package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("A")
@Tag("B")
class RootClassMultipleTagsExampleTest {

    @Test
    @DisplayName("Should be run when we run tests which have either the tag A or B")
    void shouldBeRunWeRunTestsWhichEitherTagAOrB() {
        System.out.println("Should be run when we run tests which have either the tag A or B");
    }
}
