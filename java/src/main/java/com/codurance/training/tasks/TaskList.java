package com.codurance.training.tasks;

import com.codurance.training.tasks.CommandAction.*;
import com.codurance.training.tasks.Entity.ProjectList;
import com.codurance.training.tasks.Entity.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";

    private final ProjectList tasks = new ProjectList();
    private final BufferedReader in;
    private final PrintWriter out;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in, out).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    public ProjectList getTasks(){
        return tasks;
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }


    public void execute(String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        CommandInterface commandInterface;
        out.println("in checkInput");
        switch (commandRest[0]) {
            case "show":
                commandInterface = new ShowCommand();
                commandInterface.execute(tasks, "", out);
                break;
            case "add":
                commandInterface = new AddCommand();
                commandInterface.execute(tasks, commandRest[1], out);
                break;
            case "check":
                commandInterface = new CheckCommand();
                commandInterface.execute(tasks, commandRest[1], out);
                break;
            case "uncheck":
                commandInterface = new UncheckCommand();
                commandInterface.execute(tasks, commandRest[1], out);
                break;
            case "help":
                commandInterface = new HelpCommand(out);
                commandInterface.execute(tasks, "", out);
                break;
            default:
                commandInterface = new ErrorCommand();
                commandInterface.execute(tasks, commandRest[0], out);
                break;
        }
    }

}
