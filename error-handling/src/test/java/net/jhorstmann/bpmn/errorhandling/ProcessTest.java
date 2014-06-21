package net.jhorstmann.bpmn.errorhandling;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.history.HistoricActivityInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/applicationContext.xml")
public class ProcessTest {
    @Autowired
    private RunProcess process;

    @Autowired
    private HistoryService historyService;

    private List<HistoricActivityInstance> getFinishedActivities(String processInstanceId, String activityId) {
        return historyService.createHistoricActivityInstanceQuery()
                             .processInstanceId(processInstanceId)
                             .activityId(activityId)
                             .startedAfter(new Date(System.currentTimeMillis()-120*100L))
                             .list();
    }

    @Test
    public void shouldSkipAfterException() {
        // When the process is started
        String processInstanceId = process.startProcess();

        // Then
        List<HistoricActivityInstance> first = getFinishedActivities(processInstanceId, "first");
        assertEquals("first task should have been executed", 1, first.size());

        List<HistoricActivityInstance> executed = getFinishedActivities(processInstanceId, "throwError");
        assertEquals("exception should have been thrown", 1, executed.size());

        List<HistoricActivityInstance> skipped = getFinishedActivities(processInstanceId, "skipped");
        assertEquals("tasks after the exception should have been skipped", 0, skipped.size());

        List<HistoricActivityInstance> rollbackSuccessful = getFinishedActivities(processInstanceId, "rollbackSuccessful");
        assertEquals("event subprocess should have been executed", 1, rollbackSuccessful.size());

        List<HistoricActivityInstance> rollback = getFinishedActivities(processInstanceId, "rollback");
        assertEquals("rollback task should have been executed", 1, rollback.size());

    }

}
