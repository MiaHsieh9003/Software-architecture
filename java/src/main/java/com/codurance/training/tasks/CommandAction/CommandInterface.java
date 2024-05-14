package com.codurance.training.tasks.CommandAction;

import com.codurance.training.tasks.Entity.Entity.ProjectList;

import java.io.PrintWriter;

public interface CommandInterface {
    public void execute(ProjectList tasks, String commandLine, PrintWriter out);
} 