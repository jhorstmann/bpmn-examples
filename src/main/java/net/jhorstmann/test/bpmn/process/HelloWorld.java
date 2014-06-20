package net.jhorstmann.test.bpmn.process;

import net.jhorstmann.test.bpmn.Context;
import net.jhorstmann.test.bpmn.flow.FlowScoped;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FlowScoped
public class HelloWorld implements JavaDelegate {

    @Autowired
    private Context context;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        context.setSalutation("Hello " + context.getName());
    }
}
