package com.demo.example.student_library_management_system.converter;

import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;

public class StudentConverter {

    //Converter - it converts the RequestDto into the model class so that model class can be saved in a database.

    public static Student convertStudentRequestDtoToStudent(StudentRequestDto studentRequestDto) {

        Student student = new Student();

        student.setName(studentRequestDto.getName());

        student.setEmail(studentRequestDto.getEmail());

        student.setMobile(studentRequestDto.getMobile());

        student.setDepartment(studentRequestDto.getDepartment());

        student.setSemester(studentRequestDto.getSemester());

        student.setGender(studentRequestDto.getGender());

        student.setDob(studentRequestDto.getDob());

        return student;

    }
    
}
