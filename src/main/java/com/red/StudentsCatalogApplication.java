package com.red;

import com.red.repository.students.StudentsJsonRepositoryImpl;
import com.red.repository.students.StudentsRepository;

public class StudentsCatalogApplication {

    private StudentsRepository studentsRepository = new StudentsJsonRepositoryImpl();

    public void run() {
    }
}
