package net.jhorstmann.test.bpmn.flow;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkState;

@Component
class FlowScopeImpl implements Scope {
    private final ThreadLocal<Map<String, Object>> threadScope = new ThreadLocal<Map<String, Object>>();

    void begin() {
        Map<String, Object> scope = threadScope.get();
        checkState(scope == null, "Flow scope is not reentrant!");
        scope = new HashMap<>();
        threadScope.set(scope);
    }

    void end() {
        Map<String, Object> scope = threadScope.get();
        checkState(scope != null, "Flow scope is not active!");
        threadScope.remove();
    }

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> scope = threadScope.get();
        Object object = scope.get(name);
        if (object == null) {
            object = objectFactory.getObject();
            scope.put(name, object);
        }
        return object;
    }

    @Override
    public Object remove(String name) {
        Map<String, Object> scope =  threadScope.get();
        return scope.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
