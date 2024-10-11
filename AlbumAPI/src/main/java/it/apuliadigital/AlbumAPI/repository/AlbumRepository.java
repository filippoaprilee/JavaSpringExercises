package it.apuliadigital.albumApi.repository;

import it.apuliadigital.albumApi.entity.AlbumEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<AlbumEntity, Long> {
    List<AlbumEntity> findByTitle(String title);
    List<AlbumEntity> findByAuthor(String author);
    List<AlbumEntity> findByTitleAndAuthor(String title, String author);


}
