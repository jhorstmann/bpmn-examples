package net.jhorstmann.test.bpmn;

import com.google.common.collect.ImmutableMap;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bootstrap {
    @Autowired
    private RuntimeService runtimeService;

    @PostConstruct
    public void startProcess() {
        ImmutableMap<String, Object> variables = ImmutableMap.<String, Object>of("name", "World");
        runtimeService.startProcessInstanceByKey("helloWorld", variables);

    }
}
