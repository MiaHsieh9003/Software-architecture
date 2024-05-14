package com.codurance.training.tasks.CommandAction;

import java.io.PrintWriter;
import java.util.ArrayList;

import com.codurance.training.tasks.Controller.AddController;
import com.codurance.training.tasks.Entity.Entity.Project;
import com.codurance.training.tasks.Entity.Entity.ProjectList;
import com.codurance.training.tasks.Entity.Entity.Task;
import com.codurance.training.tasks.Entity.ValueObject.ProjectName;
import com.codurance.training.tasks.Entity.ValueObject.TaskID;

public class AddCommand implements CommandInterface{
//    PrintWriter out = new PrintWriter(new PipedOutputStream(outStream), true);
    @Override
    public void execute(ProjectList projectList, String commandLine, PrintWriter out){
//        this.out = out;
        AddController addController = new AddController();
        addController.add(commandLine, projectList, out);
    }

}