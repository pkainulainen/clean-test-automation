package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how you can write assertions for objects
 * with AssertJ.
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
            assertThat(OBJECT).isNull();
        }
    }

    @Nested
    @DisplayName("When object isn't null")
    class WhenObjectIsNotNotNull {

        private final Object NOT_NULL = new Object();

        @Test
        @DisplayName("Shouldn't be null")
        void shouldNotBeNull() {
            assertThat(NOT_NULL).isNotNull();
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
                assertThat(ACTUAL).isEqualByComparingTo(EXPECTED);
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
                assertThat(ACTUAL).isEqualTo(EXPECTED);
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
                assertThat(ACTUAL).isNotEqualByComparingTo(UNEXPECTED);
            }
        }

        @Nested
        @DisplayName("When objects are strings")
        class WhenObjectsAreStrings {

            private final String ACTUAL = "Foo";
            private final String UNEXPECTED = "Bar";

            @Test
            @DisplayName("Should not be equal")
            void shouldNotBeEqual() {
                assertThat(ACTUAL).isNotEqualTo(UNEXPECTED);
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
            assertThat(ACTUAL).isSameAs(EXPECTED);
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
            assertThat(ACTUAL).isNotSameAs(UNEXPECTED);
        }
    }
}
