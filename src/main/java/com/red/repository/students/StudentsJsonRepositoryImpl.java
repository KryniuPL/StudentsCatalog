package com.red.repository.students;

import com.red.configuration.DataSourceConfiguration;
import com.red.model.Student;
import io.jsondb.JsonDBTemplate;
import java.util.List;

public class StudentsJsonRepositoryImpl implements StudentsRepository {

    private final JsonDBTemplate jsonDBTemplate = DataSourceConfiguration.jsonDBTemplate();

    @Override
    public List<Student> findAll() {
        return jsonDBTemplate.findAll(Student.class);
    }

    @Override
    public void createStudent(Student student) {
        jsonDBTemplate.insert(student);
    }

    @Override
    public Student findById(String id) {
        return jsonDBTemplate.findById(id, Student.class);
    }
}
