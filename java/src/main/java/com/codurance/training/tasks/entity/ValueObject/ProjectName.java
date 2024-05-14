package com.codurance.training.tasks.Entity.ValueObject;

public final class ProjectName implements ValueObject {
    private final String projectName;

    public ProjectName(String name){
        this.projectName = name;
    }

    public String getName(){
        return this.projectName;
    }
}
