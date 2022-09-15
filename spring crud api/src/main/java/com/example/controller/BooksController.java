package com.example.controller;

import com.example.model.Books;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.service.BooksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BooksController {
    @Autowired
    private BooksService booksService;

    @GetMapping("/")
    public String getString() {
        return "Hi";
    }

    @GetMapping("/book")
    private List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/book/{bookid}")
    private Books getBooks(@PathVariable("bookid") String bookid) {
        return booksService.getBooksById(bookid);
    }

    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") String bookid) {
        booksService.delete(bookid);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/books")
    private String saveBook(@RequestBody Books books) {
        booksService.saveOrUpdate(books);
        return books.getId();
    }

    //creating put mapping that updates the book detail
    @PutMapping("/books")
    private Books update(@RequestBody Books books) {
        booksService.saveOrUpdate(books);
        return books;
    }
}
