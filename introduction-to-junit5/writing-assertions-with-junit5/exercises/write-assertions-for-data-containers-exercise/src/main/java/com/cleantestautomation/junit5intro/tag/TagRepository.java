package com.cleantestautomation.junit5intro.tag;

import java.util.stream.Stream;

interface TagRepository {

    /**
     * Finds unique tag names from the database.
     *
     * @return  A stream of tag names. If no tags is found from
     *          the database, this method returns an empty stream.
     */
    Stream<String> findUniqueTagNames();
}
