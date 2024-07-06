package it.apuliadigital.bibliotecaproject.repository;

import it.apuliadigital.bibliotecaproject.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
    List<BookEntity> findByAuthor(String author);
    List<BookEntity> findByGenre(String genre);
    List<BookEntity> findByTitle(String title);
    List<BookEntity> findByPublishedDate(LocalDate publishedDate);
    List<BookEntity> findByIsbn(String isbn);
    List<BookEntity> findByLanguage(String language);
    List<BookEntity> findByPublisher(String publisher);
    List<BookEntity> findByAuthorOrGenreOrTitleOrIsbnOrLanguageOrPublisherOrPublishedDate(String author, String genre, String title, String isbn, String language, String publisher, LocalDate publishedDate);
}
