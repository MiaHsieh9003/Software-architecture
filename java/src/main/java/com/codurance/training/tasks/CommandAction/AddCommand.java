package com.codurance.training.tasks.CommandAction;

import java.io.PrintWriter;
// import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Task;
import com.codurance.training.tasks.TaskList;

public class AddCommand implements CommandInterface{
    @Override
    public void execute(Map<String, List<Task>> tasks, String commandLine, PrintWriter out){
        Project project = new Project();
        List<Task> allTasks = project.getTasks();
        add();
    }

    public void add(String commandLine, PrintWriter out){
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1], out);
        }
    }

}