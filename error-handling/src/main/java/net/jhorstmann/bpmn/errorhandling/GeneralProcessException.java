package net.jhorstmann.bpmn.errorhandling;

import org.camunda.bpm.engine.delegate.BpmnError;

public class GeneralProcessException extends BpmnError {
    public GeneralProcessException() {
        super("error-general");
    }
}
