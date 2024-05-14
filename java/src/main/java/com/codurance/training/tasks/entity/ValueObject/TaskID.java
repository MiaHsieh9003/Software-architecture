package com.codurance.training.tasks.Entity.ValueObject;

public record TaskID(String value) implements ValueObject {  //records are not supported in -source 8
    public static TaskID of(long id){
        return new TaskID(String.valueOf(id));
    }
    public static TaskID of(String id){
        return new TaskID(id);
    }

    @Override
    public String toString() {
        return value;
    }
}
