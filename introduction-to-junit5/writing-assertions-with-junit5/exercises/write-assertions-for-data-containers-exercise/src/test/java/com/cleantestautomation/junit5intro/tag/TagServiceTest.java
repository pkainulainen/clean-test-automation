package com.cleantestautomation.junit5intro.tag;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("Tests for find operations of tags")
class TagServiceTest {

    private TagRepository repository;
    private TagService service;

    @BeforeEach
    void configureSystemUnderTest() {
        repository = mock(TagRepository.class);
        service = new TagService(repository);
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

            private final String TAG_ONE = "code";
            private final String TAG_TWO = "documentation";
            private final String TAG_UNKNOWN = "shouldNotBeFound";

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
