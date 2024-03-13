
package com.codurance.training.tasks.CommandAction;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.CommandInterface;
import com.codurance.training.tasks.Task;

public class ErrorCommand implements CommandInterface{
    // private PrintWriter out;
    @Override
        public void execute(Map<String, List<Task>> tasks, String commandLine, PrintWriter out){
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        out.printf("I don't know what the command \"%s\" is.", command);
            out.println();  
        }
}