package it.apuliadigital.noleggioauto.service;

import it.apuliadigital.noleggioauto.model.Utente;

import java.util.List;

public interface UtenteService {
    List<Utente> trovaTuttiGliUtenti();
    Utente trovaUtentePerId(Long id);
    void aggiungiUtente(Utente utente);
    void modificaUtente(Utente utente);
    void eliminaUtente(Long id);
}
