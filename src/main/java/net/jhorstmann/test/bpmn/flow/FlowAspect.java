package net.jhorstmann.test.bpmn.flow;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
class FlowAspect {
    @Autowired
    private FlowScopeImpl flowScope;

    @Around("@annotation(net.jhorstmann.test.bpmn.flow.Flow)")
    public Object wrapInFlowScope(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        try {
            flowScope.begin();
            return proceedingJoinPoint.proceed();
        } finally {
            flowScope.end();

        }
    }
}
