package com.demo.example.student_library_management_system.service;

import com.demo.example.student_library_management_system.converter.AuthorConverter;
import com.demo.example.student_library_management_system.model.Author;
import com.demo.example.student_library_management_system.repository.AuthorRepository;
import com.demo.example.student_library_management_system.requestdto.AuthorRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public String saveAuthor(AuthorRequestDto authorRequestDto) {

        Author author = AuthorConverter.convertAuthorRequestDtoToAuthor(authorRequestDto);
        authorRepository.save(author);
        return "Author Saved Successfully!";

    }

}
