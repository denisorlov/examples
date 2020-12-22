package com.denisorlov.unittestidea.repo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeRepositoryTest {
    // no dependency injection
    private final SomeRepository someRepository = new SomeRepository();

    @Test
    void findOne() {
        int id = 777;
        Integer fromDB = someRepository.findOne(id);
        assertEquals(id, fromDB);
    }
}