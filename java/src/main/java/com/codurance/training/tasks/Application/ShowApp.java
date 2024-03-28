package com.codurance.training.tasks.Application;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.ProjectList;
import com.codurance.training.tasks.Entity.Task;

public class ShowApp {
    private final ProjectList projectList ;
    private final PrintWriter out;

    public ShowApp(ProjectList projectList, PrintWriter out ){
        this.projectList = projectList;
        this.out = out;
    }

    public void  show(){
        List<Project> allProject = projectList.getProjects();
        for (Project project : allProject) {
            out.println(project.getProjectName());
            for (Task task : project.getTasks()) {
                out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            out.println();
        }
    }
}
