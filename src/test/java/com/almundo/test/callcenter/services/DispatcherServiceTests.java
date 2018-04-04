package com.almundo.test.callcenter.services;

import com.almundo.test.callcenter.entities.Call;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DispatcherServiceTests {

    @Autowired
    private DispatcherService dispatcherService;

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

}
