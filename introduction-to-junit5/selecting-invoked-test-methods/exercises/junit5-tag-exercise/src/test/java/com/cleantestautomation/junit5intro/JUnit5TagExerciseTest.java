package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("JUnit 5 Tag Exercise")
class JUnit5TagExerciseTest {

    @Test
    @DisplayName("A test method found from the root class")
    void testMethodFoundFromRootClass() {
        System.out.println("This test method is found from the root class");
    }

    @Nested
    @DisplayName("Nested test class one")
    class NestedTestClassOne {

        @Test
        @DisplayName("A test method found from the NestedTestClassOne class")
        void testMethodFoundFromNestedTestClassOneClass() {
            System.out.println("This test method is found from the NestedTestClassOne class");
        }
    }

    @Nested
    @DisplayName("Nested test class two")
    class NestedTestClassTwo {

        @Test
        @DisplayName("A test method found from the NestedTestClassTwo class")
        void testMethodFoundFromNestedTestClassTwoClass() {
            System.out.println("This test method is found from the NestedTestClassTwo class");
        }
    }
}
