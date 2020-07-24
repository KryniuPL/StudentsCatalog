package com.red;

import com.red.model.MenuItem;
import com.red.model.Student;
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


        while (true) {
            showMenuItems(menuItemList);
            showQueryMessage();
            int scannedInput = getUserInput(menuItemList);

            switch (scannedInput) {
                case 1:
                    studentsService.findAllStudents();
                    break;
                case 2:
                    studentsService.createStudent(new Student());
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("DEFUALY");
                    break;
            }
        }
    }
}
