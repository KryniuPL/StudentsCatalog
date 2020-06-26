package com.red.service;

import com.red.model.Student;
import com.red.repository.students.StudentsJsonRepositoryImpl;
import com.red.repository.students.StudentsRepository;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentsService {

    private final StudentsRepository studentsRepository = new StudentsJsonRepositoryImpl();
    private static Scanner scanner = new Scanner(System.in);


    public void createStudent(Student student) {
        Objects.requireNonNull(student.getId());

        System.out.println("Type student firstName: ");
        String firstName = scanner.next();

        if (checkIfStudentNameIsCorrect(firstName)) {
            student.setFirstName(firstName);
            studentsRepository.createStudent(student);

            System.out.println(student);

        } else System.out.println("First name contains invalid characters. Student was not created.");

    }

    // TODO: Exercise
    // 1. Create student
    // 2. Check if name is a correct string in separate method and invoke it in createStudent method

//    private void checkIfStudentNameIsCorrect(String name) {
//    }

    private boolean checkIfStudentNameIsCorrect(String firstName) {
        return Pattern.matches("[a-zA-Z]+", firstName);
    }
}
