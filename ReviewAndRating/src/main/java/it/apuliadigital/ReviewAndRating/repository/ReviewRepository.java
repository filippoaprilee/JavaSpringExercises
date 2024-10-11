package it.apuliadigital.ReviewAndRating.repository;

import it.apuliadigital.ReviewAndRating.entity.ReviewEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<ReviewEntity, Long> {
    List<ReviewEntity> findByAlbumId(Long albumId);
    List<ReviewEntity> findByReviewerEmail(String email);
}
