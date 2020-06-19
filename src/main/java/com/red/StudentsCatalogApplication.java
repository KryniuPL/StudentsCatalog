package com.red;

import com.red.model.Student;
import java.util.UUID;

public class StudentsCatalogApplication {

    public void run() {
        Student student = new Student(
                UUID.randomUUID().toString()
        );

        System.out.println(student);
    }



}
