package com.almundo.test.callcenter.services;

import com.almundo.test.callcenter.entities.Call;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DispatcherServiceTests {

    @MockBean
    private DispatcherService dispatcherService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void dispatchOneNewCall() {
        // Call call = dispatcherService.dispatchNewCall();
        // assertNull(call.getFinishedDate());
        // assertNotNull(call.getAnsweredDate());
    }

    @Test
    public void dispatchTenNewCalls() {
        // int numberOfCalls = 10;
        // List<Call> calls = dispatcherService.dispatchNewCalls(numberOfCalls);
        // assertEquals(calls.size(), numberOfCalls);
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        // this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
        //         .andExpect(content().string(containsString("Hello World")));
    }

}
