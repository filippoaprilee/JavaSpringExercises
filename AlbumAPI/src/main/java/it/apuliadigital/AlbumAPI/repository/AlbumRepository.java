package it.apuliadigital.albumApi.repository;

import it.apuliadigital.albumApi.entity.AlbumEntity;
import it.apuliadigital.albumApi.entity.GenereEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<AlbumEntity, Long> {
    List<AlbumEntity> findByGenere(GenereEnum genere);
    List<AlbumEntity> findByTitle(String title);
    List<AlbumEntity> findByAuthor(String author);
    List<AlbumEntity> findByTitleAndAuthorAndGenere(String title, String author, GenereEnum genere);


}
