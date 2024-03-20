package com.codurance.training.tasks;

public enum Orderby {
    show(0),
    add(1),
    check(2),
    uncheck(3),
    help(4);

    private final int value;
    Orderby(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}