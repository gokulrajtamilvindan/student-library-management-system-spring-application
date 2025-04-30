package com.demo.example.student_library_management_system.requestdto;

import com.demo.example.student_library_management_system.enums.TransactionType;
import com.demo.example.student_library_management_system.model.Book;
import com.demo.example.student_library_management_system.model.Card;
import jakarta.persistence.*;

public class TransactionRequestDto {

    private  String dueDate;

    private int fine;

    private TransactionType transactionType;

    private Book book;

    private Card card;

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

}
