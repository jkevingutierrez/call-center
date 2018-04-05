package com.almundo.test.callcenter.components;

import com.almundo.test.callcenter.entities.Call;
import com.almundo.test.callcenter.services.CallService;
import com.almundo.test.callcenter.services.DispatcherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Scheduler {
    private static final Logger logger = LoggerFactory.getLogger(CallCenterThread.class);

    @Autowired
    private DispatcherService dispatcherService;

    @Autowired
    private CallService callService;

    @Scheduled(fixedDelayString = "${scheduler.check.delay}")
    public void checkUnansweredCalls() {
        logger.info("Checking unanswered calls");

        List<Call> unansweredCalls = callService.getAllUnaswered();

        for (Call call : unansweredCalls) {
            logger.info("Dispatching call " + call.getId());
            dispatcherService.dispatchCall(call);
        }
    }

}