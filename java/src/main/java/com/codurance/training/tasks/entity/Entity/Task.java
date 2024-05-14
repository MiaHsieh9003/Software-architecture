package com.codurance.training.tasks.Entity.Entity;

import com.codurance.training.tasks.Entity.ValueObject.TaskID;

public final class Task implements Entity<TaskID> {
    private final TaskID id;
    private final String description;
    private boolean done;

    public Task(TaskID id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public TaskID getID() {
        return id;
    }
}
