package com.codurance.training.tasks.use_case;

import com.codurance.training.tasks.entity.*;
import com.codurance.training.tasks.io.Output;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;


public class ShowCommand {
    private final Map<ProjectName, List<Task>> tasks;
//    private final Map<ProjectName, List<Task>> tasks = new LinkedHashMap<>();
    public ShowCommand(Map<ProjectName, List<Task>> tasks){
        this.tasks = tasks;
    }
    public void show() {
        Output out = Output.getInstance();

        for (Map.Entry<ProjectName, List<Task>> project : tasks.entrySet()) {
            out.outputPrintLn(project.getKey().getName());
            for (Task task : project.getValue()) {
                String msg = "    [%c] %d: %s%n" + Character.toString(task.isDone() ? 'x' : ' ') + Long.toString(task.getId()) + task.getDescription();
                out.outputPrint(msg);
            }
            out.outputPrintLn();
        }
    }
}