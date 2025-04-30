package com.demo.example.student_library_management_system.service;

import com.demo.example.student_library_management_system.converter.StudentConverter;
import com.demo.example.student_library_management_system.enums.CardStatus;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.repository.StudentRepository;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(StudentRequestDto studentRequestDto) {

        //Convert the RequestDto into the model class.
        Student student = StudentConverter.convertStudentRequestDtoToStudent(studentRequestDto);

        //whenever a student is saved, a card should be created for that student.
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        student.setCard(card);

        card.setStudent(student);

        studentRepository.save(student);

        return "Student and Card Saved Successfully!";

    }

}
