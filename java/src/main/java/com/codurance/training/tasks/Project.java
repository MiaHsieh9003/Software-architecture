package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Project implements NodeParent{

    private static final String QUIT = "quit";
    private final PrintWriter out;
    private final BufferedReader in;
    protected final Map<String, List<Task>> tasks = new LinkedHashMap<>();

    private long lastId = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new Project(in, out).run();
    }

    public Project(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    @Override
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

    @Override
    public void execute(String commandLine) {
        String[] commandRest = NodeParent.split(commandLine);
        checkInput(commandRest[0], commandRest[1]);
    }
    
    @Override
    public void checkInput(String type, String content){
        Orderby orderby = Orderby.valueOf(type);
        if(orderby == Orderby.show){
            show();
        }else if(orderby == Orderby.add){
            add(content);
        }else if(orderby == Orderby.check){
            check(content);
        }else if(orderby == Orderby.uncheck){
            uncheck(content);
        }else if(orderby == Orderby.help){
            help();
        }else{
            error(type);
        }
    }

    @Override
    public void add(String commandLine) {
        String[] subcommandRest = NodeParent.split(commandLine);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1]);
        }
    }
    
    @Override
    public void show() {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            out.println();
        }
    }
    
    @Override
    public void uncheck(String idString) {
        setDone(idString, false);
    }

    @Override
    public void check(String idString) {
        setDone(idString, true);
    }

    @Override
    public void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
    
    @Override
    public void help() {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }
    
    @Override
    public void error(String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }

    @Override
    public void addProject(String name) {
        tasks.put(name, new ArrayList<Task>());
    }

    private long nextId() {
        return ++lastId;
    }
}
