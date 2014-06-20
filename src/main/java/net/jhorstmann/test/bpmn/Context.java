package net.jhorstmann.test.bpmn;

import net.jhorstmann.test.bpmn.flow.FlowScoped;
import org.springframework.stereotype.Component;

@Component
@FlowScoped
public class Context {
    private String name;
    private String salutation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }
}
