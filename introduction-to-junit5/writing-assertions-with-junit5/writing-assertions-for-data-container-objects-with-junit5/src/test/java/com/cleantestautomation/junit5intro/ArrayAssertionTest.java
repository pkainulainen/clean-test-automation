package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class demonstrates how you can write assertions for
 * arrays with JUnit 5 assertion API.
 */
@DisplayName("Write assertions for arrays")
class ArrayAssertionTest {

    @Nested
    @DisplayName("When you write assertions for values")
    class WhenYouWriteAssertionsForValues {

        private final int EXPECTED_SIZE = 3;
        private final int[] ARRAY = new int[]{2, 5, 7};

        @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
            assertEquals(0, new int[]{}.length);

        }

        @Test
        @DisplayName("Shouldn't be empty")
        void shouldNotBeEmpty() {
            assertTrue(ARRAY.length > 0);
        }

        @Test
        @DisplayName("Should contain three values")
        void shouldContainThreeValues() {
            assertEquals(EXPECTED_SIZE, ARRAY.length);
        }

        @Test
        @DisplayName("Should contain only the expected elements in the given order")
        void shouldContainOnlyExpectedElementsInGivenOrder() {
            assertTrue(toIntegerList(ARRAY).equals(List.of(2, 5, 7)));
        }

        @Test
        @DisplayName("Should contain the expected elements in any order")
        void shouldContainExpectedElementInAnyOrder() {
            assertTrue(toIntegerList(ARRAY).containsAll(List.of(5, 7, 2)));
        }

        @Test
        @DisplayName("Should contain the given element")
        void shouldContainGivenElement() {
            assertTrue(toIntegerList(ARRAY).contains(5));
        }

        @Test
        @DisplayName("Shouldn't contain the given element")
        void shouldNotContainGivenElement() {
            assertFalse(toIntegerList(ARRAY).contains(99));
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
                    assertArrayEquals(EXPECTED, ACTUAL);
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
                    assertArrayEquals(EXPECTED, ACTUAL);
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
                @DisplayName("Should not contain the same integers")
                void shouldNotContainSameIntegers() {
                    assertFalse(toIntegerList(UNEXPECTED).equals(toIntegerList(ACTUAL)));
                }
            }

            @Nested
            @DisplayName("When arrays contain strings")
            class WhenArraysContainStrings {

                private final String[] ACTUAL = new String[] {"foo", "bar1"};
                private final String[] UNEXPECTED = new String[] {"foo", "bar"};

                @Test
                @DisplayName("Should not contain the same strings")
                void shouldNotContainSameStrings() {
                    assertFalse(Arrays.asList(UNEXPECTED).equals(Arrays.asList(ACTUAL)));
                }
            }
        }
    }

    /**
     * You have to implement a utility method because because your
     * array contain primitive types. If you array contains objects,
     * you can transform it into a list by using the {@link Arrays#asList(Object[])}
     * or the {@link List#of(Object[])} method.
     */
    private static List<Integer> toIntegerList(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());
    }
}