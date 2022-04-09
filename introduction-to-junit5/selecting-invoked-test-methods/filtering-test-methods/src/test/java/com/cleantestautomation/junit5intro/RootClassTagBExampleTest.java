
package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("B")
class RootClassTagBExampleTest {

    @Test
    @DisplayName("This test method has the tag B")
    void testHasTagB() {
        System.out.println("This test method has the tag B");
    }
}
