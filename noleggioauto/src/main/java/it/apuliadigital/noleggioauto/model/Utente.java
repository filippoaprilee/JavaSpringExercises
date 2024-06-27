package it.apuliadigital.noleggioauto.model;

public class Utente {
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private Ruolo Ruolo;

    public Utente(Long id, String nome, String cognome, String email, String password, Ruolo ruolo) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.Ruolo = ruolo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Ruolo getRuolo() {
        return Ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        Ruolo = ruolo;
    }

    @Override
    public String toString() {
        return "ID: " + id + ".\nNome e cognome: " + nome + " " + cognome + ".\nEmail e password: " + email + " " + password + ".\nRuolo: " + Ruolo + ".";
    }
}
