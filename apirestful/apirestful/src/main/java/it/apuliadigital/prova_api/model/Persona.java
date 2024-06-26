package it.apuliadigital.prova_api.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String cognome;
    // Altri campi della persona...

    public Persona() {}

    public Persona(JSONObject jsonObject) {
        if (jsonObject.has("id")) {
            this.id = jsonObject.getInt("id");
        } else {
            // Se 'id' non è presente nel JSON, non impostiamo l'ID qui
            // È responsabilità del servizio gestire questo caso in modo appropriato
        }

        if (jsonObject.has("nome")) {
            this.nome = jsonObject.getString("nome");
        } else {
            // Gestione nel caso 'nome' non sia presente nel JSON
            throw new JSONException("Campo 'nome' non trovato nel JSON");
        }

        if (jsonObject.has("cognome")) {
            this.cognome = jsonObject.getString("cognome");
        } else {
            // Gestione nel caso 'cognome' non sia presente nel JSON
            throw new JSONException("Campo 'cognome' non trovato nel JSON");
        }
    }


    // Getters e setters
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

    // Altri metodi se necessari
}