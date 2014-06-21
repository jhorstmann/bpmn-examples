package net.jhorstmann.bpmn.errorhandling.tasks;

import net.jhorstmann.spring.flowscope.FlowScoped;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@FlowScoped
@Component("first")
public class FirstTask implements JavaDelegate{
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("first task");
    }
}
