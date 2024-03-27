package com.codurance.training.tasks.CommandAction;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Entity.Task;

public class HelpCommand implements CommandInterface{
    private final PrintWriter out;
    public HelpCommand(PrintWriter out){
        this.out = out;
    }
    @Override
    public void execute(Map<String, List<Task>> tasks, String commandLine, PrintWriter out){
        this.out.println("Commands:");
        this.out.println("  show");
        this.out.println("  add project <project name>");
        this.out.println("  add task <project name> <task description>");
        this.out.println("  check <task ID>");
        this.out.println("  uncheck <task ID>");
        this.out.println();
    }
}
