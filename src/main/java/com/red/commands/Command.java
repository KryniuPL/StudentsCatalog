package com.red.commands;

public enum Command {
    SHOW_ALL_STUDENTS("Show all students", new ShowAllStudentsCommand()),
    FIND_STUDENT_BY_ID("Find student by id", new FindStudentByIdCommand()),
    EXIT_PROGRAM("Exit system", new ExitProgramCommand());

    private final String message;
    private BaseCommandProvider commandProvider;

    Command(String message) {
        this.message = message;
    }

    Command(String message, BaseCommandProvider commandProvider) {
        this.message = message;
        this.commandProvider = commandProvider;
    }

    public String getMessage() {
        return message;
    }

    public BaseCommandProvider getCommandProvider() {
        return commandProvider;
    }
}
