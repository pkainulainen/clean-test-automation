package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how you can write assertions for maps
 * with AssertJ.
 */
@DisplayName("Write assertions for maps")
class MapAssertionTest {

    private static final String INCORRECT_KEY = "incorrectKey";
    private static final String KEY = "key";
    private static final String VALUE = "value";

    private Map<String, String> map;

    @BeforeEach
    void createAndInitializeMap() {
        map = new HashMap<>();
        map.put(KEY, VALUE);
    }

    @Nested
    @DisplayName("When you verify that the size of the map is correct")
    class WhenYouVerifyThatSizeOfMapIsCorrect {

        @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
            assertThat(new HashMap<String, String>()).isEmpty();
        }

        @Test
        @DisplayName("Shouldn't be empty")
        void shouldNotBeEmpty() {
            assertThat(map).isNotEmpty();
        }

        @Test
        @DisplayName("Should contain one key-value pair")
        void shouldContainOneKeyValuePair() {
            assertThat(map).hasSize(1);
        }
    }

    @Nested
    @DisplayName("When you verify that the map contains the given key")
    class WhenYouVerifyThatMapContainsGivenKey {

        @Test
        @DisplayName("Should contain the given key")
        void shouldContainGivenKey() {
            assertThat(map).containsKey(KEY);
        }
    }

    @Nested
    @DisplayName("When you verify that the map doesn't contain the given key")
    class WhenYouVerifyThatMapDoesNotContainGivenKey {

        @Test
        @DisplayName("Shouldn't contain the given key")
        void shouldNotContainGivenKey() {
            assertThat(map).doesNotContainKey(INCORRECT_KEY);
        }
    }

    @Nested
    @DisplayName("When you verify that the map contains the given entry")
    class WhenYouVerifyThatMapContainsCorrectValue {

        @Test
        @DisplayName("Should contain the given entry")
        void shouldContainGivenEntry() {
            assertThat(map).containsEntry(KEY, VALUE);
        }
    }

    @Nested
    @DisplayName("When you verify that the map doesn't contain the given entry")
    class WhenYouVerifyThatMapDoesNotContainGivenEntry {

        @Test
        @DisplayName("Shouldn't contain the given entry")
        void shouldContainGivenEntry() {
            assertThat(map).doesNotContainEntry(INCORRECT_KEY, VALUE);
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
                final String returned = map.get(KEY);
                assertThat(returned).isEqualTo(VALUE);
            }
        }

        @Nested
        @DisplayName("When the value is not found")
        class WhenValueIsNotFound {

            @Test
            @DisplayName("Should return null")
            void shouldReturnNull() {
                final String returned = map.get(INCORRECT_KEY);
                assertThat(returned).isNull();
            }
        }
    }
}

