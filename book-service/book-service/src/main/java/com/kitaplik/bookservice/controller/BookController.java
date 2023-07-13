package com.kitaplik.bookservice.controller;


import com.kitaplik.bookservice.dto.response.BookDto;
import com.kitaplik.bookservice.dto.response.BookIdDto;
import com.kitaplik.bookservice.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/v1/book")
@Validated
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<BookDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getByIsbn(@PathVariable @NotEmpty String isbn) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findByIsbn(isbn));
    }


    @GetMapping("/book/{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty String bookId) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findBookDetailsById(bookId));
    }
}
