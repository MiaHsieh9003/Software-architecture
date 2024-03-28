package com.codurance.training.tasks.CommandAction;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Application.CheckApp;
import com.codurance.training.tasks.Entity.ProjectList;
import com.codurance.training.tasks.Entity.Task;

public class CheckCommand implements CommandInterface{    
    // private PrintWriter out;

    @Override
    public void execute(ProjectList tasks, String commandLine, PrintWriter out){
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[1];
        CheckApp checkApp = new CheckApp(tasks, command, out) ;
        checkApp.setDone(true);
    }

}
