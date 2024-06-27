package it.apuliadigital.noleggioauto.service.impl;

import it.apuliadigital.noleggioauto.model.Recensione;
import it.apuliadigital.noleggioauto.service.RecensioneService;

import java.util.ArrayList;
import java.util.List;

public class RecensioneServiceImpl implements RecensioneService {
    private List<Recensione> recensioni = new ArrayList<>();
    private Long ultimoId = 0L;

    @Override
    public List<Recensione> trovaTutteLeRecensioni() {
        return recensioni;
    }

    @Override
    public Recensione trovaRecensionePerId(Long id) {
        return recensioni.stream()
                .filter(recensione -> recensione.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void aggiungiRecensione(Recensione recensione) {
        recensione.setId(++ultimoId);
        recensioni.add(recensione);
    }

    @Override
    public void modificaRecensione(Recensione recensione) {
        Recensione recensioneEsistente = recensioni.stream().filter(r -> r.getId().equals(recensione.getId())).findFirst().orElseThrow(() -> new IllegalArgumentException("Recensione non trovata"));
        if(!recensioneEsistente.getUtenteId().equals(recensione.getUtenteId())) {
            throw new IllegalArgumentException("L'utente non è autorizzato a modificare la recensione");
        }
        if (recensione.getPunteggio() < 1 || recensione.getPunteggio() > 5) {
            throw new IllegalArgumentException("Il punteggio deve essere compreso tra 1 e 5");
        }
        recensioneEsistente.setPunteggio(recensione.getPunteggio());
        recensioneEsistente.setCommento(recensione.getCommento());
        recensioneEsistente.setData(recensione.getData());
    }

    @Override
    public void eliminaRecensione(Long id) {
        recensioni = recensioni.stream()
                .filter(recensione -> !recensione.getId().equals(id))
                .toList();
    }
}
