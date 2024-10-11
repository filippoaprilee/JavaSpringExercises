package it.apuliadigital.ReviewAndRating.service;

import it.apuliadigital.ReviewAndRating.model.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> getAllRatings();
    Rating getRatingById(Long idRating);
    Rating createRating(Rating rating);
    boolean updateRating(Long id, Rating rating);
    boolean deleteRating(Long id);
    List<Rating> searchRatingsByAlbumId(Long albumId);
}
