package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how you can write assertions for
 * arrays with AssertJ.
 */
@DisplayName("Write assertions for arrays")
class ArrayAssertionTest {

    @Nested
    @DisplayName("When you write assertions for values")
    class WhenYouWriteAssertionsForValues {

        final int[] ARRAY = new int[]{2, 5, 7};

        @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
            assertThat(new int[]{}).isEmpty();
        }

        @Test
        @DisplayName("Shouldn't be empty")
        void shouldNotBeEmpty() {
            assertThat(ARRAY).isNotEmpty();
        }

        @Test
        @DisplayName("Should contain three values")
        void shouldContainThreeValues() {
            assertThat(ARRAY).hasSize(3);
        }

        @Test
        @DisplayName("Should contain the given values in the given order")
        void shouldContainGivenValuesInGivenOrder() {
            assertThat(ARRAY).containsExactly(2, 5, 7);
        }

        @Test
        @DisplayName("Should contain the given values in any order")
        void shouldContainGivenValuesInAnyOrder() {
            assertThat(ARRAY).containsExactlyInAnyOrder(5, 7, 2);
        }

        @Test
        @DisplayName("Should contain the given value once")
        void shouldContainGivenValueOnce() {
            assertThat(ARRAY).containsOnlyOnce(5);
        }

        @Test
        @DisplayName("Shouldn't contain the given value")
        void shouldNotContainGivenValue() {
            assertThat(ARRAY).doesNotContain(99);
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

                final int[] ACTUAL = new int[]{2, 5, 7};
                final int[] EXPECTED = new int[]{2, 5, 7};

                @Test
                @DisplayName("Should contain the same integers")
                void shouldContainSameIntegers() {
                    assertThat(ACTUAL).isEqualTo(EXPECTED);
                }
            }

            @Nested
            @DisplayName("When the arrays contain strings")
            class WhenArraysContainStrings {

                final String[] ACTUAL = new String[] {"foo", "bar"};
                final String[] EXPECTED = new String[] {"foo", "bar"};

                @Test
                @DisplayName("Should contain the same strings")
                void shouldContainSameStrings() {
                    assertThat(ACTUAL).isEqualTo(EXPECTED);
                }
            }
        }
        
        @Nested
        @DisplayName("When the arrays aren't equal")
        class WhenArraysAreNotEqual {

            @Nested
            @DisplayName("When arrays contain integers")
            class WhenArraysContainIntegers {

                final int[] ACTUAL = new int[]{2, 6, 7};
                final int[] EXPECTED = new int[]{2, 5, 7};

                @Test
                @DisplayName("Should not contain the same integers")
                void shouldNotContainSameIntegers() {
                    assertThat(ACTUAL).isNotEqualTo(EXPECTED);
                }
            }

            @Nested
            @DisplayName("When arrays contain strings")
            class WhenArraysContainStrings {

                final String[] ACTUAL = new String[] {"foo", "bar1"};
                final String[] EXPECTED = new String[] {"foo", "bar"};

                @Test
                @DisplayName("Should not contain the same strings")
                void shouldNotContainSameStrings() {
                    assertThat(ACTUAL).isNotEqualTo(EXPECTED);
                }
            }
        }
    }
}