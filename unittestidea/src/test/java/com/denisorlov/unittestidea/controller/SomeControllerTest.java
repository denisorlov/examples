package com.denisorlov.unittestidea.controller;

import com.denisorlov.unittestidea.service.SomeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SomeController.class)
class SomeControllerTest {
    @MockBean
    private SomeService someService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void triple() throws Exception {
        int numberId = 42; // input path variable
        int serviceRes = numberId*3; // result from mock someService
        // prepare someService.tripleMethod behavior
        when(someService.tripleMethod(eq(numberId))).thenReturn(serviceRes);

        //// mockMvc.perform
        MockHttpServletRequestBuilder requestConfig = MockMvcRequestBuilders.get(SomeController.PATH_GET_TRIPLE, numberId);

        MvcResult mvcResult = mockMvc.perform(requestConfig)
            .andExpect(status().isOk())
            //.andDo(MockMvcResultHandlers.print())
            .andReturn()
        ;//// mockMvc.perform

        // check of calling
        Mockito.verify(someService, Mockito.atLeastOnce()).tripleMethod(eq(numberId));
        // check of result
        assertEquals(SomeController.RESP_PREFIX+serviceRes, mvcResult.getResponse().getContentAsString());
    }
}