package it.apuliadigital.ReviewAndRating.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate reviewDate;
    private String author;
    private String reviewerEmail;
    private String text;
    private Long albumId;

    public ReviewEntity() {
    }

    public ReviewEntity(Long reviewId, LocalDate reviewDate, String author, String reviewerEmail, String text, Long albumId) {
        this.reviewId = reviewId;
        this.reviewDate = reviewDate;
        this.author = author;
        this.reviewerEmail = reviewerEmail;
        this.text = text;
        this.albumId = albumId;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReviewerEmail() {
        return reviewerEmail;
    }

    public void setReviewerEmail(String reviewerEmail) {
        this.reviewerEmail = reviewerEmail;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        ReviewEntity that = (ReviewEntity) o;
        return Objects.equals(reviewId, that.reviewId) && Objects.equals(reviewDate, that.reviewDate) && Objects.equals(author, that.author) && Objects.equals(reviewerEmail, that.reviewerEmail) && Objects.equals(text, that.text) && Objects.equals(albumId, that.albumId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, reviewDate, author, reviewerEmail, text, albumId);
    }

    @Override
    public String toString() {
        return "ReviewEntity{" +
                "reviewId=" + reviewId +
                ", reviewDate=" + reviewDate +
                ", author='" + author + '\'' +
                ", reviewerEmail='" + reviewerEmail + '\'' +
                ", text='" + text + '\'' +
                ", albumId=" + albumId +
                '}';
    }
}
