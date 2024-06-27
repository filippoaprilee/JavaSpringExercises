package it.apuliadigital.noleggioauto.service;

import it.apuliadigital.noleggioauto.model.Prenotazione;

import java.util.List;

public interface PrenotazioneService {
    List<Prenotazione> trovaTutteLePrenotazioni();
    Prenotazione trovaPrenotazionePerId(Long id);
    void aggiungiPrenotazione(Prenotazione prenotazione);
    void modificaPrenotazione(Prenotazione prenotazione);
    void eliminaPrenotazione(Long id);
}
