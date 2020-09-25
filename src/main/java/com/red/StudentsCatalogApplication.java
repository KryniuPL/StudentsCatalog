package com.red;

import com.red.model.MenuItem;
import com.red.model.Student;
import com.red.service.StudentsService;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.red.utils.ConsoleUiUtils.getUserInput;
import static com.red.utils.ConsoleUiUtils.showGreetingMessage;
import static com.red.utils.ConsoleUiUtils.showListOfStudents;
import static com.red.utils.ConsoleUiUtils.showMenuItems;
import static com.red.utils.ConsoleUiUtils.showOutOfRangeMessage;
import static com.red.utils.ConsoleUiUtils.showQueryMessage;

public class StudentsCatalogApplication {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentsService studentsService = new StudentsService();

    private List<MenuItem> buildMenuItemLists(List<String> items) {
        return items.stream()
                .map(item -> {
                    var index = items.indexOf(item) + 1;
                    return new MenuItem(index, item);
                })
                .collect(Collectors.toList());
    }

    List<MenuItem> menuItemList = buildMenuItemLists(List.of(
            "Show all students",
            "Find by id",
            "Find by first letter of first name",
            "Create student",
            "Delete student",
            "Find student above age",
            "Exit"));

    //To Do: usuwanie studenta, findAndRemove

    public void run() {
        showGreetingMessage();

        while (true) {
            showMenuItems(menuItemList);
            showQueryMessage();
            int scannedInput = getUserInput(menuItemList);

            switch (scannedInput) {
                case 1:
                    showListOfStudents(studentsService.findAllStudents());
                    break;
                case 2:
                    studentsService.findStudentById();
                    break;
                case 3:
                    showListOfStudents(studentsService.findStudentsByFirstLetterOfFirstName());
                    break;
                case 4:
                    studentsService.createStudent(new Student());
                    break;
                case 5:
                    studentsService.deleteStudentByID();
                    break;
                case 6:
                    showListOfStudents(studentsService.findStudentsAboveAge());
                    break;
                case 7:
                    System.exit(0);
                default:
                    showOutOfRangeMessage();
                    continue;
            }
        }
    }
}
