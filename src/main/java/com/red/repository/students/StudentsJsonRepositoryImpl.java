package com.red.repository.students;

import com.red.configuration.DataSourceConfiguration;
import com.red.model.Student;
import io.jsondb.JsonDBTemplate;
import java.util.List;

public class StudentsJsonRepositoryImpl implements StudentsRepository {

    private final JsonDBTemplate jsonDBTemplate = DataSourceConfiguration.jsonDBTemplate();
    static Long idIndex = 0L;

    @Override
    public List<Student> findAll() {
        return jsonDBTemplate.findAll(Student.class);
    }

    @Override
    public void createStudent(Student student) {
        student.setId(idIndex);
        jsonDBTemplate.insert(student);
        idIndex++;
    }

    @Override
    public Student findById(Long id) {
        return jsonDBTemplate.findById(id, Student.class);
    }
}
