package com.red.utils;

import com.red.model.MenuItem;
import com.red.model.Student;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUiUtils {

    private static Scanner scanner = new Scanner(System.in);

    private static final String GREETING_MESSAGE = "<---------WELCOME IN STUDENTS CATALOG--------->";
    private static final String QUERY_MESSAGE = "Select an option: ";
    private static final String ERROR_MESSAGE = "ERROR";
    private static final String OUT_OF_RANGE_MESSAGE = "You selected an option which is not available";

    public static void showGreetingMessage() {
        System.out.println(GREETING_MESSAGE + "\n");
    }

    public static void showMenuItems(List<MenuItem> menuItemList) {
        menuItemList.forEach(menuItem -> {
            System.out.println(menuItem.getIndex() + ". " + menuItem.getName());
        });
    }

    public static void showListOfStudents (List<Student> studentsList){
        System.out.println(studentsList);
    }


    public static void showQueryMessage() {
        System.out.println(QUERY_MESSAGE);
    }

    public static void showErrorMessage() {
        System.out.println(ERROR_MESSAGE);
    }

    public static void showOutOfRangeMessage() {
        System.out.println(OUT_OF_RANGE_MESSAGE);
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
