package com.red.utils;

import com.red.model.MenuItem;
import com.red.model.Student;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUiUtils {

    private static Scanner scanner = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static final String GREETING_MESSAGE = "<---------WELCOME IN STUDENTS CATALOG--------->";
    private static final String QUERY_MESSAGE = "Select an option: ";
    private static final String ERROR_MESSAGE = "ERROR";
    private static final String OUT_OF_RANGE_MESSAGE = "You selected an option which is not available";
    private static final String STUDENT_FOUND_MESSAGE = "STUDENT FOUND";
    private static final String STUDENT_NOT_FOUND_MESSAGE = "STUDENT NOT FOUND";
    private static final String INVALID_CHARACTERS_MESSAGE = "First name contains invalid characters. Student was not created.";
    private static final String STUDENT_ID_MESSAGE = "Type student id: ";
    private static final String STUDENT_FIRST_NAME_MESSAGE = "Type student firstName: ";

    public static void showGreetingMessage() {
        System.out.println(GREETING_MESSAGE + "\n");
    }

    public static void showMenuItems(List<MenuItem> menuItemList) {
        menuItemList.forEach(menuItem -> {
            System.out.println(ANSI_GREEN + menuItem.getIndex() + ". " + menuItem.getName() + ANSI_RESET);
        });
    }

    public static void showListOfStudents (List<Student> studentsList){
        studentsList.forEach(student -> {
            var firstName = student.getFirstName();
            var secondName = student.getSecondName() == null ? "" : student.getSecondName();
            System.out.println("[" + student.getId() + "] " + firstName + " " + secondName);
        });
    }

    public static void showQueryMessage() {
        System.out.println(QUERY_MESSAGE);
    }

    public static void showErrorMessage() {
        System.out.println(ANSI_RED + ERROR_MESSAGE);
    }

    public static void showOutOfRangeMessage() {
        System.out.println(OUT_OF_RANGE_MESSAGE);
    }

    public static void showStudentFoundMessage() {
        System.out.println(ANSI_GREEN + STUDENT_FOUND_MESSAGE);
    }
    public static void showStudentNotFoundMessage() {
        System.out.println(ANSI_RED + STUDENT_NOT_FOUND_MESSAGE);
    }

    public static void showInvalidCharactersMessage() {
        System.out.println(INVALID_CHARACTERS_MESSAGE);
    }

    public static void showTypeStudentIdMessage() {
        System.out.println(STUDENT_ID_MESSAGE);
    }

    public static void showTypeStudentFirstNameMessage() {
        System.out.println(STUDENT_FIRST_NAME_MESSAGE);
    }

    public static void showStudentDeletedMessage(String studentFirstName) {
        System.out.println("Student " + studentFirstName + " was deleted");
    }

    public static int getUserInput(List<MenuItem> menuItems) {
        int userInput;

        try {
            userInput = scanner.nextInt();
        } catch (InputMismatchException e) {
            showErrorMessage();
            userInput = 100;
        }

        return userInput;
    }
}
