package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;

/**
 * This class demonstrates how you can combine Hamcrest matchers.
 */
class CombiningHamcrestMatchersTest {

    private static final String NAME = "Jane Doe";

    @Nested
    @DisplayName("When all matchers must return true")
    class WhenAllMatchersMustReturnTrue {

        @Test
        @DisplayName("Name should start and end with the correct string #1")
        void nameShouldStartAndEndWithCorrectString1() {
            assertThat(NAME, both(startsWith("Jane")).and(endsWith("Doe")));
        }

        @Test
        @DisplayName("Name should start and end with the correct string #2")
        void nameShouldStartAndEndWithCorrectString2() {
            assertThat(NAME, allOf(startsWith("Jane"), endsWith("Doe")));
        }
    }

    @Nested
    @DisplayName("When at least one matcher must return true")
    class WhenAtLeastOneMatcherMustReturnTrue {

        @Test
        @DisplayName("Name should start with one of the provided strings #1")
        void nameShouldStartWithOneOfProvidedStrings1() {
            assertThat(NAME, either(startsWith("John")).or(startsWith("Jane")));
        }

        @Test
        @DisplayName("Name should start with one of the provided strings #2")
        void nameShouldStartWithOneOfProvidedStrings2() {
            assertThat(NAME, anyOf(startsWith("John"), startsWith("Jane")));
        }
    }

    @Nested
    @DisplayName("Nested combined matchers")
    class NestedCombinedMatchers {

        @Test
        @DisplayName("Name should be non-blank string with correct size that starts and ends with the correct string")
        void nameShouldBeNonBlankStringWithCorrectSizeThatStartsAndEndsWithCorrectString() {
            assertThat(NAME, allOf(
                    allOf(not(blankOrNullString()), hasLength(8)),
                    allOf(startsWith("Jane"), endsWith("Doe"))
            ));
        }

        @Test
        @DisplayName("Name should start and end with one of the provided options")
        void nameShouldStartAndEndWithOneOfProvidedOptions() {
            assertThat(NAME, anyOf(
                    allOf(startsWith("John"), endsWith("Smith")),
                    allOf(startsWith("Jane"), endsWith("Doe")))
            );
        }
    }
}
