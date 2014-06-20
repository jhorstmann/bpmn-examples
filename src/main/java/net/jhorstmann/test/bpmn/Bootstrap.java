package net.jhorstmann.test.bpmn;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap {
    @Autowired
    private RuntimeService runtimeService;


}
