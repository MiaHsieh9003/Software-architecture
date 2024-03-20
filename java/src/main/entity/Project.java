package main.entity;

import java.util.List;

public final class Project {
    // private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private final ProjectName projectName;
    private List<Task> taskList;

    public Project(ProjectName projectName, List<Task> taskList){
        this.projectName = projectName;
        this.taskList = taskList;
    }
}
