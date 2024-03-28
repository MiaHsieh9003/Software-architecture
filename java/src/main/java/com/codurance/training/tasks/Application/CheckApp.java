
package com.codurance.training.tasks.Application;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.ProjectList;
import com.codurance.training.tasks.Entity.Task;

public class CheckApp {
    private final String idString;    
    private final ProjectList projectList ;
    private final PrintWriter out;

    public CheckApp(ProjectList projectList, String idString, PrintWriter out){
        this.idString = idString;
        this.projectList = projectList;
        this.out = out;
    }

    public void setDone(boolean done) {
        int id = Integer.parseInt(idString);
        List<Project> projects = projectList.getProjects();
        List<Task> tasksInProject;
        for (Project project : projects) {
            tasksInProject = project.getTasks();
            for (Task task : tasksInProject) {
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