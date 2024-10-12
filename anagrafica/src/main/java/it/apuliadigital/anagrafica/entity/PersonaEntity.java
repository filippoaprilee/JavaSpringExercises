package it.apuliadigital.anagrafica.entity;

import java.util.List;
import java.util.Objects;

import it.apuliadigital.anagrafica.model.PersonaDTONumeriTelefonici;

import jakarta.persistence.*;

@Entity
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnagrafica;

    private String nome;

    private String cognome;

    @Embedded
    private PersonaDTONumeriTelefonici numeriTelefonici;

    private List<String> elencoIndirizziEmail;

    private String dataNascita;

    public PersonaEntity() {
    }

    public PersonaEntity(Long idAnagrafica, String nome, String cognome, PersonaDTONumeriTelefonici numeriTelefonici,
                         List<String> elencoIndirizziEmail, String dataNascita) {
        this.idAnagrafica = idAnagrafica;
        this.nome = nome;
        this.cognome = cognome;
        this.numeriTelefonici = numeriTelefonici;
        this.elencoIndirizziEmail = elencoIndirizziEmail;
        this.dataNascita = dataNascita;
    }

    public Long getIdAnagrafica() {
        return this.idAnagrafica;
    }

    public void setIdAnagrafica(Long idAnagrafica) {
        this.idAnagrafica = idAnagrafica;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public PersonaDTONumeriTelefonici getNumeriTelefonici() {
        return this.numeriTelefonici;
    }

    public void setNumeriTelefonici(PersonaDTONumeriTelefonici numeriTelefonici) {
        this.numeriTelefonici = numeriTelefonici;
    }

    public List<String> getElencoIndirizziEmail() {
        return this.elencoIndirizziEmail;
    }

    public void setElencoIndirizziEmail(List<String> elencoIndirizziEmail) {
        this.elencoIndirizziEmail = elencoIndirizziEmail;
    }

    public String getDataNascita() {
        return this.dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public PersonaEntity idAnagrafica(Long idAnagrafica) {
        setIdAnagrafica(idAnagrafica);
        return this;
    }

    public PersonaEntity nome(String nome) {
        setNome(nome);
        return this;
    }

    public PersonaEntity cognome(String cognome) {
        setCognome(cognome);
        return this;
    }

    public PersonaEntity numeriTelefonici(PersonaDTONumeriTelefonici numeriTelefonici) {
        setNumeriTelefonici(numeriTelefonici);
        return this;
    }

    public PersonaEntity elencoIndirizziEmail(List<String> elencoIndirizziEmail) {
        setElencoIndirizziEmail(elencoIndirizziEmail);
        return this;
    }

    public PersonaEntity dataNascita(String dataNascita) {
        setDataNascita(dataNascita);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PersonaEntity)) {
            return false;
        }
        PersonaEntity personaEntity = (PersonaEntity) o;
        return Objects.equals(idAnagrafica, personaEntity.idAnagrafica) && Objects.equals(nome, personaEntity.nome)
                && Objects.equals(cognome, personaEntity.cognome)
                && Objects.equals(numeriTelefonici, personaEntity.numeriTelefonici)
                && Objects.equals(elencoIndirizziEmail, personaEntity.elencoIndirizziEmail)
                && Objects.equals(dataNascita, personaEntity.dataNascita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnagrafica, nome, cognome, numeriTelefonici, elencoIndirizziEmail, dataNascita);
    }

    @Override
    public String toString() {
        return "{" +
                " idAnagrafica='" + getIdAnagrafica() + "'" +
                ", nome='" + getNome() + "'" +
                ", cognome='" + getCognome() + "'" +
                ", numeriTelefonici='" + getNumeriTelefonici() + "'" +
                ", elencoIndirizziEmail='" + getElencoIndirizziEmail() + "'" +
                ", dataNascita='" + getDataNascita() + "'" +
                "}";
    }

}