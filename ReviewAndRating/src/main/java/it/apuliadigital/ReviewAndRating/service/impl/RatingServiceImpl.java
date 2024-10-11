package it.apuliadigital.ReviewAndRating.service.impl;

import it.apuliadigital.ReviewAndRating.entity.RatingEntity;
import it.apuliadigital.ReviewAndRating.model.Rating;
import it.apuliadigital.ReviewAndRating.repository.RatingRepository;
import it.apuliadigital.ReviewAndRating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Rating> getAllRatings() {
        List<RatingEntity> entities = (List<RatingEntity>) ratingRepository.findAll();
        List<Rating> ratings = new ArrayList<>();
        for (RatingEntity entity : entities) {
            Rating r = new Rating();
            r.setRatingId(entity.getRatingId());
            r.setScore(entity.getScore());
            r.setAlbumId(entity.getAlbumId());
            r.setAlbumId(entity.getAlbumId());
            ratings.add(r);
        }
        return ratings;
    }

    @Override
    public Rating getRatingById(Long idRating) {
        Optional<RatingEntity> entity = ratingRepository.findById(idRating);
        System.out.println(entity);
        Rating r = new Rating();
        r.setRatingId(idRating);
        r.setScore(entity.get().getScore());
        r.setAlbumId(entity.get().getAlbumId());
        return r;
    }

    @Override
    public Rating createRating(Rating rating) {
        RatingEntity entity = new RatingEntity();
        entity.setScore(rating.getScore());
        entity.setAlbumId(rating.getAlbumId());
        ratingRepository.save(entity);
        rating.setRatingId(entity.getRatingId());
        return rating;
    }

    @Override
    public boolean updateRating(Long id, Rating rating) {
        if (ratingRepository.existsById(id)) {
            RatingEntity entity = new RatingEntity();
            entity.setRatingId(id);
            entity.setScore(rating.getScore());
            entity.setAlbumId(rating.getAlbumId());
            ratingRepository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRating(Long id) {
        if (ratingRepository.existsById(id)) {
            ratingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Rating> searchRatingsByAlbumId(Long albumId) {
        List<RatingEntity> entities = ratingRepository.findByAlbumId(albumId);
        List<Rating> ratings = new ArrayList<>();
        for (RatingEntity entity : entities) {
            Rating r = new Rating();
            r.setRatingId(entity.getRatingId());
            r.setScore(entity.getScore());
            r.setAlbumId(entity.getAlbumId());
            ratings.add(r);
        }
        return ratings;
    }
}
