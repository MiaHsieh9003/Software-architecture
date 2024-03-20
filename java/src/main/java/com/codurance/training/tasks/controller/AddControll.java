package com.codurance.training.tasks.controller;

import com.codurance.training.tasks.entity.ProjectName;
import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.io.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddControll {
    private final Map<ProjectName, List<Task>> tasks;
    private long lastId = 0;

    public AddControll(Map<ProjectName, List<Task>> tasks){
        this.tasks = tasks;
    }
    public void checkAdd(String subcommand, String[] subcommandRest){
        ProjectName projectName;
        if (subcommand.equals("project")) {
            projectName = new ProjectName(subcommandRest[1]);
            addProject(projectName);
        } else if (subcommand.equals("task")) {
            projectName = new ProjectName(subcommandRest[0]);
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectName, projectTask[1]);
        }
    }

    private void addProject(ProjectName name) {
        tasks.put(name, new ArrayList<Task>());
    }

    private void addTask(ProjectName project, String description) {
        List<Task> projectTasks = tasks.get(project);
        if (projectTasks == null) {
            Output out = Output.getInstance();
            out.outputPrint("Could not find a project with the name \"%s\"." );
            out.outputPrintLn(project.getName());
            return;
        }
        projectTasks.add(new Task(nextId(), description, false));
    }
    private long nextId() {
        return ++lastId;
    }

}
