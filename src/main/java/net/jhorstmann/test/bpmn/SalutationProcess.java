package net.jhorstmann.test.bpmn;

import com.google.common.collect.ImmutableMap;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SalutationProcess {
    @Autowired
    private RuntimeService runtimeService;

    public String sayHello(String name) {
        ImmutableMap<String, Object> variables = ImmutableMap.<String, Object>of("name", name);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("helloWorld", variables);
        String processInstanceId = processInstance.getId();
        Map<String, Object> result = runtimeService.getVariables(processInstanceId);

        Execution execution = runtimeService.createExecutionQuery()
                .processInstanceId(processInstanceId)
                .activityId("receiveSalutation")
                .singleResult();

        runtimeService.signal(execution.getId());

        return String.valueOf(result.get("salutation"));
    }
}
