package com.red.repository.students;

import com.red.configuration.DataSourceConfiguration;
import com.red.model.Student;
import io.jsondb.JsonDBTemplate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentsJsonRepositoryImpl implements StudentsRepository {

    private final JsonDBTemplate jsonDBTemplate = DataSourceConfiguration.jsonDBTemplate();
    private AtomicInteger ID_GENERATOR = new AtomicInteger(getLastIndex());

    private int getLastIndex() {
        var listOfAllStudents = findAll();
        if (listOfAllStudents.isEmpty()) return 1000;
        return Math.toIntExact(listOfAllStudents.get(listOfAllStudents.size() - 1).getId()) + 1;
    }

    @Override
    public List<Student> findAll() {
        return jsonDBTemplate.findAll(Student.class);
    }

    @Override
    public void createStudent(Student student) {
        student.setId((long) ID_GENERATOR.getAndIncrement());
        jsonDBTemplate.insert(student);
    }

    @Override
    public void removeStudent(Student student) {
        jsonDBTemplate.remove(student,Student.class);
    }

    @Override
    public Student findById(Long id) {
        return jsonDBTemplate.findById(id, Student.class);
    }

    @Override
    public Student findByFirstLetter(char firstLetter) {
        return null;
    }
}
