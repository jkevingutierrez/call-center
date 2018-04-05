package com.almundo.test.callcenter.services;

import com.almundo.test.callcenter.entities.Call;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DispatcherServiceTests {

    @Autowired
    private DispatcherService service;

    @Test
    public void should_dispatch_one_new_call() {
        //Call call = service.dispatchNewCall();
        //assertThat(call.getFinishedDate()).isNotNull();
        //assertThat(call.getAnsweredDate()).isNotNull();
    }

    @Test
    public void should_dispatch_ten_calls_in_parallel() {
        //int numberOfCalls = 10;
        //List<Call> calls = service.dispatchNewCalls(numberOfCalls);
        //assertThat(calls).hasSize(numberOfCalls);
    }
}
