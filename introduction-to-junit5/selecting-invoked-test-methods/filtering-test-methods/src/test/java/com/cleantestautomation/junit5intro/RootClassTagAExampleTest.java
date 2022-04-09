package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("A")
class RootClassTagAExampleTest {

    @Test
    @DisplayName("This test method has the tag A")
    void testHasTagA() {
        System.out.println("This test method has the tag A");
    }
}
