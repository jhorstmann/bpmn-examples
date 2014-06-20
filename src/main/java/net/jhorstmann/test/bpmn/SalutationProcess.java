package net.jhorstmann.test.bpmn;

import net.jhorstmann.test.bpmn.flow.Flow;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalutationProcess {
    @Autowired
    private ObjectFactory<Context> contextFactory;
    @Autowired
    private RuntimeService runtimeService;

    @Flow
    public String sayHello(String name) {
        Context context = contextFactory.getObject();
        context.setName(name);
        runtimeService.startProcessInstanceByKey("helloWorld");
        return context.getSalutation();
    }
}
