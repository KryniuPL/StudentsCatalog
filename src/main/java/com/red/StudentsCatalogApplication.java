package com.red;

import com.red.model.MenuItem;
import com.red.service.StudentsService;
import java.util.List;
import java.util.Scanner;

import static com.red.utils.ConsoleUiUtils.*;

public class StudentsCatalogApplication {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentsService studentsService = new StudentsService();

    List<MenuItem> menuItemList = List.of(
            new MenuItem(1, "Show all students"),
            new MenuItem(2, "Create student")
    );

    public void run() {
        showGreetingMessage();
        showMenuItems(menuItemList);
        showQueryMessage();
        getUserInput();


//        while (true) {
//
//            // TODO: get user input from console
//            int scannedInput = 1;
//
//            switch (scannedInput) {
//                case 1:
//                    studentsService.findAllStudents();
//                    break;
//                default: break;
//            }
//        }
    }
}
