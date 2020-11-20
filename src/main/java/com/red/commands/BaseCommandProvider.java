package com.red.commands;

import com.red.service.StudentsService;

import java.util.Scanner;

public abstract class BaseCommandProvider implements CommandExecutor {
    protected final StudentsService studentsService = new StudentsService();
    protected final Scanner scanner = new Scanner(System.in);

}
