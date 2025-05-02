package com.demo.example.student_library_management_system.service;

import com.demo.example.student_library_management_system.converter.BookConverter;
import com.demo.example.student_library_management_system.model.Author;
import com.demo.example.student_library_management_system.model.Book;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.repository.AuthorRepository;
import com.demo.example.student_library_management_system.repository.BookRepository;
import com.demo.example.student_library_management_system.repository.CardRepository;
import com.demo.example.student_library_management_system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CardRepository cardRepository;

    public String saveBook(BookRequestDto bookRequestDto){

        Book book = BookConverter.convertBookRequestDtoToBook(bookRequestDto);

        //using authorid fetch the complete object of author from authorrepository.
        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();

        if (author == null) {
            book.setAuthor(null);
        } else {
            book.setAuthor(author);
        }

        //using cardid fetch the complete object of card from cardrepository.
        Card card = cardRepository.findById(bookRequestDto.getCardId()).get();

        if (card == null) {
            book.setCard(null);
        } else {
            book.setCard(card);
        }

        bookRepository.save(book);
        return "Book Saved Successfully!";

    }

}
