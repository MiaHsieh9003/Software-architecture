package com.codurance.training.tasks.CommandAction;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.CommandInterface;
import com.codurance.training.tasks.Task;

public class CheckCommand implements CommandInterface{    
    private PrintWriter out;

    @Override
    public void execute(Map<String, List<Task>> tasks, String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[1];
        setDone(tasks, command, true);
    }
    private void setDone(Map<String, List<Task>> tasks, String idString, boolean done) {
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
