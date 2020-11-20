package com.red.service;

import com.red.model.Student;
import com.red.repository.students.StudentsJsonRepositoryImpl;
import com.red.repository.students.StudentsRepository;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    public Student findStudentById(Long id) {
        return studentsRepository.findById(id);
    }

    public List<Student> findStudentsByLimit(int limit) {
        return studentsRepository.findAll().parallelStream().limit(limit).collect(Collectors.toList());
    }

    public void createStudent(Student student) {
        System.out.println("Type student firstName: ");
        String firstName = scanner.next();

        if (checkIfStudentNameIsCorrect(firstName)) {
            student.setFirstName(firstName);
            studentsRepository.createStudent(student);

            System.out.println(student);

        } else System.out.println("First name contains invalid characters. Student was not created.");

    }

    public void deleteStudentByID() {
        System.out.println("Type student id: ");
        Long id = scanner.nextLong();
        Student student = studentsRepository.findById(id);

        if (student != null) {
            System.out.println("STUDENT FOUND");
            studentsRepository.removeStudent(student);
            System.out.println("Student " + student.getFirstName() + " was deleted");
        } else System.out.println("STUDENT NOT FOUND");
    }

    private boolean checkIfStudentNameIsCorrect(String firstName) {
        return Pattern.matches("[a-zA-Z]+", firstName);
    }

}
