package it.apuliadigital.ReviewAndRating.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.ReviewAndRating.api.ApiUtil;
import it.apuliadigital.ReviewAndRating.api.RatingsApi;
import it.apuliadigital.ReviewAndRating.model.Rating;
import it.apuliadigital.ReviewAndRating.service.RatingService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class RatingController implements RatingsApi {

    @Autowired
    private RatingService ratingService;

    Logger logger = LoggerFactory.getLogger(ReviewController.class);

    @Override
    public ResponseEntity<Rating> createRating(
            @Parameter(name = "Rating", description = "Data for the new rating", required = true) @Valid @RequestBody Rating rating
    ) {
        Rating newRating = ratingService.createRating(rating);
        logger.info("Rating created: " + newRating);
        return new ResponseEntity<Rating>(newRating, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Rating>> getAllRatings(

    ) {
        List<Rating> ratings = ratingService.getAllRatings();
        logger.info("Ratings found: " + ratings.size());
        return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Rating>> getRatingsByAlbumId(
            @Parameter(name = "albumId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("albumId") Long albumId
    ) {
        List<Rating> ratings = ratingService.searchRatingsByAlbumId(albumId);
        logger.info("Ratings found: " + ratings.size());
        return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteRating(@Parameter(name = "ratingId",description = "",required = true,in = ParameterIn.PATH) @PathVariable("ratingId") Long ratingId) {
        ratingService.deleteRating(ratingId);
        logger.info("Rating deleted: " + ratingId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Rating> updateRating(@Parameter(name = "ratingId",description = "",required = true,in = ParameterIn.PATH) @PathVariable("ratingId") Long ratingId, @Parameter(name = "Rating",description = "Updated rating data",required = true) @RequestBody @Valid Rating rating) {
        ratingService.updateRating(ratingId, rating);
        logger.info("Rating updated: " + ratingId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Rating> getRatingById(@Parameter(name = "ratingId",description = "",required = true,in = ParameterIn.PATH) @PathVariable("ratingId") Long ratingId) {
        Rating rating = ratingService.getRatingById(ratingId);
        logger.info("Rating found: " + rating);
        return new ResponseEntity<Rating>(rating, HttpStatus.OK);
    }

}
