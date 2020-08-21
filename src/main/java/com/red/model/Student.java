package com.red.model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;
import java.time.LocalDate;

@Document(collection = "students", schemaVersion= "1.0")
public class Student {

    @Id
    private Long id;
    private String firstName;
    private String secondName;
    private Department department;
    private LocalDate birthDate;
    private int semester;
    private boolean livesInDormitory;

    public Student() {
    }

    public Student(Long id, String firstName, String secondName, Department department, LocalDate birthDate, int semester, boolean livesInDormitory) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.department = department;
        this.birthDate = birthDate;
        this.semester = semester;
        this.livesInDormitory = livesInDormitory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public boolean isLivesInDormitory() {
        return livesInDormitory;
    }

    public void setLivesInDormitory(boolean livesInDormitory) {
        this.livesInDormitory = livesInDormitory;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", department=" + department +
                ", birthDate=" + birthDate +
                ", semester=" + semester +
                ", livesInDormitory=" + livesInDormitory +
                '}';
    }
}
