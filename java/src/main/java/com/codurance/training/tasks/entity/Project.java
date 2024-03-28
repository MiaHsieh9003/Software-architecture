package com.codurance.training.tasks.Entity;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Project {
    private final List<Task> tasks;
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
    public void addTask(long id, String description, boolean done){
        tasks.add(new Task(id, description, done));
    }
    public long nextId() {
        return ++this.lastId;
    }


}
