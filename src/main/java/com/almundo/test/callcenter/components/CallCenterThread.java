package com.almundo.test.callcenter.components;

import com.almundo.test.callcenter.entities.Call;
import com.almundo.test.callcenter.entities.Employee;
import com.almundo.test.callcenter.services.CallService;
import com.almundo.test.callcenter.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("prototype")
public class CallCenterThread implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(CallCenterThread.class);

    private Call call;

    private Employee employee;

    @Autowired
    private CallService callService;

    @Autowired
    private EmployeeService employeeService;

    @Value("${call.min-duration}")
    private int minDuration;

    @Value("${call.max-duration}")
    private int maxDuration;

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();

        logger.info("Starting: The call " + this.call.getId() + " will be answering by " + this.employee.getName() + " (id: " + this.employee.getId() + ") on thread -- " + currentThread.getName() + " -- at " + new Date());

        startAnswering();
        sleep();
        finishCall();

        logger.info("Finishing: The call " + this.call.getId() + " was answering by " + this.employee.getName() + " (id: " + this.employee.getId() + ") on thread -- " + currentThread.getName() + " -- after " + (System.currentTimeMillis() - start) + "ms");
    }

    private void sleep() {
        try {
            int randomDuration = (int) (Math.random() * (maxDuration - minDuration)) + minDuration;

            Thread.sleep(randomDuration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void startAnswering() {
        this.call.setAnsweredDate(new Date());
        this.call.setEmployee(this.employee);

        this.employee.setBusy(true);
        employeeService.update(this.employee.getId(), this.employee);
    }

    private void finishCall() {
        this.call.setFinishedDate(new Date());
        callService.update(this.call.getId(), this.call);

        Employee employee = this.call.getEmployee();
        employee.setBusy(false);
        employeeService.update(employee.getId(), employee);
    }

    public Call getCall() {
        return call;
    }

    public void setCall(Call call) {
        this.call = call;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}