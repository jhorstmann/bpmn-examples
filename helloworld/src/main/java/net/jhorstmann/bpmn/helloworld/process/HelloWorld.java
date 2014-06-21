package net.jhorstmann.bpmn.helloworld.process;

import net.jhorstmann.bpmn.helloworld.SalutationContext;
import net.jhorstmann.spring.flowscope.FlowScoped;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FlowScoped
public class HelloWorld implements JavaDelegate {

    @Autowired
    private SalutationContext salutationContext;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        salutationContext.setSalutation("Hello " + salutationContext.getName());
    }
}
