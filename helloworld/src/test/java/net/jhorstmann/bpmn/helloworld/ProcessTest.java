package net.jhorstmann.bpmn.helloworld;

import net.jhorstmann.bpmn.helloworld.SalutationProcess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/applicationContext.xml")
public class ProcessTest {
    @Autowired
    private SalutationProcess salutationProcess;

    @Test
    public void shouldSayHello() {
        assertEquals("Hello World", salutationProcess.sayHello("World"));

    }

}
