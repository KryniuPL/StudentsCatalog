package com.red.commands;

public class ExitProgramCommand extends BaseCommandProvider {

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public Command getCommandName() {
        return Command.EXIT_PROGRAM;
    }
}
