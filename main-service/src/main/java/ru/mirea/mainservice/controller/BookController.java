package ru.mirea.mainservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.mainservice.model.Book;
import ru.mirea.mainservice.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController extends BaseController<Book, Long, BookService> {

    @Autowired
    public BookController(BookService bookService) {
        super(bookService);
    }
}
