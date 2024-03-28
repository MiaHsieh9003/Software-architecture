package com.codurance.training.tasks.CommandAction;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import com.codurance.training.tasks.Controller.AddController;
import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.ProjectList;
import com.codurance.training.tasks.Entity.ProjectName;
import com.codurance.training.tasks.Entity.Task;

public class AddCommand implements CommandInterface{
    @Override
    public void execute(ProjectList projectList, String commandLine, PrintWriter out){
        AddController addController = new AddController();
        addController.add(commandLine, projectList, out);
    }

    public void addTask(ProjectName projectName, String description, ProjectList projectList, PrintWriter out) {
        Project findProject = projectList.findProject(projectName);
        if (findProject == null) {
            out.printf("Could not find a project with the name \"%s\".", projectName.getName());
            out.println();
            return;
        }
        findProject.addTask(findProject.nextId(), description, false);
    }
    public void addProject(ProjectName name, ProjectList projectList) {
        projectList.addOneProject(name,new ArrayList<Task>());
    }
}