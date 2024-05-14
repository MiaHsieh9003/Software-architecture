package com.codurance.training.tasks.Entity.ValueObject;

public record ProjectID(String value) implements ValueObject {
    public static ProjectID of(String id) {
        return new ProjectID(id);
    }
}
