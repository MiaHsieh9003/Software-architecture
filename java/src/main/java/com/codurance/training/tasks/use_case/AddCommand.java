package com.codurance.training.tasks.use_case;

import com.codurance.training.tasks.controller.AddControll;
import com.codurance.training.tasks.entity.ProjectName;
import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.io.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddCommand {
    private final Map<ProjectName, List<Task>> tasks;
    public AddCommand(Map<ProjectName, List<Task>> tasks){
        this.tasks = tasks;
    }
    public void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        AddControll addControll = new AddControll(tasks);
        addControll.checkAdd(subcommand,subcommandRest);
    }

}
