package ru.stqa.pft.rest;

import org.apache.http.client.fluent.Executor;
import org.omg.CORBA.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static com.sun.javafx.runtime.async.BackgroundExecutor.getExecutor;
import static org.apache.http.client.fluent.Request.Get;
import static org.testng.Assert.assertEquals;

public class RestTests {

    @Test
    public void testCreateIssue() throws IOException {
    Set<Issue> oldIssues = getIssues();
    Issue newIssue = new Issue();
    int issueId = createIssue(newIssue);
    Set<Issue> newIssues = getIssues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
    }


    private Set<Issue> getIssues() throws IOException {
        String json = getExecutor().execute(org.apache.http.client.fluent.Request.Get("http://bugify.stqa.ru/api/issues.json"))
                .returnContent().asString();
        return null;
    }

    private int createIssue(Issue newIssue) {
        return 0;
    }

    private Executor getExecutor(){
    return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
    }

}
