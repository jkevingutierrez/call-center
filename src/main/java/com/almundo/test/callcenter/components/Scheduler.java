package com.almundo.test.callcenter.components;

import com.almundo.test.callcenter.services.DispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Autowired
    private DispatcherService dispatcherService;

    @Scheduled(fixedDelay = 10000)
    public void checkCalls() {
        System.out.println("checkCalls");
    }

}