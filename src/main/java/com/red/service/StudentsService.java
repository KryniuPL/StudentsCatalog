package com.red.service;

import com.red.model.Student;
import com.red.repository.students.StudentsJsonRepositoryImpl;
import com.red.repository.students.StudentsRepository;
import java.util.Objects;

public class StudentsService {

    private final StudentsRepository studentsRepository = new StudentsJsonRepositoryImpl();

    public void createStudent(Student student) {
        Objects.requireNonNull(student.getId());
        studentsRepository.createStudent(student);
    }

    // TODO: Exercise
    // 1. Create student
    // 2. Check if name is a correct string in separate method and invoke it in createStudent method
    private void checkIfStudentNameIsCorrect(String name) {

    }
}
