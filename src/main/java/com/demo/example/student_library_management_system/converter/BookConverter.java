package com.demo.example.student_library_management_system.converter;

import com.demo.example.student_library_management_system.model.Book;
import com.demo.example.student_library_management_system.requestdto.BookRequestDto;

public class BookConverter {
    
    public static Book convertBookRequestDtoToBook(BookRequestDto bookRequestDto){
        
        Book book = new Book();
        
        book.setTitle(bookRequestDto.getTitle());

        book.setPublisherName(bookRequestDto.getPublisherName());

        book.setPublishedDate(bookRequestDto.getPublishedDate());

        book.setPages(bookRequestDto.getPages());

        book.setPrice(bookRequestDto.getPrice());

        book.setAvailability(bookRequestDto.isAvailability());

        book.setCategory(bookRequestDto.getCategory());

        book.setRackNo(bookRequestDto.getRackNo());
        
        
        return book;

    }
    
}
