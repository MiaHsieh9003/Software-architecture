package com.codurance.training.tasks.use_case;

import com.codurance.training.tasks.entity.ProjectName;
import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.io.Output;

import java.util.List;
import java.util.Map;

public class CheckCommand {
    private final Map<ProjectName, List<Task>> tasks;
    public CheckCommand(Map<ProjectName, List<Task>> tasks){
        this.tasks = tasks;
    }
    public void check(ProjectName idString) {
        setDone(idString, true);
    }

    public void uncheck(ProjectName idString) {
        setDone(idString, false);
    }

    private void setDone(ProjectName idString, boolean done) {
        int id = Integer.parseInt(idString.getName());
        for (Map.Entry<ProjectName, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        Output out = Output.getInstance();
        out.outputPrint("Could not find a task with an ID of %d.");
        out.outputPrintLn(Integer.toString(id));
    }
}
