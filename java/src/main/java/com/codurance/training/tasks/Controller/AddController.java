package com.codurance.training.tasks.Controller;

import com.codurance.training.tasks.CommandAction.AddCommand;
import com.codurance.training.tasks.Entity.Entity.ProjectList;
import com.codurance.training.tasks.Entity.ValueObject.ProjectName;

import java.io.PrintWriter;
public class AddController {


    public void add(String commandLine, ProjectList projectList, PrintWriter out){
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        AddCommand addCommand = new AddCommand();
        ProjectName projectName;
        if (subcommand.equals("project")) {
            projectName = new ProjectName(subcommandRest[1]);
            projectList.addProject(projectName);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            projectName = new ProjectName(projectTask[0]);
            projectList.addTask(projectName, projectTask[1]);
        }
    }
}
