package com.cleantestautomation.junit5intro.tag;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Provides finder operations for tags.
 */
interface TagRepository {

    /**
     * Finds the number of times each tag has been used and groups the
     * results by tag name.
     *
     * @return A map that contains the tag usage statistics.
     */
    Map<String, Integer> findCountByTagName();

    /**
     * Finds unique tag names from the database.
     *
     * @return  A stream of tag names. If no tags is found from
     *          the database, this method returns an empty stream.
     */
    Stream<String> findUniqueTagNames();
}
