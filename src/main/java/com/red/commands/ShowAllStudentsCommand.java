package com.red.commands;

import com.red.model.Student;
import com.red.service.StudentsService;

import java.util.List;

public class ShowAllStudentsCommand extends BaseCommandProvider {

    private final StudentsService studentsService = new StudentsService();

    @Override
    public void execute() {
        List<Student> students = studentsService.findAllStudents();
        students.forEach(student -> {
            var firstName = student.getFirstName();
            var secondName = student.getSecondName() == null ? "" : student.getSecondName();
            System.out.println("[" + student.getId() + "] " + firstName + " " + secondName);
        });
    }

    @Override
    public Command getCommandName() {
        return Command.SHOW_ALL_STUDENTS;
    }
}
