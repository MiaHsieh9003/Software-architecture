package com.codurance.training.tasks.Application;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.ProjectList;
import com.codurance.training.tasks.Entity.Task;

import java.io.PrintWriter;
import java.util.List;

public class UncheckApp {
    private final String idString;    
    private final ProjectList projectList ;
    private final PrintWriter out;

    public UncheckApp(ProjectList projectList, String idString, PrintWriter out){
        this.idString = idString;
        this.projectList = projectList;
        this.out = out;
    }

    public void setDone( boolean done) {
        int id = Integer.parseInt(idString);
        List<Project> allProject = projectList.getProjects();
        for (Project project : allProject) {
            for (Task task : project.getTasks()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}
