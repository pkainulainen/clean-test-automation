package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;

/**
 * This class demonstrates how you can write assertions for
 * arrays with Hamcrest.
 */
@DisplayName("Write assertions for arrays")
class ArrayAssertionTest {

    @Nested
    @DisplayName("When you write assertions for values")
    class WhenYouWriteAssertionsForValues {

        private final Integer[] ARRAY = new Integer[]{2, 5, 7};
        private final int EXPECTED_SIZE = 3;

        @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
            assertThat(new Integer[]{}, emptyArray());
        }

        @Test
        @DisplayName("Shouldn't be empty")
        void shouldNotBeEmpty() {
            assertThat(ARRAY, not(emptyArray()));
        }

        @Test
        @DisplayName("Should contain three elements")
        void shouldContainThreeElements() {
            assertThat(ARRAY, arrayWithSize(EXPECTED_SIZE));
        }

        @Test
        @DisplayName("Should contain only the expected elements in the given order")
        void shouldContainOnlyExpectedElementsInGivenOrder() {
            assertThat(ARRAY, arrayContaining(2, 5, 7));
        }

        @Test
        @DisplayName("Should contain only the expected elements in any order")
        void shouldContainOnlyExpectedElementsInAnyOrder() {
            assertThat(ARRAY, arrayContainingInAnyOrder(5, 7, 2));
        }

        @Test
        @DisplayName("Should contain the given element")
        void shouldContainGivenElement() {
            assertThat(ARRAY, hasItemInArray(5));
        }

        @Test
        @DisplayName("Shouldn't contain the given element")
        void shouldNotContainGivenElement() {
            assertThat(ARRAY, not(hasItemInArray(99)));
        }
    }

    @Nested
    @DisplayName("When you compare two arrays")
    class WhenYouCompareTwoArrays {

        @Nested
        @DisplayName("When the arrays are equal")
        class WhenArraysAreEqual {

            @Nested
            @DisplayName("When the arrays contain integers")
            class WhenArraysContainIntegers {

                private final int[] ACTUAL = new int[]{2, 5, 7};
                private final int[] EXPECTED = new int[]{2, 5, 7};

                @Test
                @DisplayName("Should contain the same integers")
                void shouldContainSameIntegers() {
                    assertThat(ACTUAL, equalTo(EXPECTED));
                }
            }

            @Nested
            @DisplayName("When the arrays contain strings")
            class WhenArraysContainStrings {

                private final String[] ACTUAL = new String[] {"foo", "bar"};
                private final String[] EXPECTED = new String[] {"foo", "bar"};

                @Test
                @DisplayName("Should contain the same strings")
                void shouldContainSameStrings() {
                    assertThat(ACTUAL, equalTo(EXPECTED));
                }
            }
        }

        @Nested
        @DisplayName("When the arrays aren't equal")
        class WhenArraysAreNotEqual {

            @Nested
            @DisplayName("When arrays contain integers")
            class WhenArraysContainIntegers {

                private final int[] ACTUAL = new int[]{2, 6, 7};
                private final int[] UNEXPECTED = new int[]{2, 5, 7};

                @Test
                @DisplayName("Shouldn't contain the same integers")
                void shouldNotContainSameIntegers() {
                    assertThat(ACTUAL, not(UNEXPECTED));
                }
            }

            @Nested
            @DisplayName("When arrays contain strings")
            class WhenArraysContainStrings {

                private final String[] ACTUAL = new String[] {"foo", "bar1"};
                private final String[] UNEXPECTED = new String[] {"foo", "bar"};

                @Test
                @DisplayName("Shouldn't contain the same strings")
                void shouldNotContainSameStrings() {
                    assertThat(ACTUAL, not(UNEXPECTED));
                }
            }
        }
    }
}