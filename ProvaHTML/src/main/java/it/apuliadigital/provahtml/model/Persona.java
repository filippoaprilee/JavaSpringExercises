package it.apuliadigital.provahtml.model;

public class Persona {
    private int id;
    private String nome;
    private String cognome;
    private int eta;

    public Persona(int id, String nome, String cognome, int eta) {
        tis.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
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

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}
