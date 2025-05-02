package com.demo.example.student_library_management_system.service;

import com.demo.example.student_library_management_system.converter.TransactionConverter;
import com.demo.example.student_library_management_system.model.Book;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.model.Transaction;
import com.demo.example.student_library_management_system.repository.BookRepository;
import com.demo.example.student_library_management_system.repository.CardRepository;
import com.demo.example.student_library_management_system.repository.TransactionRepository;
import com.demo.example.student_library_management_system.requestdto.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;

    public String saveTransaction(TransactionRequestDto transactionRequestDto){

        Transaction transaction = TransactionConverter.convertTransactionDtoToTransaction(transactionRequestDto);

        Book book = bookRepository.findById(transactionRequestDto.getBookId()).get();

        if (book == null) {
            transaction.setBook(null);
        } else {
            transaction.setBook(book);
        }

        Card card = cardRepository.findById(transactionRequestDto.getCardId()).get();

        if (card == null) {
            transaction.setCard(null);
        } else {
            transaction.setCard(card);
        }

        transactionRepository.save(transaction);

        return "Transaction Saved Successfully!";
    }

}
