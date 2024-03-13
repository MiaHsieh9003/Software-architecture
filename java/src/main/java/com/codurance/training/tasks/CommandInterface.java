package com.codurance.training.tasks;

import java.util.List;
import java.util.Map;

public interface CommandInterface {
    public void execute(Map<String, List<Task>> tasks, String commandLine);    
} 