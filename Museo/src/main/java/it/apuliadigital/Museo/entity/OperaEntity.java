package it.apuliadigital.Museo.entity;

import it.apuliadigital.Museo.model.Opera.TipologiaOperaEnum;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "opera")
public class OperaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOpera;
    private String nomeOpera;
    private Long idArtista;
    private String nomeArtista;
    private Integer annoProduzione;
    private String descrizioneOpera;
    private TipologiaOperaEnum tipologiaOpera;

    public OperaEntity() {
    }

    public OperaEntity(Long idOpera, String nomeOpera, Long idArtista, String nomeArtista, Integer annoProduzione, String descrizioneOpera, TipologiaOperaEnum tipologiaOpera) {
        this.idOpera = idOpera;
        this.nomeOpera = nomeOpera;
        this.idArtista = idArtista;
        this.nomeArtista = nomeArtista;
        this.annoProduzione = annoProduzione;
        this.descrizioneOpera = descrizioneOpera;
        this.tipologiaOpera = tipologiaOpera;
    }

    public Long getIdOpera() {
        return idOpera;
    }

    public void setIdOpera(Long idOpera) {
        this.idOpera = idOpera;
    }

    public String getNomeOpera() {
        return nomeOpera;
    }

    public void setNomeOpera(String nomeOpera) {
        this.nomeOpera = nomeOpera;
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

    public Integer getAnnoProduzione() {
        return annoProduzione;
    }

    public void setAnnoProduzione(Integer annoProduzione) {
        this.annoProduzione = annoProduzione;
    }

    public String getDescrizioneOpera() {
        return descrizioneOpera;
    }

    public void setDescrizioneOpera(String descrizioneOpera) {
        this.descrizioneOpera = descrizioneOpera;
    }

    public TipologiaOperaEnum getTipologiaOpera() {
        return tipologiaOpera;
    }

    public void setTipologiaOpera(TipologiaOperaEnum tipologiaOpera) {
        this.tipologiaOpera = tipologiaOpera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperaEntity that = (OperaEntity) o;
        return Objects.equals(idOpera, that.idOpera) && Objects.equals(nomeOpera, that.nomeOpera) && Objects.equals(idArtista, that.idArtista) && Objects.equals(nomeArtista, that.nomeArtista) && Objects.equals(annoProduzione, that.annoProduzione) && Objects.equals(descrizioneOpera, that.descrizioneOpera) && tipologiaOpera == that.tipologiaOpera;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOpera, nomeOpera, idArtista, nomeArtista, annoProduzione, descrizioneOpera, tipologiaOpera);
    }

    @Override
    public String toString() {
        return "OperaEntity{" +
                "idOpera=" + idOpera +
                ", nomeOpera='" + nomeOpera + '\'' +
                ", idArtista=" + idArtista +
                ", nomeArtista='" + nomeArtista + '\'' +
                ", annoProduzione=" + annoProduzione +
                ", descrizioneOpera='" + descrizioneOpera + '\'' +
                ", tipologiaOpera=" + tipologiaOpera +
                '}';
    }
}
