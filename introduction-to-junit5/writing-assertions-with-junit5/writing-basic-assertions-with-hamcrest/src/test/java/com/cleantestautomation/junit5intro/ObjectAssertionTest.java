package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;

/**
 * This class demonstrates how you can write assertions for objects
 * with Hamcrest.
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
            assertThat(OBJECT, nullValue());
        }

        @Test
        @DisplayName("Should be null (with custom error message)")
        void shouldBeNullWithCustomErrorMessage() {
            assertThat(String.format("Expected object to be null but it was: %s", OBJECT),
                    OBJECT,
                    nullValue()
            );
        }
    }

    @Nested
    @DisplayName("When object is not null")
    class WhenObjectIsNotNotNull {

        private final Object NOT_NULL = new Object();

        @Test
        @DisplayName("Should not be null")
        void shouldNotBeNull() {
            assertThat(NOT_NULL, notNullValue());
        }

        @Test
        @DisplayName("Should not be null (with custom error message)")
        void shouldNotBeNullWithCustomErrorMessage() {
            assertThat("Expected the object to be not null but it was null",
                    NOT_NULL,
                    notNullValue()
            );
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
                assertThat(ACTUAL, equalTo(EXPECTED));
            }

            @Test
            @DisplayName("Should be equal (with custom error message)")
            void shouldBeEqualWithCustomErrorMessage() {
                assertThat(
                        String.format("Expected the integer to be: %d but it was: %d",
                                EXPECTED,
                                ACTUAL
                        ),
                        ACTUAL,
                        equalTo(EXPECTED)
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
                assertThat(ACTUAL, equalTo(EXPECTED));
            }

            @Test
            @DisplayName("Should be equal (with custom error message)")
            void shouldBeEqualWithCustomErrorMessage() {
                assertThat(
                        String.format("Expected the string to be: %s but it was: %s",
                                EXPECTED,
                                ACTUAL
                        ),
                        ACTUAL,
                        equalTo(EXPECTED)
                );
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
            private final Integer EXPECTED = 4;

            @Test
            @DisplayName("Should not be equal")
            void shouldNotBeEqual() {
                assertThat(ACTUAL, not(EXPECTED));
            }

            @Test
            @DisplayName("Should not be equal (with custom error message)")
            void shouldNotBeEqualWithCustomErrorMessage() {
                assertThat(
                        String.format(
                                "Expected that the integer: %d to not be equal to the integer: %d but they were equal",
                                ACTUAL,
                                EXPECTED
                        ),
                        ACTUAL,
                        not(EXPECTED)
                );
            }
        }

        @Nested
        @DisplayName("When objects are strings")
        class WhenObjectsAreStrings {

            private final String ACTUAL = "Foo";
            private final String EXPECTED = "Bar";

            @Test
            @DisplayName("Should not be equal")
            void shouldNotBeEqual() {
                assertThat(ACTUAL, not(EXPECTED));
            }

            @Test
            @DisplayName("Should not be equal (with custom error message)")
            void shouldNotBeEqualWithCustomErrorMessage() {
                assertThat(
                        String.format(
                                "Expected that the string: %s to not be equal to the string: %s but they were equal",
                                ACTUAL,
                                EXPECTED
                        ),
                        ACTUAL,
                        not(EXPECTED)
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
            assertThat(ACTUAL, sameInstance(EXPECTED));
        }

        @Test
        @DisplayName("Should refer to the same object (with custom error message)")
        void shouldReferToSameErrorObjectWithCustomErrorMessage() {
            assertThat("The objects don't refer to the same object", ACTUAL, sameInstance(EXPECTED));
        }
    }

    @Nested
    @DisplayName("When two objects don't refer to the same object")
    class WhenTwoObjectsDoNotReferToSameObject {

        private final Object ACTUAL = new Object();
        private final Object EXPECTED = new Object();

        @Test
        @DisplayName("Should not refer to the same object")
        void shouldNotReferToSameObject() {
            assertThat(ACTUAL, not(sameInstance(EXPECTED)));
        }

        @Test
        @DisplayName("Should not refer to the same object (with custom error message)")
        void shouldNotReferToSameObjectWithCustomErrorMessage() {
            assertThat("The objects refer to the same objects", ACTUAL, not(sameInstance(EXPECTED)));
        }
    }
}
