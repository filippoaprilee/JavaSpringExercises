package it.apuliadigital.bibliotecaproject.controllertest;

import it.apuliadigital.bibliotecaproject.controller.BookController;
import it.apuliadigital.bibliotecaproject.entity.BookEntity;
import it.apuliadigital.bibliotecaproject.exception.BookException;
import it.apuliadigital.bibliotecaproject.exception.ErrorResponse;
import it.apuliadigital.bibliotecaproject.exception.SuccessResponse;
import it.apuliadigital.bibliotecaproject.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BookControllerTest {

    @MockBean
    private BookService bookService;

    @Autowired
    private BookController bookController;

    @Test
    public void testCreateBook() {
        BookEntity book = new BookEntity();
        book.setTitle("Test Book");

        when(bookService.createBook(book)).thenReturn(1);

        SuccessResponse<Integer> successResponse = bookController.createBook(book);

        assertEquals(HttpStatus.CREATED.value(), successResponse.getStatusCode());
        assertEquals("Book aggiunto con successo", successResponse.getMessage());
        assertEquals(1, successResponse.getObject());

        verify(bookService, times(1)).createBook(book);
    }

    @Test
    public void testDeleteBook_Success() {
        int id = 1;

        when(bookService.deleteBook(id)).thenReturn(true);

        SuccessResponse<String> responseEntity = bookController.deleteBook(id);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode());
        assertEquals("Book rimosso con successo", responseEntity.getMessage());

        verify(bookService, times(1)).deleteBook(id);
    }

    @Test
    public void testDeleteBook_NotFound() {
        int id = 2;

        when(bookService.deleteBook(id)).thenReturn(false);

        SuccessResponse<String> responseEntity = bookController.deleteBook(id);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCode());
        assertEquals("Book non trovato", responseEntity.getMessage());

        verify(bookService, times(1)).deleteBook(id);
    }

    @Test
    public void testUpdateBook_Success() {
        int id = 1;
        BookEntity book = new BookEntity();
        book.setTitle("Updated Book");

        when(bookService.updateBook(id, book)).thenReturn(true);

        SuccessResponse<String> responseEntity = bookController.updateBook(id, book);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode());
        assertEquals("Book aggiornato con successo", responseEntity.getMessage());

        verify(bookService, times(1)).updateBook(id, book);
    }

    @Test
    public void testUpdateBook_NotFound() {
        int id = 2;
        BookEntity book = new BookEntity();
        book.setTitle("Non-existent Book");

        when(bookService.updateBook(id, book)).thenReturn(false);

        SuccessResponse<String> responseEntity = bookController.updateBook(id, book);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCode());
        assertEquals("Book non trovato", responseEntity.getMessage());

        verify(bookService, times(1)).updateBook(id, book);
    }

    @Test
    public void testFindBook_Success() {
        int id = 1;
        BookEntity book = new BookEntity();
        book.setId(id);
        book.setTitle("Found Book");

        when(bookService.getBookById(id)).thenReturn(book);

        SuccessResponse<BookEntity> responseEntity = bookController.findBook(id);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode());
        assertEquals("Book trovato con successo", responseEntity.getMessage());
        assertEquals(book, responseEntity.getObject());

        verify(bookService, times(1)).getBookById(id);
    }

    @Test
    public void testFindBook_NotFound() {
        int id = 2;

        when(bookService.getBookById(id)).thenReturn(null);

        SuccessResponse<BookEntity> responseEntity = bookController.findBook(id);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCode());
        assertEquals("Book non trovato", responseEntity.getMessage());

        verify(bookService, times(1)).getBookById(id);
    }

    @Test
    public void testFindAllBooks() {
        BookEntity book1 = new BookEntity();
        book1.setId(1);
        book1.setTitle("First Book");

        BookEntity book2 = new BookEntity();
        book2.setId(2);
        book2.setTitle("Second Book");

        List<BookEntity> books = Arrays.asList(book1, book2);

        when(bookService.getAllBooks()).thenReturn(books);

        SuccessResponse<List<BookEntity>> responseEntity = bookController.findAllBooks();

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode());
        assertEquals("Books trovati con successo", responseEntity.getMessage());
        assertEquals(books, responseEntity.getObject());

        verify(bookService, times(1)).getAllBooks();
    }

    @Test
    public void testSearchBooks() {
        String title = "Search Title";
        String author = "Search Author";

        BookEntity book1 = new BookEntity();
        book1.setId(1);
        book1.setTitle(title);
        book1.setAuthor(author);

        List<BookEntity> books = List.of(book1);

        when(bookService.searchBooks(title, author, null, null, null, null, null)).thenReturn(books);

        SuccessResponse<List<BookEntity>> responseEntity = bookController.searchBooks(title, author, null, null, null, null, null);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode());
        assertEquals("Books trovati con successo", responseEntity.getMessage());
        assertEquals(books, responseEntity.getObject());

        verify(bookService, times(1)).searchBooks(title, author, null, null, null, null, null);
    }

    @Test
    public void testHandleBooksNotFound() {
        BookException exception = new BookException("Book non trovato");

        ErrorResponse errorResponse = bookController.handleBooksNotFound(exception);

        assertEquals(HttpStatus.NOT_FOUND.value(), errorResponse.getStatusCode());
        assertEquals("Book non trovato", errorResponse.getMessage());
    }
}