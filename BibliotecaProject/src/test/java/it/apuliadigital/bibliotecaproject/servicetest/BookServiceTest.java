package it.apuliadigital.bibliotecaproject.servicetest;

import it.apuliadigital.bibliotecaproject.entity.BookEntity;
import it.apuliadigital.bibliotecaproject.repository.BookRepository;
import it.apuliadigital.bibliotecaproject.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookServiceTest {

    @Autowired
    BookService bookService;

    @MockBean
    BookRepository bookRepository;

    @Test
    void testCreateBook() {
        BookEntity book = new BookEntity("Java Programming", "John Doe", "Thriller", "1234567890", "English", "ABC Publisher", LocalDate.now());
        when(bookRepository.save(book)).thenReturn(book);

        int createdBook = bookService.createBook(book);

        assertEquals(0, createdBook);
        verify(bookRepository).save(book);
    }

    @Test
    void testGetBookById() {
        int bookId = 1;
        BookEntity book = new BookEntity("Java Programming", "John Doe", "Thriller", "1234567890", "English", "ABC Publisher", LocalDate.now());
        book.setId(bookId);
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        BookEntity foundBook = bookService.getBookById(bookId);

        assertEquals(book, foundBook);
        verify(bookRepository).findById(bookId);
    }

    @Test
    void testGetAllBooks() {
        List<BookEntity> books = List.of(
                new BookEntity("Java Programming", "John Doe", "Thriller", "1234567890", "English", "ABC Publisher", LocalDate.now()),
                new BookEntity("Spring in Action", "Jane Smith", "History", "0987654321", "English", "XYZ Publisher", LocalDate.now())
        );
        when(bookRepository.findAll()).thenReturn(books);

        List<BookEntity> foundBooks = bookService.getAllBooks();

        assertEquals(books.size(), foundBooks.size());
        for (int i = 0; i < books.size(); i++) {
            assertEquals(books.get(i), foundBooks.get(i));
        }
        verify(bookRepository).findAll();
    }

    @Test
    void testUpdateBook() {
        int bookId = 1;
        BookEntity book = new BookEntity("Java Programming", "John Doe", "Thriller", "1234567890", "English", "ABC Publisher", LocalDate.now());
        book.setId(bookId);
        when(bookRepository.existsById(bookId)).thenReturn(true);
        when(bookRepository.save(book)).thenReturn(book);

        boolean result = bookService.updateBook(bookId, book);

        assertEquals(true, result);
        verify(bookRepository).save(book);
    }

    @Test
    void testDeleteBook() {
        int bookId = 1;
        when(bookRepository.existsById(bookId)).thenReturn(true);

        boolean result = bookService.deleteBook(bookId);

        assertEquals(true, result);
        verify(bookRepository).deleteById(bookId);
    }
}