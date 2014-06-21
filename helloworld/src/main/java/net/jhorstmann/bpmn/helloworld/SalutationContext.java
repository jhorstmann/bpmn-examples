package net.jhorstmann.bpmn.helloworld;

import net.jhorstmann.spring.flowscope.FlowScoped;
import org.springframework.stereotype.Component;

@Component
@FlowScoped
public class SalutationContext {
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
