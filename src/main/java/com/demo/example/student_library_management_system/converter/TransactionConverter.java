package com.demo.example.student_library_management_system.converter;

import com.demo.example.student_library_management_system.model.Transaction;
import com.demo.example.student_library_management_system.requestdto.TransactionRequestDto;

public class TransactionConverter {

    public static Transaction convertTransactionDtoToTransaction(TransactionRequestDto transactionRequestDto){

        Transaction transaction = new Transaction();

        transaction.setDueDate(transactionRequestDto.getDueDate());

        transaction.setFine(transactionRequestDto.getFine());

        transaction.setTransactionType(transactionRequestDto.getTransactionType());

        return transaction;

    }

}
