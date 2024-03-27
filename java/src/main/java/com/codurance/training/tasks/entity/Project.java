package com.codurance.training.tasks.Entity;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Project {
    private final ProjectList tasks;
    private final ProjectName pName;
    private long lastId = 0;
    public Project(ProjectName pName, List<Task> tasks){
        this.pName = pName;
        this.tasks = tasks;
    }

    public ProjectName getProjectName() {
        return pName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    private long nextId() {
        return ++this.lastId;
    }

    private void addTask(ProjectName project, String description, PrintWriter out) {
        Project findProject = tasks.findProject(project);
        if (findProject == null) {
            out.printf("Could not find a project with the name \"%s\".", project);
            out.println();
            return;
        }
        findProject.addTask(new Task(nextId(), description, false));
    }
}
