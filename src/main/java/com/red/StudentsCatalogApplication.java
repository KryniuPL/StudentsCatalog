package com.red;

import com.red.model.Student;
import com.red.service.StudentsService;

import java.util.Scanner;
import java.util.UUID;

public class StudentsCatalogApplication {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentsService studentsService = new StudentsService();

    public void run() {
        Student student = new Student(
                UUID.randomUUID().toString()
        );
        System.out.println(student);
        studentsService.createStudent(student);
    }
}
