package com.codurance.training.tasks.CommandAction;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Application.UncheckApp;
import com.codurance.training.tasks.Entity.Task;

public class UncheckCommand implements CommandInterface{  
    @Override
    public void execute(Map<String, List<Task>> tasks, String commandLine, PrintWriter out){
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[1];
        UncheckApp uncheckApp = new UncheckApp(tasks, command, out);
        uncheckApp.setDone(false);
    }

}
