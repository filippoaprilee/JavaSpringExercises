package it.apuliadigital.Museo.entity;

import jakarta.persistence.*;
import it.apuliadigital.Museo.model.Artista.TipologiaArtistaEnum;

import java.util.Objects;


@Entity
@Table(name="artista")
public class ArtistaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idArtista;
    private String nomeArtista;
    private Integer annoNascita;
    private Integer annoMorte;
    private String biografia;
    private String nazionalità;
    @Enumerated(EnumType.STRING)
    private TipologiaArtistaEnum tipologiaArtista;

    public ArtistaEntity() {
    }

    public ArtistaEntity(Long idArtista, String nomeArtista, Integer annoNascita, Integer annoMorte, String biografia, String nazionalità, TipologiaArtistaEnum tipologiaArtista) {
        this.idArtista = idArtista;
        this.nomeArtista = nomeArtista;
        this.annoNascita = annoNascita;
        this.annoMorte = annoMorte;
        this.biografia = biografia;
        this.nazionalità = nazionalità;
        this.tipologiaArtista = tipologiaArtista;
    }

    public Long getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Long idArtista) {
        this.idArtista = idArtista;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public Integer getAnnoNascita() {
        return annoNascita;
    }

    public void setAnnoNascita(Integer annoNascita) {
        this.annoNascita = annoNascita;
    }

    public Integer getAnnoMorte() {
        return annoMorte;
    }

    public void setAnnoMorte(Integer annoMorte) {
        this.annoMorte = annoMorte;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getNazionalità() {
        return nazionalità;
    }

    public void setNazionalità(String nazionalità) {
        this.nazionalità = nazionalità;
    }

    public TipologiaArtistaEnum getTipologiaArtista() {
        return tipologiaArtista;
    }

    public void setTipologiaArtista(TipologiaArtistaEnum tipologiaArtista) {
        this.tipologiaArtista = tipologiaArtista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtistaEntity that = (ArtistaEntity) o;
        return Objects.equals(idArtista, that.idArtista) && Objects.equals(nomeArtista, that.nomeArtista) && Objects.equals(annoNascita, that.annoNascita) && Objects.equals(annoMorte, that.annoMorte) && Objects.equals(biografia, that.biografia) && Objects.equals(nazionalità, that.nazionalità) && tipologiaArtista == that.tipologiaArtista;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArtista, nomeArtista, annoNascita, annoMorte, biografia, nazionalità, tipologiaArtista);
    }

    @Override
    public String toString() {
        return "ArtistaEntity{" +
                "idArtista=" + idArtista +
                ", nomeArtista='" + nomeArtista + '\'' +
                ", annoNascita=" + annoNascita +
                ", annoMorte=" + annoMorte +
                ", biografia='" + biografia + '\'' +
                ", nazionalità='" + nazionalità + '\'' +
                ", tipologiaArtista=" + tipologiaArtista +
                '}';
    }
}
