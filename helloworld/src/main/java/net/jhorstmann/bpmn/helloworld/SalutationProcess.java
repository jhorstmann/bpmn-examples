package net.jhorstmann.bpmn.helloworld;

import net.jhorstmann.spring.flowscope.Flow;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalutationProcess {
    @Autowired
    private ObjectFactory<SalutationContext> contextFactory;
    @Autowired
    private RuntimeService runtimeService;

    @Flow
    public String sayHello(String name) {
        SalutationContext salutationContext = contextFactory.getObject();
        salutationContext.setName(name);
        runtimeService.startProcessInstanceByKey("helloWorld");
        return salutationContext.getSalutation();
    }
}
