package it.apuliadigital.ReviewAndRating.repository;

import it.apuliadigital.ReviewAndRating.entity.RatingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RatingRepository extends CrudRepository<RatingEntity, Long> {
    List<RatingEntity> findByAlbumId(Long albumId);
}
