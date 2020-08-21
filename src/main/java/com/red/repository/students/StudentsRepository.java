package com.red.repository.students;

import com.red.model.Student;
import java.util.List;

public interface StudentsRepository {

    List<Student> findAll();
    void createStudent(Student student);
    Student findById(Long id);
}
