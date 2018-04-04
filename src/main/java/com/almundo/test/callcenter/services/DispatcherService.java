package com.almundo.test.callcenter.services;

import com.almundo.test.callcenter.components.CallCenterThread;
import com.almundo.test.callcenter.entities.Call;
import com.almundo.test.callcenter.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class DispatcherService {
    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CallService callService;

    @Autowired
    private EmployeeService employeeService;

    public List<Call> dispatchNewCalls(int numberOfCalls) {
        List<Call> calls = new LinkedList<>();

        for (int i = 0; i < numberOfCalls; i++) {
            Call call = dispatchNewCall();
            if (call != null) {
                calls.add(call);
            }
        }

        return calls;
    }

    public Call dispatchNewCall() {
        Call call = new Call();
        call = callService.save(call);

        return dispatchCall(call);
    }

    public Call dispatchCall(Call call) {
        List<Employee> employees = employeeService.getAllThatCanAttendACall();

        if (employees.isEmpty()) {
            return null;
        }

        call.setAnsweredDate(new Date());
        call.setEmployee(employees.get(0));

        call = callService.update(call.getId(), call);

        if (call != null) {
            Employee employee = call.getEmployee();
            employee.setBusy(true);
            employeeService.update(employee.getId(), employee);

            CallCenterThread thread = applicationContext.getBean(CallCenterThread.class);
            thread.setCall(call);
            taskExecutor.execute(thread);
            // ThreadPoolTaskExecutor test = (ThreadPoolTaskExecutor) taskExecutor;
            // System.out.println("ACTIVECOUNT: " + test.getActiveCount());
            // System.out.println("POOLSIZE: " + test.getPoolSize());
        }
        return call;
    }
}