package it.apuliadigital.rubricaprojectpro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern; // Corrected import
import java.util.Objects;

@Entity
public class ContattoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cognome;
    //@Column(length = 15)
    private String telefono;
    //@Pattern(regexp = ".+@.+\\..+", message = "Invalid email format") // Validation for email
    private String email;

    public ContattoEntity() {}

    public ContattoEntity(String nome, String cognome, String telefono, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cognome, telefono, email);
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " " + telefono + " " + email;
    }
}
