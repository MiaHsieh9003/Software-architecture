package com.codurance.training.tasks.IO;

import com.codurance.training.tasks.CommandAction.*;
import com.codurance.training.tasks.Entity.ValueObject.ProjectID;
import com.codurance.training.tasks.Entity.Entity.ProjectList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public final class ProjectListMain implements Runnable {
    private static final String QUIT = "quit";
    private static final ProjectID DEFAULT_PROJECT_ID = ProjectID.of("001");

    private final ProjectList tasks = new ProjectList(DEFAULT_PROJECT_ID);
    private final BufferedReader in;
    private final PrintWriter out;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new ProjectListMain(in, out).run();
    }

    public ProjectListMain(BufferedReader reader, PrintWriter writer) {
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
//                System.out.println(command);
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
