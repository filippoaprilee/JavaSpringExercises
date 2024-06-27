package it.apuliadigital.noleggioauto.service.impl;

import it.apuliadigital.noleggioauto.model.Prenotazione;
import it.apuliadigital.noleggioauto.model.StatoPrenotazione;
import it.apuliadigital.noleggioauto.service.PrenotazioneService;

import java.util.ArrayList;
import java.util.List;

public class PrenotazioneServiceImpl implements PrenotazioneService {
    private List<Prenotazione> prenotazioni = new ArrayList<>();
    private Long ultimoId = 0L;

    @Override
    public List<Prenotazione> trovaTutteLePrenotazioni() {
        return prenotazioni;
    }

    @Override
    public Prenotazione trovaPrenotazionePerId(Long id) {
        return prenotazioni.stream()
                .filter(prenotazione -> prenotazione.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void aggiungiPrenotazione(Prenotazione prenotazione) {
        prenotazione.setId(++ultimoId);
        prenotazioni.add(prenotazione);
    }

    @Override
    public void modificaPrenotazione(Prenotazione prenotazione) {
        Prenotazione prenotazioneEsistente = prenotazioni.stream().filter(p -> p.getId().equals(prenotazione.getId())).findFirst().orElseThrow(() -> new IllegalArgumentException("Prenotazione non trovata"));
        if (prenotazione.getDataInizio().isAfter(prenotazione.getDataFine())) {
            throw new IllegalArgumentException("Data inizio deve essere precedente a data fine");
        }
        if (prenotazione.getStato() != StatoPrenotazione.IN_CORSO) {
            throw new IllegalArgumentException("Non è possibile modificare una prenotazione non in corso");
        }
        prenotazioneEsistente.setDataInizio(prenotazione.getDataInizio());
        prenotazioneEsistente.setDataFine(prenotazione.getDataFine());
        prenotazioneEsistente.setVeicoloId(prenotazione.getVeicoloId());
        prenotazioneEsistente.setStato(prenotazione.getStato());
    }

    @Override
    public void eliminaPrenotazione(Long id) {
        prenotazioni = prenotazioni.stream()
                .filter(prenotazione -> !prenotazione.getId().equals(id))
                .toList();
    }
}
