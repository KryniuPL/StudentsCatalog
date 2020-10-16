package com.red.service;

import com.red.model.Student;
import com.red.repository.students.StudentsJsonRepositoryImpl;
import com.red.repository.students.StudentsRepository;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.red.utils.ConsoleUiUtils.*;

public class StudentsService {

    private final StudentsRepository studentsRepository = new StudentsJsonRepositoryImpl();
    private static Scanner scanner = new Scanner(System.in);

    public List<Student> findAllStudents() {
        return studentsRepository.findAll()
                .stream()
                .limit(100)
                .collect(Collectors.toList());
    }

    public List<Student> findStudentsByName(String name) {
        return studentsRepository.findAll()
                .stream()
                .filter(student -> student.getFirstName().equals(name))
                .collect(Collectors.toList());
    }

    public void findStudentById() {
        showTypeStudentIdMessage();
        Long id = scanner.nextLong();
        Student student = studentsRepository.findById(id);


        if (student != null) {
            showStudentFoundMessage();
            System.out.println(student);
        } else showStudentNotFoundMessage();
    }

    public List<Student> findStudentsByLimit(int limit) {
        return studentsRepository.findAll().parallelStream().limit(limit).collect(Collectors.toList());
    }

    public void createStudent(Student student) {
        showTypeStudentFirstNameMessage();
        String firstName = scanner.next();

        if (checkIfStudentNameIsCorrect(firstName)) {
            student.setFirstName(firstName);
            studentsRepository.createStudent(student);

            System.out.println(student);

        } else showInvalidCharactersMessage();

    }

    public void deleteStudentByID() {
        showTypeStudentIdMessage();
        Long id = scanner.nextLong();
        Student student = studentsRepository.findById(id);

        if (student != null) {
            showStudentFoundMessage();
            studentsRepository.removeStudent(student);
            showStudentDeletedMessage(student.getFirstName());

        } else showStudentNotFoundMessage();
    }

    private boolean checkIfStudentNameIsCorrect(String firstName) {
        return Pattern.matches("[a-zA-Z]+", firstName);
    }

}
