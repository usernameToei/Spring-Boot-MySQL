package com.example.service;

import com.example.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.BooksRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {
    @Autowired
    BooksRepository booksRepository;

    public List<Books> getAllBooks() {
        List<Books> books = new ArrayList<>();
        booksRepository.findAll().forEach(books1 -> books.add(books1));
        return books;
    }

    public Books getBooksById(String id) {
        return booksRepository.findById(id).get();
    }

    public void saveOrUpdate(Books books) {
        booksRepository.save(books);
    }

    public void delete(String id) {
        booksRepository.deleteById(id);
    }

}
