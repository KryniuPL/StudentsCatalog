package com.red.utils;

import com.red.model.MenuItem;
import java.util.List;

public class ConsoleUiUtils {

    private static final String GREETING_MESSAGE = "<---------WELCOME IN STUDENTS CATALOG--------->";

    public static void showGreetingMessage() {
        System.out.println(GREETING_MESSAGE + "\n");
    }

    public static void showMenuItems(List<MenuItem> menuItemList) {
        menuItemList.forEach(menuItem -> {
            System.out.println(menuItem.getIndex() + ". " + menuItem.getName());
        });
    }

    public static void showQueryMessage() {
        System.out.println();
    }
}
