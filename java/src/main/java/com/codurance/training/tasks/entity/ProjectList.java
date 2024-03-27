package com.codurance.training.tasks.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjectList {
    private final List<Project> projects;

    public ProjectList(){
        this.projects = new ArrayList<>();
    }

    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);  //表示projects不能隨意變更
    }
    public Project findProject(ProjectName projectName){
        for(Project project: projects){
            if (project.getProjectName().equals(projectName)) {
                return project;
            }
        }
        return null;
    }
    public void addProject(ProjectName name, ArrayList<Task> tasks) {
        Project project = new Project(name, tasks);
        projects.add(project);
    }
    public
}
