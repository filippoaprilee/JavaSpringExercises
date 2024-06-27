package it.apuliadigital.noleggioauto.service.impl;

import it.apuliadigital.noleggioauto.model.Utente;
import it.apuliadigital.noleggioauto.service.UtenteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtenteServiceImpl implements UtenteService {
    private List<Utente> utenti = new ArrayList<>();
    private Long ultimoId = 0L;

    @Override
    public List<Utente> trovaTuttiGliUtenti() {
        return utenti;
    }

    @Override
    public Utente trovaUtentePerId(Long id) {
        return utenti.stream()
                .filter(utente -> utente.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void aggiungiUtente(Utente utente) {
        utente.setId(++ultimoId);
        utenti.add(utente);
    }

    @Override
    public void modificaUtente(Utente utente) {
        Utente utenteDaModificare = trovaUtentePerId(utente.getId());
        if (utenteDaModificare != null) {
            utenteDaModificare.setNome(utente.getNome());
            utenteDaModificare.setCognome(utente.getCognome());
            utenteDaModificare.setEmail(utente.getEmail());
            utenteDaModificare.setPassword(utente.getPassword());
        }
    }

    @Override
    public void eliminaUtente(Long id) {
        utenti = utenti.stream()
                .filter(utente -> !utente.getId().equals(id))
                .toList();
    }
}
