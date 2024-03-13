package com.codurance.training.tasks.CommandAction;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import com.codurance.training.tasks.CommandInterface;
import com.codurance.training.tasks.Task;

public class AddCommand implements CommandInterface{
    private PrintWriter out;
    private long lastId = 0;
    @Override
    public void execute(Map<String, List<Task>> tasks, String commandLine){
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            //addProject(subcommandRest[1]);
            tasks.put(subcommandRest[1], new ArrayList<Task>());
        } else if (subcommand.equals("task")) {
            // addTask(projectTask[0], projectTask[1]);
            String[] projectTask = subcommandRest[1].split(" ", 2);
            List<Task> projectTasks = tasks.get(projectTask[0]);
            if (projectTasks == null) {
                out.printf("Could not find a project with the name \"%s\".", projectTask[0]);
                out.println();
                return;
            }
            projectTasks.add(new Task(nextId(), projectTask[1], false));
        }
    }
    
    private long nextId() {
        return ++lastId;
    }
}