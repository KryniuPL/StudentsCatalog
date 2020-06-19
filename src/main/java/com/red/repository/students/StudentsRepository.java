package com.red.repository.students;

import com.red.model.Student;

public interface StudentsRepository {

    void createStudent(Student student);
    Student findById(String id);
}
