package com.codurance.training.tasks.CommandAction;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Entity.ProjectList;
import com.codurance.training.tasks.Entity.Task;

public interface CommandInterface {
    public void execute(ProjectList tasks, String commandLine, PrintWriter out);
} 