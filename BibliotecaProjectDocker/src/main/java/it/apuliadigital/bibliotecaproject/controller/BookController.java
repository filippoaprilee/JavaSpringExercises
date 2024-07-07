package it.apuliadigital.bibliotecaproject.controller;

import it.apuliadigital.bibliotecaproject.entity.BookEntity;
import it.apuliadigital.bibliotecaproject.exception.BookException;
import it.apuliadigital.bibliotecaproject.exception.ErrorResponse;
import it.apuliadigital.bibliotecaproject.exception.SuccessResponse;
import it.apuliadigital.bibliotecaproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public SuccessResponse<Integer> createBook(@RequestBody BookEntity book) {
        int id = bookService.createBook(book);
        return new SuccessResponse<>(HttpStatus.CREATED.value(), "Book aggiunto con successo", id);
    }

    @DeleteMapping("/delete/{id}")
    public SuccessResponse<String> deleteBook(@PathVariable int id) {
        boolean success = bookService.deleteBook(id);
        if (success) {
            return new SuccessResponse<>(HttpStatus.OK.value(), "Book rimosso con successo");
        }
        return new SuccessResponse<>(HttpStatus.NOT_FOUND.value(), "Book non trovato");
    }

    @PutMapping("/update/{id}")
    public SuccessResponse<String> updateBook(@PathVariable int id, @RequestBody BookEntity book) {
        boolean success = bookService.updateBook(id, book);
        if (success) {
            return new SuccessResponse<>(HttpStatus.OK.value(), "Book aggiornato con successo");
        }
        return new SuccessResponse<>(HttpStatus.NOT_FOUND.value(), "Book non trovato");
    }

    @GetMapping("/find/{id}")
    public SuccessResponse<BookEntity> findBook(@PathVariable int id) {
        BookEntity book = bookService.getBookById(id);
        if (book != null) {
            return new SuccessResponse<>(HttpStatus.OK.value(), "Book trovato con successo", book);
        }
        return new SuccessResponse<>(HttpStatus.NOT_FOUND.value(), "Book non trovato");
    }

    @GetMapping("/all")
    public SuccessResponse<List<BookEntity>> findAllBooks() {
        List<BookEntity> books = bookService.getAllBooks();
        return new SuccessResponse<>(HttpStatus.OK.value(), "Books trovati con successo", books);
    }

    @GetMapping("/search")
    public SuccessResponse<List<BookEntity>> searchBooks(@RequestParam(value = "title", required = false) String title,
                                                         @RequestParam(value = "author", required = false) String author,
                                                         @RequestParam(value = "genre", required = false) String genre,
                                                         @RequestParam(value = "isbn", required = false) String isbn,
                                                         @RequestParam(value = "language", required = false) String language,
                                                         @RequestParam(value = "publisher", required = false) String publisher,
                                                         @RequestParam(value = "publishedDate", required = false) LocalDate publishedDate) {
        List<BookEntity> books = bookService.searchBooks(title, author, genre, isbn, language, publisher, publishedDate);
        return new SuccessResponse<>(HttpStatus.OK.value(), "Books trovati con successo", books);
    }

    // metodo per gestire le eccezioni
    @ExceptionHandler(value = BookException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleBooksNotFound(BookException e) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
