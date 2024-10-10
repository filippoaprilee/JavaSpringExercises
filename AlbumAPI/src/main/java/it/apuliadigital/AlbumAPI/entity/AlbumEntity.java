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
    private String dataUscita;
    @Enumerated(EnumType.STRING)
    private GenereEnum genere;
    private Boolean isAvailable;
    private Integer release_year;

    public AlbumEntity() {
    }

    public AlbumEntity(Long idAlbum, String title, String author, String dataUscita, GenereEnum genere, Boolean isAvailable, Integer release_year) {
        this.idAlbum = idAlbum;
        this.title = title;
        this.author = author;
        this.dataUscita = dataUscita;
        this.genere = genere;
        this.isAvailable = isAvailable;
        this.release_year = release_year;
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

    public String getDataUscita() {
        return dataUscita;
    }

    public void setDataUscita(String dataUscita) {
        this.dataUscita = dataUscita;
    }

    public GenereEnum getGenere() {
        return genere;
    }

    public void setGenere(GenereEnum genere) {
        this.genere = genere;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumEntity that = (AlbumEntity) o;
        return Objects.equals(idAlbum, that.idAlbum) && Objects.equals(title, that.title) && Objects.equals(author, that.author) && Objects.equals(dataUscita, that.dataUscita) && Objects.equals(genere, that.genere) && Objects.equals(isAvailable, that.isAvailable) && Objects.equals(release_year, that.release_year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlbum, title, author, dataUscita, genere, isAvailable, release_year);
    }

    @Override
    public String toString() {
        return "AlbumEntity{" +
                "idAlbum=" + idAlbum +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", dataUscita='" + dataUscita + '\'' +
                ", genere=" + genere +
                ", isAvailable=" + isAvailable +
                ", release_year=" + release_year +
                '}';
    }
}
