package it.apuliadigital.ReviewAndRating.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "rating")
public class RatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ratingId;
    private Integer score;
    private Long albumId;

    public RatingEntity() {
    }

    public RatingEntity(Long ratingId, Integer score, Long albumId) {
        this.ratingId = ratingId;
        this.score = score;
        this.albumId = albumId;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingEntity that = (RatingEntity) o;
        return Objects.equals(ratingId, that.ratingId) && Objects.equals(score, that.score) && Objects.equals(albumId, that.albumId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ratingId, score, albumId);
    }

    @Override
    public String toString() {
        return "RatingEntity{" +
                "ratingId=" + ratingId +
                ", score=" + score +
                ", albumId=" + albumId +
                '}';
    }
}
