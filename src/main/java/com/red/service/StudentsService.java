package com.red.service;

import com.red.model.Student;
import com.red.repository.students.StudentsJsonRepositoryImpl;
import com.red.repository.students.StudentsRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
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

    public void findStudentById() {
        System.out.println("Type student id: ");
        Long id = scanner.nextLong();
        Student student = studentsRepository.findById(id);


        if (student != null) {
            System.out.println("STUDENT FOUND");
            System.out.println(student);
        } else System.out.println("STUDENT NOT FOUND");
    }

    public List<Student> findStudentsByLimit(int limit) {
        return studentsRepository.findAll().parallelStream().limit(limit).collect(Collectors.toList());
    }

    public void createStudent(Student student) {
        try {
            setStudentName(student);
            setStudentBirthDate(student);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        studentsRepository.createStudent(student);
        System.out.println("Student was not created.");

        System.out.println(student);
    }

    public void setStudentName(Student student) throws IllegalArgumentException {
        System.out.println("Type student firstName: ");
        String firstName = scanner.next();

        if (checkIfStudentNameIsCorrect(firstName)) {
            student.setFirstName(firstName);
        } else throw new IllegalArgumentException("Incorrect name");
    }

    public void setStudentBirthDate(Student student) throws IllegalArgumentException {
        System.out.println("Type student birth date (yyyy-mm-dd): ");
        LocalDate birthDate = LocalDate.parse(scanner.next());

        if (birthDate.isBefore(ChronoLocalDate.from(LocalDateTime.now()))) {
            student.setBirthDate(birthDate);
        } else throw new IllegalArgumentException("Incorrect date");
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

    public List<Student> findStudentsByFirstLetterOfFirstName() {
        System.out.println("Type first letter of first name: ");
        String firstLetter = scanner.next();
        List<Student> students = studentsRepository.findAll()
                .stream()
                .filter(student -> student.getFirstName().toLowerCase().startsWith(firstLetter.toLowerCase()))
                .collect(Collectors.toList());

        if (students.isEmpty()) {
            System.out.println("No student found");
        }
        return students;
    }

    public List<Student> findStudentsAboveAge() {
        System.out.println("Type student age: ");
        long age = scanner.nextLong();

        return studentsRepository.findAll()
                .stream()
                .filter(student -> student.getBirthDate().minusYears(-age).isBefore(ChronoLocalDate.from(LocalDateTime.now())))
                .collect(Collectors.toList());
    }
}
