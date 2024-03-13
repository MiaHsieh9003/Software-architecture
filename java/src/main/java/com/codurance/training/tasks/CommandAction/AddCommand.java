package com.codurance.training.tasks.CommandAction;

import java.io.PrintWriter;
// import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import com.codurance.training.tasks.Application.AddApp;

import com.codurance.training.tasks.CommandInterface;
import com.codurance.training.tasks.Task;

public class AddCommand implements CommandInterface{
    @Override
    public void execute(Map<String, List<Task>> tasks, String commandLine, PrintWriter out){
        AddApp addapp = new AddApp(tasks, commandLine, out);
        addapp.add();
    }

}