package com.codurance.training.tasks;

import com.codurance.training.tasks.CommandAction.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";

    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private final BufferedReader in;
    private final PrintWriter out;

    // private long lastId = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in, out).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                // out.print("exception");
                // out.flush();
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
        if(commandRest.length > 0 && commandRest.length < 2){
            CommandInterface commandInterface = new ErrorCommand();
            commandInterface.execute(tasks, commandRest[0], out);
        }else{
            checkInput(commandRest[0], commandRest[1]);
        }        
    }

    public void checkInput(String type, String content){
        Orderby orderby = Orderby.valueOf(type);
        CommandInterface commandInterface;
         if(orderby == Orderby.show){
             commandInterface = new ShowCommand();
             commandInterface.execute(tasks, "", out);
         }else if(orderby == Orderby.add){
             commandInterface = new AddCommand();
             commandInterface.execute(tasks, content, out);
         }else if(orderby == Orderby.check){
             commandInterface = new CheckCommand();
             commandInterface.execute(tasks, content, out);
         }else if(orderby == Orderby.uncheck){
             commandInterface = new UncheckCommand();
             commandInterface.execute(tasks, content, out);
         }else
        if(orderby == Orderby.help){
            commandInterface = new HelpCommand(out);
            commandInterface.execute(tasks, "", out);
        }else{
            commandInterface = new ErrorCommand();
            commandInterface.execute(tasks, type, out);
        }
    }

    // private void show() {
    //     for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
    //         out.println(project.getKey());
    //         for (Task task : project.getValue()) {
    //             out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
    //         }
    //         out.println();
    //     }
    // }

    // private void add(String commandLine) {
    //     String[] subcommandRest = commandLine.split(" ", 2);
    //     String subcommand = subcommandRest[0];
    //     if (subcommand.equals("project")) {
    //         addProject(subcommandRest[1]);
    //     } else if (subcommand.equals("task")) {
    //         String[] projectTask = subcommandRest[1].split(" ", 2);
    //         addTask(projectTask[0], projectTask[1]);
    //     }
    // }

    // private void addProject(String name) {
    //     tasks.put(name, new ArrayList<Task>());
    // }

    // private void addTask(String project, String description) {
    //     List<Task> projectTasks = tasks.get(project);
    //     if (projectTasks == null) {
    //         out.printf("Could not find a project with the name \"%s\".", project);
    //         out.println();
    //         return;
    //     }
    //     projectTasks.add(new Task(nextId(), description, false));
    // }

    // private void check(String idString) {
    //     setDone(idString, true);
    // }

    // private void uncheck(String idString) {
    //     setDone(idString, false);
    // }

    // private void setDone(String idString, boolean done) {
    //     int id = Integer.parseInt(idString);
    //     for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
    //         for (Task task : project.getValue()) {
    //             if (task.getId() == id) {
    //                 task.setDone(done);
    //                 return;
    //             }
    //         }
    //     }
    //     out.printf("Could not find a task with an ID of %d.", id);
    //     out.println();
    // }

    // private void help() {
    //     out.println("Commands:");
    //     out.println("  show");
    //     out.println("  add project <project name>");
    //     out.println("  add task <project name> <task description>");
    //     out.println("  check <task ID>");
    //     out.println("  uncheck <task ID>");
    //     out.println();
    // }

    // private void error(String command) {
    //     out.printf("I don't know what the command \"%s\" is.", command);
    //     out.println();
    // }

    // private long nextId() {
    //     return ++lastId;
    // }
}
