package it.apuliadigital.bibliotecaproject.servicetest;

import it.apuliadigital.bibliotecaproject.entity.BookEntity;
import it.apuliadigital.bibliotecaproject.repository.BookRepository;
import it.apuliadigital.bibliotecaproject.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    BookService bookService;

    @MockBean
    BookRepository bookRepository;

    private BookEntity book1;
    private BookEntity book2;
    private List<BookEntity> bookList;

    @BeforeEach
    void setUp() {
        book1 = new BookEntity("Java Programming", "John Doe", "Thriller", "1234567890",
                "English", "ABC Publisher", LocalDate.now());
        book2 = new BookEntity("Spring in Action", "Jane Smith", "History", "0987654321",
                "English", "XYZ Publisher", LocalDate.now());
        bookList = List.of(book1, book2);
    }


    @Test
    @Order(1)
    void testCreateBook() {
        // Quando tu chiami bookrepository.save(book1) ritornami book1 a prescindere
        when(bookRepository.save(book1)).thenReturn(book1);

        // Chiamo il metodo createBook del bookService con book1
        int createdBook = bookService.createBook(book1);

        // Verifico che il metodo createBook abbia ritornato 0
        assertEquals(0, createdBook);

        assertNotEquals(1, createdBook);

        // Verifico che il metodo save del bookRepository sia stato chiamato con book1 una volta sola
        verify(bookRepository, times(1)).save(book1);
    }

    @Test
    @Order(2)
    void testGetBookById() {
        int bookId = 1;
        book1.setId(bookId);
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book1));

        BookEntity foundBook = bookService.getBookById(bookId);

        assertEquals(book1, foundBook);
        verify(bookRepository).findById(bookId);
    }

    @Test
    @Order(3)
    void testGetAllBooks() {
        when(bookRepository.findAll()).thenReturn(bookList);

        List<BookEntity> foundBooks = bookService.getAllBooks();

        assertEquals(bookList.size(), foundBooks.size());
        for (int i = 0; i < bookList.size(); i++) {
            assertEquals(bookList.get(i), foundBooks.get(i));
        }
        verify(bookRepository).findAll();
    }

    @Test
    @Order(4)
    void testUpdateBook() {
        int bookId = 1;
        book1.setId(bookId);
        when(bookRepository.existsById(bookId)).thenReturn(true);
        when(bookRepository.save(book1)).thenReturn(book1);

        boolean result = bookService.updateBook(bookId, book1);

        assertTrue(result);
        verify(bookRepository).save(book1);
    }

    @Test
    @Order(5)
    void testDeleteBook() {
        int bookId = 1;
        when(bookRepository.existsById(bookId)).thenReturn(true);

        boolean result = bookService.deleteBook(bookId);

        assertTrue(result);
        verify(bookRepository).deleteById(bookId);
    }


    @Test
    void testSearchBooksByTitle() {
        String title = "Java Programming";
        when(bookRepository.findByTitle(title)).thenReturn(List.of(book1));

        List<BookEntity> foundBooks = bookService.searchBooks(title, null, null, null, null, null, null);

        assertEquals(List.of(book1), foundBooks);
        verify(bookRepository).findByTitle(title);
    }

    @Test
    void testSearchBooksByTitle_NotFound() {
        String title = "Non existent title";
        when(bookRepository.findByTitle(title)).thenReturn(Collections.emptyList());

        List<BookEntity> foundBooks = bookService.searchBooks(title, null, null, null, null, null, null);

        assertTrue(foundBooks.isEmpty());
        verify(bookRepository).findByTitle(title);
    }


    @Test
    void testSearchBooksByAuthor() {
        String author = "John Doe";
        when(bookRepository.findByAuthor(author)).thenReturn(List.of(book1));

        List<BookEntity> foundBooks = bookService.searchBooks(null, author, null, null, null, null, null);

        assertEquals(List.of(book1), foundBooks);
        verify(bookRepository).findByAuthor(author);
    }

    @Test
    void testSearchBooksByGenre() {
        String genre = "Thriller";
        when(bookRepository.findByGenre(genre)).thenReturn(List.of(book1));

        List<BookEntity> foundBooks = bookService.searchBooks(null, null, genre, null, null, null, null);

        assertEquals(List.of(book1), foundBooks);
        verify(bookRepository).findByGenre(genre);
    }

    @Test
    void testSearchBooksByIsbn() {
        String isbn = "1234567890";
        when(bookRepository.findByIsbn(isbn)).thenReturn(List.of(book1));

        List<BookEntity> foundBooks = bookService.searchBooks(null, null, null, isbn, null, null, null);

        assertEquals(List.of(book1), foundBooks);
        verify(bookRepository).findByIsbn(isbn);
    }

    @Test
    void testSearchBooksByLanguage() {
        String language = "English";
        when(bookRepository.findByLanguage(language)).thenReturn(List.of(book1));

        List<BookEntity> foundBooks = bookService.searchBooks(null, null, null, null, language, null, null);

        assertEquals(List.of(book1), foundBooks);
        verify(bookRepository).findByLanguage(language);
    }

    @Test
    void testSearchBooksByPublisher() {
        String publisher = "ABC Publisher";
        when(bookRepository.findByPublisher(publisher)).thenReturn(List.of(book1));

        List<BookEntity> foundBooks = bookService.searchBooks(null, null, null, null, null, publisher, null);

        assertEquals(List.of(book1), foundBooks);
        verify(bookRepository).findByPublisher(publisher);
    }

    @Test
    void testSearchBooksByPublishedDate() {
        LocalDate publishedDate = LocalDate.now();
        when(bookRepository.findByPublishedDate(publishedDate)).thenReturn(List.of(book1));

        List<BookEntity> foundBooks = bookService.searchBooks(null, null, null, null, null, null, publishedDate);

        assertEquals(List.of(book1), foundBooks);
        verify(bookRepository).findByPublishedDate(publishedDate);
    }
}