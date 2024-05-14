package com.codurance.training.tasks.Entity.Entity;

import com.codurance.training.tasks.Entity.ValueObject.ProjectID;
import com.codurance.training.tasks.Entity.ValueObject.ProjectName;
import com.codurance.training.tasks.Entity.ValueObject.TaskID;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProjectList extends AggregateRoot<ProjectID> {
    private final ProjectID id;
    private final List<Project> projects;
    private long lastId = 0;

    public ProjectList(ProjectID id){
        this.id = id;
        this.projects = new ArrayList<>();
    }

    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);  //表示projects不能隨意變更
    }

    public void addProject(ProjectName name) {
        projects.add(new Project(name));
    }

    public void addTask(ProjectName projectName, String description) {
        //將遍歷的方法改成java內建的Optional來做
        Optional<Project> findProject = projects.stream().filter(p -> p.getProjectName().equals(projectName)).findFirst();
//        Project findProject = findProject(projectName);
//        if (findProject == null) {
//            out.printf("Could not find a project with the name \"%s\".", projectName.getName());
//            out.println();
//            return;
//        }
        findProject.ifPresent(p ->p.addTask(TaskID.of(nextId()), description, false));

    }
    public long nextId() {
        return ++this.lastId;
    }

    @Override
    public ProjectID getID() {
        return id;
    }
}
