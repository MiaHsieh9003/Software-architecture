package com.codurance.training.tasks.Controller;

import com.codurance.training.tasks.CommandAction.AddCommand;
import com.codurance.training.tasks.Entity.ProjectList;
import com.codurance.training.tasks.Entity.ProjectName;

import java.io.PrintWriter;
public class AddController {


    public void add(String commandLine, ProjectList projectList, PrintWriter out){
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        AddCommand addCommand = new AddCommand();
        ProjectName projectName;
        if (subcommand.equals("project")) {
            projectName = new ProjectName(subcommandRest[1]);
            addCommand.addProject(projectName, projectList);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            projectName = new ProjectName(projectTask[0]);
//            Project findProject = projectList.findProject(projectName);
            addCommand.addTask(projectName, projectTask[1], projectList, out);
        }
    }
}
