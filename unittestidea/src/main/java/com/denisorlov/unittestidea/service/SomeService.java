package com.denisorlov.unittestidea.service;

import com.denisorlov.unittestidea.repo.SomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SomeService {
    private final SomeRepository someRepository; // dependency injection

    public int tripleMethod(int numberId) {
        Integer fromDB = someRepository.findOne(numberId);  // dependency call
        int res = fromDB * 3;                               // own logic
        return res;
    }
}
