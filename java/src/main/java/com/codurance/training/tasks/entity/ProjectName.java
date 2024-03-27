package com.codurance.training.tasks.Entity;

public final class ProjectName {
    private final String projectName;

    public ProjectName(String name){
        this.projectName = name;
    }

    public String getName(){
        return this.projectName;
    }
}
