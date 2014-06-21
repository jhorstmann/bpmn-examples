package net.jhorstmann.bpmn.errorhandling.tasks;

import net.jhorstmann.bpmn.errorhandling.GeneralProcessException;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("throwError")
public class ThrowErrorTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("throwing general exception");
        throw new GeneralProcessException();
    }


}
