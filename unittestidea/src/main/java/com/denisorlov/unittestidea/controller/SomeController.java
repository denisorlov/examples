package com.denisorlov.unittestidea.controller;

import com.denisorlov.unittestidea.service.SomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SomeController {
    private final SomeService someService; // dependency injection

    static final String RESP_PREFIX = "Результат: ";

    static final String PATH_GET_TRIPLE = "/triple/{numberId}";

    @GetMapping(path = PATH_GET_TRIPLE) // mapping method to GET with url=path
    public ResponseEntity<String> triple(@PathVariable(name = "numberId") int numberId) {
        int res = someService.tripleMethod(numberId);   // dependency call
        String resp = RESP_PREFIX + res;                // own logic
        return ResponseEntity.ok().body(resp);
    }
}
