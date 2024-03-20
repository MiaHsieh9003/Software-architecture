package com.codurance.training.tasks;

import com.codurance.training.tasks.entity.*;
import com.codurance.training.tasks.io.Output;
import com.codurance.training.tasks.use_case.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";

    private final Map<ProjectName, List<Task>> tasks = new LinkedHashMap<>();
    private final BufferedReader in;
//    private final PrintWriter out;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in).run();
    }

    public TaskList(BufferedReader reader) {
        this.in = reader;
//        this.out = writer;
    }

    public void run() {
        while (true) {
            Output out = Output.getInstance();
            out.outputPrint("> ");
            out.outputflush();
            String command;
            try {
                command = in.readLine();
                out.outputPrint(command);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        ProjectName projectName;
        switch (command) {
            case "show":
                ShowCommand showCommand = new ShowCommand(tasks);
                showCommand.show();
                break;
            case "add":
                AddCommand addCommand = new AddCommand(tasks);
                addCommand.add(commandRest[1]);
                break;
            case "check":
                projectName = new ProjectName(commandRest[1]);
                CheckCommand checkCommand = new CheckCommand(tasks);
                checkCommand.check(projectName);
                break;
            case "uncheck":
                projectName = new ProjectName(commandRest[1]);
                CheckCommand checkCommand2 = new CheckCommand(tasks);
                checkCommand2.uncheck(projectName);
                break;
            case "help":
                HelpCommand helpCommand = new HelpCommand();
                helpCommand.help();
                break;
            default:
                ErrorCommand errorCommand = new ErrorCommand();
                errorCommand.error(command);
                break;
        }
    }
}
