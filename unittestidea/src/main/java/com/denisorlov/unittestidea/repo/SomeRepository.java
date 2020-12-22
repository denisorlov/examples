package com.denisorlov.unittestidea.repo;

import org.springframework.stereotype.Repository;

@Repository
public class SomeRepository {
    public Integer findOne(Integer id){
        return id;
    }
}
