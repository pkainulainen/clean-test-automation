package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("A")
@Tag("B")
class RootClassMultipleTagsExampleTest {

    @Test
    @DisplayName("This test method has the tags A and B")
    void testHasTagsAAndB() {
        System.out.println("This test method has the tags A and B");
    }
}
