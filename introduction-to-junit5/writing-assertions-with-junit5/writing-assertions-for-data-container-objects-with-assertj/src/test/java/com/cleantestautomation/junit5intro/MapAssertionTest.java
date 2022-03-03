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
        @DisplayName("Should contain one key-value pair")
        void shouldContainOneKeyValuePair() {
            assertThat(map).hasSize(1);
        }
    }

    @Nested
    @DisplayName("When you verify that the map contains the given key")
    class WhenYouVerifyThatMapContainsGivenKey {

        @Test
        @DisplayName("Should contain the correct key")
        void shouldContainCorrectKey() {
            assertThat(map).containsKey(KEY);
        }

        @Test
        @DisplayName("Should contain the correct key (with custom error message)")
        void shouldContainCorrectKeyWithCustomErrorMessage() {
            assertThat(map)
                    .overridingErrorMessage("The map doesn't contain the key: %s", KEY)
                    .containsKey(KEY);
        }
    }

    @Nested
    @DisplayName("When you verify that the map does not contain the given key")
    class WhenYouVerifyThatMapDoesNotContainGivenKey {

        @Test
        @DisplayName("Should not contain the incorrect key")
        void shouldNotContainIncorrectKey() {
            assertThat(map).doesNotContainKey(INCORRECT_KEY);
        }

        @Test
        @DisplayName("Should not contain the incorrect key (with custom error message)")
        void shouldNotContainIncorrectKeyWithCustomErrorMessage() {
            assertThat(map)
                    .overridingErrorMessage("The map contains the key: %s", INCORRECT_KEY)
                    .doesNotContainKey(INCORRECT_KEY);
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

        @Test
        @DisplayName("Should contain the given entry (with custom error message)")
        void shouldContainGivenEntryWithCustomErrorMessage() {
            assertThat(map)
                    .overridingErrorMessage(
                            "The map didn't contain the value: %s for the key: %s",
                            VALUE,
                            KEY
                    )
                    .containsEntry(KEY, VALUE);
        }
    }

    @Nested
    @DisplayName("When you verify that the map doesn't contain the given entry")
    class WhenYouVerifyThatMapDoesNotContainGivenEntry {

        @Test
        @DisplayName("Should not contain the given entry")
        void shouldContainGivenEntry() {
            assertThat(map).doesNotContainEntry(INCORRECT_KEY, VALUE);
        }

        @Test
        @DisplayName("Should contain the given entry (with custom error message)")
        void shouldContainGivenEntryWithCustomErrorMessage() {
            assertThat(map)
                    .overridingErrorMessage(
                            "Expected the map to not contain the value: %s for the key: %s but it contained it",
                            VALUE,
                            INCORRECT_KEY
                    )
                    .doesNotContainEntry(INCORRECT_KEY, VALUE);
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

            @Test
            @DisplayName("Should return the found value (with custom error message)")
            void shouldReturnFoundValueWithCustomErrorMessage() {
                final String returned = map.get(KEY);
                assertThat(returned)
                        .overridingErrorMessage(
                                "Expected the map to return: %s by using the key: %s but it returned: %s",
                                VALUE,
                                KEY,
                                returned
                        )
                        .isEqualTo(VALUE);
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

            @Test
            @DisplayName("Should return null (with custom error message)")
            void shouldReturnNullWithCustomErrorMessage() {
                final String returned = map.get(INCORRECT_KEY);
                assertThat(returned)
                        .overridingErrorMessage(
                                "Expected the map to return null for the key: %s but it returned: %s",
                                KEY,
                                returned
                        )
                        .isNull();
            }
        }
    }
}

