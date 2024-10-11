package it.apuliadigital.albumApi.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name="Album")
@Table(name="album")
public class AlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAlbum;
    private String title;
    private String author;

    public AlbumEntity() {
    }

    public AlbumEntity(Long idAlbum, String title, String author) {
        this.idAlbum = idAlbum;
        this.title = title;
        this.author = author;
    }

    public Long getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Long idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumEntity that = (AlbumEntity) o;
        return Objects.equals(idAlbum, that.idAlbum) && Objects.equals(title, that.title) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlbum, title, author);
    }

    @Override
    public String toString() {
        return "AlbumEntity{" +
                "idAlbum=" + idAlbum +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
