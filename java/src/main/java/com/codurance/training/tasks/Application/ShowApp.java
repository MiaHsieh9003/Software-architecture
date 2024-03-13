package com.codurance.training.tasks.Application;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Task;

public class ShowApp {
    private final Map<String, List<Task>> tasks ;
    private final PrintWriter out;

    public ShowApp(Map<String, List<Task>> tasks,PrintWriter out ){
        this.tasks = tasks;
        this.out = out;
    }

    public void  show(){
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            out.println();
        }
    }
}
