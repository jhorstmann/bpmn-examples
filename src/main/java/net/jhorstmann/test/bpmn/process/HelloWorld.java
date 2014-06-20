package net.jhorstmann.test.bpmn.process;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Object name = execution.getVariable("name");
        execution.setVariable("salutation", "Hello " + name);
    }
}
