
package com.codurance.training.tasks.Application;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Task;

public class CheckApp {
    private final String idString;    
    private final Map<String, List<Task>> tasks ;
    private final PrintWriter out;

    public CheckApp(Map<String, List<Task>> tasks, String idString, PrintWriter out){
        this.idString = idString;
        this.tasks = tasks;
        this.out = out;
    }

    public void setDone(boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}