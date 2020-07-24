package com.red.utils;

import com.red.model.MenuItem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUiUtils {

    private static Scanner scanner = new Scanner(System.in);

    private static final String GREETING_MESSAGE = "<---------WELCOME IN STUDENTS CATALOG--------->";
    private static final String QUERY_MESSAGE = "Select an option: ";
    private static final String ERROR_MESSAGE = "ERROR";

    public static void showGreetingMessage() {
        System.out.println(GREETING_MESSAGE + "\n");
    }

    public static void showMenuItems(List<MenuItem> menuItemList) {
        menuItemList.forEach(menuItem -> {
            System.out.println(menuItem.getIndex() + ". " + menuItem.getName());
        });
    }

    public static void showQueryMessage() {
        System.out.println(QUERY_MESSAGE);
    }

    public static void showErrorMessage() {
        System.out.println(ERROR_MESSAGE);
    }

    public static int getUserInput() {

        int userInput = 0;

        try {
            userInput = scanner.nextInt();

        } catch (InputMismatchException e) {
            showErrorMessage();
            userInput = Integer.MAX_VALUE;
        }

        return userInput;
    }
}
