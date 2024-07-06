package it.apuliadigital.bibliotecaproject.service.impl;

import it.apuliadigital.bibliotecaproject.entity.BookEntity;
import it.apuliadigital.bibliotecaproject.repository.BookRepository;
import it.apuliadigital.bibliotecaproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public int createBook(BookEntity bookEntity) {
        return bookRepository.save(bookEntity).getId();
    }

    @Override
    public BookEntity getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return (List<BookEntity>) bookRepository.findAll();
    }

    @Override
    public boolean updateBook(int id, BookEntity bookEntity) {
        if (bookRepository.existsById(id)) {
            bookEntity.setId(id);
            bookRepository.save(bookEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBook(int id) {
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
