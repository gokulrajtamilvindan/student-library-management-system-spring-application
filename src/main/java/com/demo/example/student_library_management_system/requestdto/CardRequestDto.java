package com.demo.example.student_library_management_system.requestdto;

import com.demo.example.student_library_management_system.enums.CardStatus;
import com.demo.example.student_library_management_system.model.Student;

public class CardRequestDto {

    private CardStatus cardStatus;

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
