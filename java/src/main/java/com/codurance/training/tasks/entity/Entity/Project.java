package com.codurance.training.tasks.Entity.Entity;

import com.codurance.training.tasks.Entity.ValueObject.ProjectName;
import com.codurance.training.tasks.Entity.ValueObject.TaskID;

import java.util.ArrayList;
import java.util.List;

public class Project implements Entity<ProjectName> {
    private final List<Task> tasks;
    private final ProjectName pName;
    public Project(ProjectName pName){
        this.pName = pName;
        this.tasks = new ArrayList<>();
    }

    public ProjectName getProjectName() {
        return pName;
    }

    public List<Task> getTasks() {
        return tasks;
    }
    public void addTask(TaskID id, String description, boolean done){
        tasks.add(new Task(id, description, done));
    }

    @Override
    public ProjectName getID() {
        return pName;
    }
}
