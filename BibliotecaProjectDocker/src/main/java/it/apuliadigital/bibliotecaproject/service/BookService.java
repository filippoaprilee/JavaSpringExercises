package it.apuliadigital.bibliotecaproject.service;

import it.apuliadigital.bibliotecaproject.entity.BookEntity;

import java.time.LocalDate;
import java.util.List;

public interface BookService {
    int createBook(BookEntity book);
    BookEntity getBookById(int id);
    List<BookEntity> getAllBooks();
    boolean updateBook(int id, BookEntity book);
    boolean deleteBook(int id);
    List<BookEntity> searchBooks(String author, String genre, String title, String isbn,
                                 String language, String publisher, LocalDate publishedDate);
}
