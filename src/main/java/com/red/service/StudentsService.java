package com.red.service;

import com.red.model.Student;
import com.red.repository.students.StudentsJsonRepositoryImpl;
import com.red.repository.students.StudentsRepository;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentsService {

    private final StudentsRepository studentsRepository = new StudentsJsonRepositoryImpl();
    private static Scanner scanner = new Scanner(System.in);

    // TODO: Exercise 2
    // Limit size of the list to 10 objects
    public List<Student> findAllStudents() {
        return studentsRepository.findAll();
    }

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

    private boolean checkIfStudentNameIsCorrect(String firstName) {
        return Pattern.matches("[a-zA-Z]+", firstName);
    }
}
