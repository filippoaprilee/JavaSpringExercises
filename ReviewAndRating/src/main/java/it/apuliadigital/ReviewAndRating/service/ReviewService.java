package it.apuliadigital.ReviewAndRating.service;

import it.apuliadigital.ReviewAndRating.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();
    Review getReviewById(Long idReview);
    Review createReview(Review review);
    boolean updateReview(Long id, Review review);
    boolean deleteReview(Long id);
    List<Review> searchReviewsByAlbumId(Long albumId);
    List<Review> searchReviewsByEmail(String email);
}
