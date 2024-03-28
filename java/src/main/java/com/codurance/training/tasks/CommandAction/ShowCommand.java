package com.codurance.training.tasks.CommandAction;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Application.ShowApp;
import com.codurance.training.tasks.Entity.ProjectList;
import com.codurance.training.tasks.Entity.Task;

public class ShowCommand implements CommandInterface{
    // private PrintWriter out;

    @Override
    public void execute(ProjectList tasks, String commandLine, PrintWriter out){
        ShowApp showApp = new ShowApp(tasks, out);
        showApp.show();
    }
}
