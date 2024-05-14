
package com.codurance.training.tasks.CommandAction;

import com.codurance.training.tasks.Entity.Entity.ProjectList;

import java.io.PrintWriter;

public class ErrorCommand implements CommandInterface{
    // private PrintWriter out;
    @Override
        public void execute(ProjectList tasks, String commandLine, PrintWriter out){
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        out.printf("I don't know what the command \"%s\" is.", command);
            out.println();  
        }
}