package com.red.configuration;

import com.red.model.Student;
import io.jsondb.JsonDBTemplate;
import java.io.File;

public class ApplicationConfiguration {

    static File studentsCollection = new File("src/main/resources/students.json");

    public static void prepareApplication() {
        JsonDBTemplate jsonDBTemplate = DataSourceConfiguration.jsonDBTemplate();
        if (!studentsCollection.exists()) {
            jsonDBTemplate.createCollection(Student.class);
        }
    }
}
