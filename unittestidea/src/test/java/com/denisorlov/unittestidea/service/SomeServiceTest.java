package com.denisorlov.unittestidea.service;

import com.denisorlov.unittestidea.repo.SomeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeServiceTest {
    @Mock
    private SomeRepository someRepository; // то, что мокируем

    @InjectMocks
    private SomeService someService; // куда внедряем то, что мокируем

    @Test
    void tripleMethod() {
        int numberId = 42;
        when(someRepository.findOne(eq(numberId))).then(AdditionalAnswers.returnsFirstArg());

        int res = someService.tripleMethod(numberId);

        assertEquals(numberId*3, res);
    }
}