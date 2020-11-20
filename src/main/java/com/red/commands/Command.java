package com.red.commands;

public enum Command {
    SHOW_ALL_STUDENTS("Show all students"),
    FIND_STUDENT_BY_ID("Find student by id");

    private String message;

    Command() {
    }

    Command(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
