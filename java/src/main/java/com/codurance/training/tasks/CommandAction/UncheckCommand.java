package com.codurance.training.tasks.CommandAction;

import java.io.PrintWriter;

import com.codurance.training.tasks.Application.UncheckApp;
import com.codurance.training.tasks.Entity.Entity.ProjectList;

public class UncheckCommand implements CommandInterface{  
    @Override
    public void execute(ProjectList tasks, String commandLine, PrintWriter out){
//        String[] commandRest = commandLine.split(" ", 2);
//        String command = commandRest[1];
        UncheckApp uncheckApp = new UncheckApp(tasks, commandLine, out);
        uncheckApp.setDone(false);
    }

}
