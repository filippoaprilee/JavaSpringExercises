package it.apuliadigital.bibliotecaproject.service.impl;

import it.apuliadigital.bibliotecaproject.entity.BookEntity;
import it.apuliadigital.bibliotecaproject.repository.BookRepository;
import it.apuliadigital.bibliotecaproject.service.BookService;
import it.apuliadigital.bibliotecaproject.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LogService logService;

    @Override
    public int createBook(BookEntity bookEntity) {
        int bookId = bookRepository.save(bookEntity).getId();
        logService.saveLog("/book/create", "Creazione libro con ID: " + bookId);
        return bookId;
    }

    @Override
    public BookEntity getBookById(int id) {
        logService.saveLog("/book/find/" + id, "Ricerca libro con ID: " + id);
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        logService.saveLog("/book/all", "Libri trovati");
        return (List<BookEntity>) bookRepository.findAll();
    }

    @Override
    public boolean updateBook(int id, BookEntity bookEntity) {
        logService.saveLog("/book/update/" + id, "Aggiornamento libro con ID: " + id);
        if (bookRepository.existsById(id)) {
            bookEntity.setId(id);
            bookRepository.save(bookEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBook(int id) {
        logService.saveLog("/book/delete/" + id, "Rimozione libro con ID: " + id);
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<BookEntity> searchBooks(String title, String author, String genre,
                                        String isbn, String language, String publisher,
                                        LocalDate publishedDate) {
        logService.saveLog("/book/search", "Ricerca libri con parametri: " +
                (title != null ? "name=" + title + " " : "") +
                (author != null ? "author=" + author + " " : "") +
                (genre != null ? "genre=" + genre + " " : "") +
                (isbn != null ? "isbn=" + isbn + " " : "") +
                (language != null ? "language=" + language + " " : "") +
                (publisher != null ? "publisher=" + publisher + " " : "") +
                (publishedDate != null ? "publishedDate=" + publishedDate : ""));
        if (author != null) {
            return bookRepository.findByAuthor(author);
        } else if (genre != null) {
            return bookRepository.findByGenre(genre);
        } else if (title != null) {
            return bookRepository.findByTitle(title);
        } else if (isbn != null) {
            return bookRepository.findByIsbn(isbn);
        } else if (language != null) {
            return bookRepository.findByLanguage(language);
        } else if (publisher != null) {
            return bookRepository.findByPublisher(publisher);
        } else if (publishedDate != null) {
            return bookRepository.findByPublishedDate(publishedDate);
        } else {
            return null;
        }
    }
}
