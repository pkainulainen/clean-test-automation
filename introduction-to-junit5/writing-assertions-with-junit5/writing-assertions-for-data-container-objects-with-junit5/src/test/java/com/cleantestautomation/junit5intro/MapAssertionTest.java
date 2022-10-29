package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class demonstrates how you can write assertions for maps
 * with JUnit 5 assertion API.
 */
@DisplayName("Write assertions for maps")
class MapAssertionTest {

    private static final String INCORRECT_KEY = "incorrectKey";
    private static final String KEY = "key";
    private static final String VALUE = "value";

    private static final Map<String, String> MAP = Map.of(KEY, VALUE);

    @Nested
    @DisplayName("When you verify that the size of the map is correct")
    class WhenYouVerifyThatSizeOfMapIsCorrect {

        private final int EXPECTED_SIZE = 1;

        @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
           assertTrue(new HashMap<String, String>().isEmpty());
        }

        @Test
        @DisplayName("Shouldn't be empty")
        void shouldNotBeEmpty() {
            assertFalse(MAP.isEmpty());
        }

        @Test
        @DisplayName("Should contain one key-value pair")
        void shouldContainOneKeyValuePair() {
           assertEquals(EXPECTED_SIZE, MAP.size());
        }
    }

    @Nested
    @DisplayName("When you verify that the map contains the given key")
    class WhenYouVerifyThatMapContainsGivenKey {

        @Test
        @DisplayName("Should contain the given key")
        void shouldContainGivenKey() {
            assertTrue(MAP.containsKey(KEY));
        }
    }

    @Nested
    @DisplayName("When you verify that the map doesn't contain the given key")
    class WhenYouVerifyThatMapDoesNotContainGivenKey {

        @Test
        @DisplayName("Shouldn't contain the given key")
        void shouldNotContainGivenKey() {
            assertFalse(MAP.containsKey(INCORRECT_KEY));
        }
    }

    @Nested
    @DisplayName("When you verify that the map contains the given entry")
    class WhenYouVerifyThatMapContainsCorrectValue {

        @Test
        @DisplayName("Should contain the given entry")
        void shouldContainGivenEntry() {
            assertTrue(MAP.entrySet().contains(Map.entry(KEY, VALUE)));
        }
    }

    @Nested
    @DisplayName("When you verify that the map doesn't contain the given entry")
    class WhenYouVerifyThatMapDoesNotContainGivenEntry {

        @Test
        @DisplayName("Shouldn't contain the given entry")
        void shouldNotContainGivenEntry() {
            assertFalse(MAP.entrySet().contains(Map.entry(INCORRECT_KEY, VALUE)));
        }
    }

    @Nested
    @DisplayName("When you get a value from the map")
    class WhenYouGetValueFromMap {

        @Nested
        @DisplayName("When the value is found")
        class WhenValueIsFound {

            @Test
            @DisplayName("Should return the found value")
            void shouldReturnFoundValue() {
                final String returned = MAP.get(KEY);
                assertEquals(VALUE, returned);
            }
        }

        @Nested
        @DisplayName("When the value is not found")
        class WhenValueIsNotFound {

            @Test
            @DisplayName("Should return null")
            void shouldReturnNull() {
                final String returned = MAP.get(INCORRECT_KEY);
                assertNull(returned);
            }
        }
    }
}

