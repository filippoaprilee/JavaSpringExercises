package it.apuliadigital.noleggioauto.service;

import it.apuliadigital.noleggioauto.model.Recensione;

import java.util.List;

public interface RecensioneService {
    List<Recensione> trovaTutteLeRecensioni();
    Recensione trovaRecensionePerId(Long id);
    void aggiungiRecensione(Recensione recensione);
    void modificaRecensione(Recensione recensione);
    void eliminaRecensione(Long id);
}
