package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * This class demonstrates how you can write assertions for objects
 * with JUnit 5 assertion API.
 */
@DisplayName("Write assertions for objects")
class ObjectAssertionTest {

    @Nested
    @DisplayName("When object is null")
    class WhenObjectIsNull {

        private final Object OBJECT = null;

        @Test
        @DisplayName("Should be null")
        void shouldBeNull() {
            assertNull(OBJECT);
        }

        @Test
        @DisplayName("Should be null (with custom error message)")
        void shouldBeNullWithCustomErrorMessage() {
            assertNull(OBJECT, String.format("Expected object to be null but it was: %s", OBJECT));
        }
    }

    @Nested
    @DisplayName("When object isn't null")
    class WhenObjectIsNotNotNull {

        private final Object NOT_NULL = new Object();

        @Test
        @DisplayName("Shouldn't be null")
        void shouldNotBeNull() {
            assertNotNull(NOT_NULL);
        }

        @Test
        @DisplayName("Shouldn't be null (with custom error message)")
        void shouldNotBeNullWithCustomErrorMessage() {
            assertNotNull(NOT_NULL, "Expected the object to be not null but it was null");
        }
    }

    @Nested
    @DisplayName("When two objects are equal")
    class WhenTwoObjectsAreEqual {

        @Nested
        @DisplayName("When objects are integers")
        class WhenObjectsAreIntegers {

            private final Integer ACTUAL = 9;
            private final Integer EXPECTED = 9;

            @Test
            @DisplayName("Should be equal")
            void shouldBeEqual() {
                assertEquals(EXPECTED, ACTUAL);
            }

            @Test
            @DisplayName("Should be equal (with custom error message)")
            void shouldBeEqualWithCustomErrorMessage() {
                assertEquals(EXPECTED,
                        ACTUAL,
                        String.format("Expected the integer to be: %d but it was: %d",
                                EXPECTED,
                                ACTUAL
                        )
                );
            }
        }

        @Nested
        @DisplayName("When objects are strings")
        class WhenObjectsAreStrings {

            private final String ACTUAL = "Foo";
            private final String EXPECTED = "Foo";

            @Test
            @DisplayName("Should be equal")
            void shouldBeEqual() {
                assertEquals(EXPECTED, ACTUAL);
            }

            @Test
            @DisplayName("Should be equal (with custom error message)")
            void shouldBeEqualWithCustomErrorMessage() {
                assertEquals(EXPECTED,
                        ACTUAL,
                        String.format(
                                "Expected the string to be: %s but it was: %s",
                                EXPECTED,
                                ACTUAL
                        ));
            }
        }
    }

    @Nested
    @DisplayName("When two objects aren't equal")
    class WhenTwoObjectsAreNotEqual {

        @Nested
        @DisplayName("When objects are integers")
        class WhenObjectsAreIntegers {

            private final Integer ACTUAL = 9;
            private final Integer UNEXPECTED = 4;

            @Test
            @DisplayName("Shouldn't be equal")
            void shouldNotBeEqual() {
                assertNotEquals(UNEXPECTED, ACTUAL);
            }

            @Test
            @DisplayName("Shouldn't be equal (with custom error message)")
            void shouldNotBeEqualWithCustomErrorMessage() {
                assertNotEquals(UNEXPECTED,
                        ACTUAL,
                        String.format(
                                "Expected the integer: %d to not be equal to the integer: %d but they were equal",
                                UNEXPECTED,
                                ACTUAL
                        )
                );
            }
        }

        @Nested
        @DisplayName("When objects are strings")
        class WhenObjectsAreStrings {

            private final String ACTUAL = "Foo";
            private final String UNEXPECTED = "Bar";

            @Test
            @DisplayName("Shouldn't be equal")
            void shouldNotBeEqual() {
                assertNotEquals(UNEXPECTED, ACTUAL);
            }

            @Test
            @DisplayName("Shouldn't be equal (with custom error message)")
            void shouldNotBeEqualWithCustomErrorMessage() {
                assertNotEquals(UNEXPECTED,
                        ACTUAL,
                        String.format(
                                "Expected that the string: %s is not equal to the string: %s but they were equal",
                                UNEXPECTED,
                                ACTUAL
                        )
                );
            }
        }
    }

    @Nested
    @DisplayName("When two objects refer to the same object")
    class WhenTwoObjectsReferToSameObject {

        private final Object ACTUAL = new Object();
        private final Object EXPECTED = ACTUAL;

        @Test
        @DisplayName("Should refer to the same object")
        void shouldReferToSameObject() {
            assertSame(EXPECTED, ACTUAL);
        }

        @Test
        @DisplayName("Should refer to the same object (with custom error message)")
        void shouldReferToSameErrorObjectWithCustomErrorMessage() {
            assertSame(EXPECTED, ACTUAL, "The objects don't refer to the same object");
        }
    }

    @Nested
    @DisplayName("When two objects don't refer to the same object")
    class WhenTwoObjectsDoNotReferToSameObject {

        private final Object ACTUAL = new Object();
        private final Object UNEXPECTED = new Object();

        @Test
        @DisplayName("Shouldn't refer to the same object")
        void shouldNotReferToSameObject() {
            assertNotSame(UNEXPECTED, ACTUAL);
        }

        @Test
        @DisplayName("Shouldn't refer to the same object (with custom error message)")
        void shouldNotReferToSameObjectWithCustomErrorMessage() {
            assertNotSame(UNEXPECTED, ACTUAL, "The objects refer to the same object");
        }
    }
}
