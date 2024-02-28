package com.codurance.training.tasks;


public interface NodeParent{

    void run();

    void execute(String commandLine);


    static String[] split(String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        return commandRest;
    }

    void checkInput(String type, String content);

    void show();
    
    default void add(String commandLine){}

    void uncheck(String idString);

    void check(String idString);

    void setDone(String idString, boolean done);

    void help();

    void error(String command);

    default void addProject(String name){
        System.out.println("Not a Project.");
    }

    default void addTask(String project, String description) {
        System.out.println("Not a Task.");
    }
}