package it.apuliadigital.bibliotecaproject.repositorytest;

import it.apuliadigital.bibliotecaproject.entity.BookEntity;
import it.apuliadigital.bibliotecaproject.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        // Pulisce il repository prima di ogni test
        bookRepository.deleteAll();

        // Inserisce dei dati di prova
        BookEntity book1 = new BookEntity("Java Programming", "John Doe", "History", "1234567890", "English", "ABC Publisher", LocalDate.now());
        BookEntity book2 = new BookEntity("Spring in Action", "Jane Smith", "Thriller", "0987654321", "English", "XYZ Publisher", LocalDate.now());

        bookRepository.saveAll(List.of(book1, book2));
    }

    @Test
    @Order(1)
    void testFindByAuthor() {
        List<BookEntity> foundBooks = bookRepository.findByAuthor("John Doe");

        assertEquals(1, foundBooks.size());
        assertEquals("Java Programming", foundBooks.get(0).getTitle());
    }

    @Test
    @Order(2)
    void testFindByGenre() {
        List<BookEntity> foundBooks = bookRepository.findByGenre("Thriller");

        assertEquals(1, foundBooks.size());
        assertNotEquals(2, foundBooks.size());
    }

    @Test
    @Order(3)
    void testFindByTitle() {
        List<BookEntity> foundBooks = bookRepository.findByTitle("Spring in Action");

        assertEquals(1, foundBooks.size());
        assertEquals("Spring in Action", foundBooks.get(0).getTitle());
    }

    @Test
    @Order(4)
    void testFindByPublishedDate() {
        List<BookEntity> foundBooks = bookRepository.findByPublishedDate(LocalDate.now());

        assertEquals(2, foundBooks.size());
    }

    @Test
    @Order(5)
    void testFindByIsbn() {
        List<BookEntity> foundBooks = bookRepository.findByIsbn("1234567890");

        assertEquals(1, foundBooks.size());
        assertEquals("Java Programming", foundBooks.get(0).getTitle());
    }

    @Test
    @Order(6)
    void testFindByLanguage() {
        List<BookEntity> foundBooks = bookRepository.findByLanguage("English");

        assertEquals(2, foundBooks.size());
    }

    @Test
    @Order(7)
    void testFindByPublisher() {
        List<BookEntity> foundBooks = bookRepository.findByPublisher("ABC Publisher");

        assertEquals(1, foundBooks.size());
        assertEquals("Java Programming", foundBooks.get(0).getTitle());
    }
}
