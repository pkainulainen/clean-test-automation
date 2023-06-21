package com.cleantestautomation.junit5intro.tag;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Provides find operations for tags.
 */
public class TagService {

    private final TagRepository repository;

    public TagService(TagRepository repository) {
        this.repository = repository;
    }

    /**
     * Finds the number of times each tag has been used and groups the
     * results by tag name.
     *
     * @return A map that contains the tag usage statistics.
     */
    public Map<String, Integer> findCountByTagName() {
        return repository.findCountByTagName();
    }

    /**
     * Finds unique tag names from the database.
     *
     * @return  A stream of tag names. If no tag names is found from
     *          the database, this method returns an empty stream.
     */
    public Stream<String> findUniqueTagNames() {
        return repository.findUniqueTagNames();
    }
}
