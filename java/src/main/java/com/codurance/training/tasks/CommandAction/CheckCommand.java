package com.codurance.training.tasks.CommandAction;

import com.codurance.training.tasks.Application.CheckApp;
import com.codurance.training.tasks.Entity.Entity.ProjectList;

import java.io.PrintWriter;

public class CheckCommand implements CommandInterface{    

    @Override
    public void execute(ProjectList tasks, String commandLine, PrintWriter out){
        CheckApp checkApp = new CheckApp(tasks, commandLine, out) ;
        checkApp.setDone(true);
    }

}
