package com.codurance.training.tasks.CommandAction;

import java.io.PipedOutputStream;
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
//    PrintWriter out = new PrintWriter(new PipedOutputStream(outStream), true);
    @Override
    public void execute(ProjectList projectList, String commandLine, PrintWriter out){
//        this.out = out;
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
        findProject.addTask(projectList.nextId(), description, false);
    }
    public void addProject(ProjectName name, ProjectList projectList) {
        projectList.addOneProject(name,new ArrayList<Task>());
//        Project project = projectList.findProject(name);
//        if(project != null){
//            for(Project project1: projectList.getProjects()){
//                System.out.println(project1.getProjectName().getName());
//
//            }
//        }
//        else{
//            System.out.println("add fail");
//        }
    }
}