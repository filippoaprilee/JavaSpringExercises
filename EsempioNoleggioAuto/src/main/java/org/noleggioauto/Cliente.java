package org.noleggioauto;

public class Cliente {
    private int id;
    private String nome;
    private String cognome;
    private String numeroTelefono;
    private String email;

    // Costruttore
    public Cliente(int id, String nome, String cognome, String numeroTelefono, String email) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
    }

    // Getter e Setter
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

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString() per la rappresentazione testuale dell'oggetto
    @Override
    public String toString() {
        return id + " " + nome + " " + cognome + " " + numeroTelefono + " " + email;
    }
}
