package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import main.entity.*;
import main.use_case.ErrorCommand;
import main.use_case.HelpCommand;
import main.use_case.ShowCommand;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";

    private final Map<ProjectName, List<Task>> tasks = new LinkedHashMap<>();
    private final BufferedReader in;
    private final PrintWriter out;

    private long lastId = 0;

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
                ShowCommand showCommand = new ShowCommand();
                showCommand.show();
                break;
            case "add":
                add(commandRest[1]);
                break;
            case "check":
                projectName = new ProjectName(commandRest[1]);
                check(projectName);
                break;
            case "uncheck":
                projectName = new ProjectName(commandRest[1]);
                uncheck(projectName);
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



    private void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        ProjectName projectName;
        if (subcommand.equals("project")) {
            projectName = new ProjectName(subcommandRest[1]);
            addProject(projectName);
        } else if (subcommand.equals("task")) {
            projectName = new ProjectName(subcommandRest[0]);
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectName, projectTask[1]);
        }
    }

    private void addProject(ProjectName name) {
        tasks.put(name, new ArrayList<Task>());
    }

    private void addTask(ProjectName project, String description) {
        List<Task> projectTasks = tasks.get(project);
        if (projectTasks == null) {
            out.printf("Could not find a project with the name \"%s\".", project);
            out.println();
            return;
        }
        projectTasks.add(new Task(nextId(), description, false));
    }

    private void check(ProjectName idString) {
        setDone(idString, true);
    }

    private void uncheck(ProjectName idString) {
        setDone(idString, false);
    }

    private void setDone(ProjectName idString, boolean done) {
        int id = Integer.parseInt(idString.getName());
        for (Map.Entry<ProjectName, List<Task>> project : tasks.entrySet()) {
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





    private long nextId() {
        return ++lastId;
    }
}
