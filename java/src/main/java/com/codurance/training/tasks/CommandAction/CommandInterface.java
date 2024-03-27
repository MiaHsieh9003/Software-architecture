package com.codurance.training.tasks.CommandAction;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Entity.Task;

public interface CommandInterface {
    public void execute(Map<String, List<Task>> tasks, String commandLine, PrintWriter out);    
} 