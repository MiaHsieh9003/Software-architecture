
package com.codurance.training.tasks.Application;

import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

import com.codurance.training.tasks.Entity.Entity.Project;
import com.codurance.training.tasks.Entity.Entity.ProjectList;
import com.codurance.training.tasks.Entity.Entity.Task;
import com.codurance.training.tasks.Entity.ValueObject.TaskID;

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
        long id = Integer.parseInt(idString);
        List<Project> projects = projectList.getProjects();
        List<Task> tasksInProject;
        for (Project project : projects) {
            tasksInProject = project.getTasks();
            for (Task task : tasksInProject) {
                if (Objects.equals(task.getID(), TaskID.of(id))) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}