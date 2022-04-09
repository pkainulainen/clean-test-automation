package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RootClassMethodTagExampleTest {

    @Test
    @DisplayName("This test method has the tag A")
    @Tag("A")
    void testHasTagA() {
        System.out.println("This test method has the tag A");
    }

    @Test
    @DisplayName("This test method has the tag B")
    @Tag("B")
    void testHasTagB() {
        System.out.println("This test method has the tag B");
    }
}
