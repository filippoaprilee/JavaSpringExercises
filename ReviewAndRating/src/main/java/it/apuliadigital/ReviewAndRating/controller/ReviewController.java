package it.apuliadigital.ReviewAndRating.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.ReviewAndRating.api.ReviewsApi;
import it.apuliadigital.ReviewAndRating.model.Review;
import it.apuliadigital.ReviewAndRating.service.ReviewService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController implements ReviewsApi {

    @Autowired
    private ReviewService reviewService;

    Logger logger = LoggerFactory.getLogger(ReviewController.class);

    @Override
    public ResponseEntity<Review> createReview(
            @Parameter(name = "Review", description = "Data for the new review", required = true) @Valid @RequestBody Review review
    ) {
        Review newReview = reviewService.createReview(review);
        logger.info("Review created: " + newReview);
        return new ResponseEntity<Review>(newReview, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteReview(
            @Parameter(name = "reviewId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("reviewId") Long reviewId
    ) {
        reviewService.deleteReview(reviewId);
        logger.info("Review deleted: " + reviewId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        logger.info("Reviews found: " + reviews.size());
        return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Review> getReviewById(
            @Parameter(name = "reviewId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("reviewId") Long reviewId
    ) {
        Review review = reviewService.getReviewById(reviewId);
        logger.info("Review found: " + review);
        return new ResponseEntity<Review>(review, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Review>> getReviewsByAlbumId(
            @Parameter(name = "albumId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("albumId") Long albumId
    ) {
        List<Review> reviews = reviewService.searchReviewsByAlbumId(albumId);
        logger.info("Reviews found: " + reviews.size());
        return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Review>> getReviewsByAuthorEmail(
            @jakarta.validation.constraints.Email @Parameter(name = "reviewerEmail", description = "", required = true, in = ParameterIn.PATH) @PathVariable("reviewerEmail") String reviewerEmail
    ) {
        List<Review> reviews = reviewService.searchReviewsByEmail(reviewerEmail);
        logger.info("Reviews found: " + reviews.size());
        return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Review> updateReview(
            @Parameter(name = "reviewId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("reviewId") Long reviewId,
            @Parameter(name = "Review", description = "Updated review data", required = true) @Valid @RequestBody Review review
    ) {
        reviewService.updateReview(reviewId, review);
        logger.info("Review updated: " + review);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
