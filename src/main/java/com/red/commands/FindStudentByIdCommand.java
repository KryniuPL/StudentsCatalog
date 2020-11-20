package com.red.commands;

import com.red.model.Student;

public class FindStudentByIdCommand extends BaseCommandProvider {

    @Override
    public void execute() {
        System.out.println("Type student id: ");
        Long id = scanner.nextLong();
        Student student = studentsService.findStudentById(id);

        if (student != null) {
            System.out.println("STUDENT FOUND");
            System.out.println(student);
        } else System.out.println("STUDENT NOT FOUND");
    }

    @Override
    public Command getCommandName() {
        return Command.FIND_STUDENT_BY_ID;
    }
}
