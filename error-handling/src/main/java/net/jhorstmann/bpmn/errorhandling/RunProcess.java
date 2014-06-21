package net.jhorstmann.bpmn.errorhandling;

import net.jhorstmann.spring.flowscope.Flow;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunProcess {

    @Autowired
    private RuntimeService runtimeService;
    @Flow
    public String startProcess() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("error-handling");
        System.out.println("Started process instance " + processInstance.getId());
        return processInstance.getId();

    }
}
