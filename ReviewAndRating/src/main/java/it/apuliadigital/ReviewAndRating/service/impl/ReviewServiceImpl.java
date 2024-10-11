package it.apuliadigital.ReviewAndRating.service.impl;

import it.apuliadigital.ReviewAndRating.entity.ReviewEntity;
import it.apuliadigital.ReviewAndRating.model.Review;
import it.apuliadigital.ReviewAndRating.repository.ReviewRepository;
import it.apuliadigital.ReviewAndRating.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        List<ReviewEntity> entities = (List<ReviewEntity>) reviewRepository.findAll();
        List<Review> reviews = new ArrayList<>();
        for (ReviewEntity entity : entities) {
            Review r = new Review();
            r.setReviewId(entity.getReviewId());
            r.setReviewDate(entity.getReviewDate());
            r.setAuthor(entity.getAuthor());
            r.setReviewerEmail(entity.getReviewerEmail());
            r.setText(entity.getText());
            r.setAlbumId(entity.getAlbumId());
            reviews.add(r);
        }
        return reviews;
    }

    @Override
    public Review getReviewById(Long idReview) {
        Optional<ReviewEntity> entity = reviewRepository.findById(idReview);

        Review r = new Review();
        r.setReviewId(idReview);
        r.setReviewDate(entity.get().getReviewDate());
        r.setAuthor(entity.get().getAuthor());
        r.setReviewerEmail(entity.get().getReviewerEmail());
        r.setText(entity.get().getText());
        r.setAlbumId(entity.get().getAlbumId());
        return r;
    }

    @Override
    public Review createReview(Review review) {
        ReviewEntity entity = new ReviewEntity();
        entity.setReviewDate(review.getReviewDate());
        entity.setAuthor(review.getAuthor());
        entity.setReviewerEmail(review.getReviewerEmail());
        entity.setText(review.getText());
        entity.setAlbumId(review.getAlbumId());
        reviewRepository.save(entity);
        review.setReviewId(entity.getReviewId());
        return review;
    }

    @Override
    public boolean updateReview(Long id, Review review) {
        if (reviewRepository.existsById(id)) {
            ReviewEntity entity = new ReviewEntity();
            entity.setReviewId(id);
            entity.setReviewDate(review.getReviewDate());
            entity.setAuthor(review.getAuthor());
            entity.setReviewerEmail(review.getReviewerEmail());
            entity.setText(review.getText());
            entity.setAlbumId(review.getAlbumId());
            reviewRepository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Review> searchReviewsByAlbumId(Long albumId) {
        List<ReviewEntity> entities = reviewRepository.findByAlbumId(albumId);
        List<Review> reviews = new ArrayList<>();
        for (ReviewEntity entity : entities) {
            Review r = new Review();
            r.setReviewId(entity.getReviewId());
            r.setReviewDate(entity.getReviewDate());
            r.setAuthor(entity.getAuthor());
            r.setReviewerEmail(entity.getReviewerEmail());
            r.setText(entity.getText());
            r.setAlbumId(entity.getAlbumId());
            reviews.add(r);
        }
        return reviews;
    }

    @Override
    public List<Review> searchReviewsByEmail(String email) {
        List<ReviewEntity> entities = reviewRepository.findByReviewerEmail(email);
        List<Review> reviews = new ArrayList<>();
        for (ReviewEntity entity : entities) {
            Review r = new Review();
            r.setReviewId(entity.getReviewId());
            r.setReviewDate(entity.getReviewDate());
            r.setAuthor(entity.getAuthor());
            r.setReviewerEmail(entity.getReviewerEmail());
            r.setText(entity.getText());
            r.setAlbumId(entity.getAlbumId());
            reviews.add(r);
        }
        return reviews;
    }
}
