package com.cleantestautomation.junit5intro.tag;

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
     * Finds unique tag names from the database.
     *
     * @return  A stream of tag names. If no tag names is found from
     *          the database, this method returns an empty stream.
     */
    public Stream<String> findUniqueTagNames() {
        return repository.findUniqueTagNames();
    }
}
