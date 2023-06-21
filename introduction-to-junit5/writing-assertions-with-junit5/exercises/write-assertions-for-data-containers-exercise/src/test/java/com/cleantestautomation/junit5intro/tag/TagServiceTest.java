package com.cleantestautomation.junit5intro.tag;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("Tests for find operations of tags")
class TagServiceTest {

    private static final String TAG_ONE = "code";
    private static final String TAG_TWO = "documentation";
    private static final String TAG_UNKNOWN = "shouldNotBeFound";

    private TagRepository repository;
    private TagService service;

    @BeforeEach
    void configureSystemUnderTest() {
        repository = mock(TagRepository.class);
        service = new TagService(repository);
    }

    @Nested
    @DisplayName("Find the number of times each tag has been used and group the results by tag name")
    class FindCountByTagName {

        @Nested
        @DisplayName("When no tags is found")
        class WhenNoTagsIsFound {

            @BeforeEach
            void countQueryReturnsEmptyMap() {
                given(repository.findCountByTagName()).willReturn(Map.of());
            }

            @Test
            @DisplayName("Should return an empty map")
            void shouldReturnEmptyMap() {
                var result = service.findCountByTagName();
                //TODO: Write the required assertion
            }
        }

        @Nested
        @DisplayName("When two tags are found")
        class WhenTwoTagsAreFound {

            private final Integer TAG_ONE_COUNT = 4;
            private final Integer TAG_TWO_COUNT = 1;

            @BeforeEach
            void countQueryReturnsMapWithTwoKeyValueMappings() {
                given(repository.findCountByTagName())
                        .willReturn(Map.of(
                                TAG_ONE, TAG_ONE_COUNT,
                                TAG_TWO, TAG_TWO_COUNT
                        ));
            }

            @Test
            @DisplayName("Should return a map that has two key-value mappings")
            void shouldReturnMapThatHasTwoKeyValueMappings() {
                var result = service.findCountByTagName();
                //TODO: Write the required assertion
            }

            @Test
            @DisplayName("Should return a map that contains the correct count for tag one")
            void shouldReturnMapThatContainsCorrectCountForTagOne() {
                var result = service.findCountByTagName();
                //TODO: Write the required assertion
            }

            @Test
            @DisplayName("Should return a map that contains the correct count for tag twp")
            void shouldReturnMapThatContainsCorrectCountForTagTwo() {
                var result = service.findCountByTagName();
                //TODO: Write the required assertion
            }

            @Test
            @DisplayName("Should return a map that doesn't contain count for unknown tag")
            void shouldReturnMapThatDoesNotContainCountForUnknownTag() {
                var result = service.findCountByTagName();
                //TODO: Write the required assertion
            }
        }
    }

    @Nested
    @DisplayName("Find unique tag names")
    class FindUniqueTagNames {

        @Nested
        @DisplayName("When no tags is found")
        class WhenNoTagsIsFound {

            @BeforeEach
            void tagNameQueryReturnsEmptyStream() {
                given(repository.findUniqueTagNames()).willReturn(Stream.empty());
            }

            @Test
            @DisplayName("Should return an empty stream")
            void shouldReturnEmptyStream() {
                var tagNames = service.findUniqueTagNames();
                //TODO: Write the required assertion
            }
        }

        @Nested
        @DisplayName("When two unique tags are found")
        class WhenTwoUniqueTagsAreFound {

            @BeforeEach
            void tagNameQueryReturnsTwoTags() {
                given(repository.findUniqueTagNames()).willReturn(Stream.of(TAG_ONE, TAG_TWO));
            }

            @Test
            @DisplayName("Should return a stream that has two tag names")
            void shouldReturnStreamThatHasTwoTagNames() {
                var tagNames = service.findUniqueTagNames();
                //TODO: Write the required assertion
            }

            @Test
            @DisplayName("Should return a stream that contains the expected tag names in the correct order")
            void shouldReturnStreamWhichContainsExpectedTagNamesInCorrectOrder() {
                var tagNames = service.findUniqueTagNames();
                //TODO: Write the required assertion
            }

            @Test
            @DisplayName("Should return a stream that contains the first tag name")
            void shouldReturnStreamThatContainsFirstTagName() {
                var tagNames = service.findUniqueTagNames();
                //TODO: Write the required assertion
            }

            @Test
            @DisplayName("Should return a stream that doesn't contain an unknown tag name")
            void shouldReturnStreamThatDoesNotContainUnknownTagName() {
                var tagNames = service.findUniqueTagNames();
                //TODO: Write the required assertion
            }
        }
    }
}
