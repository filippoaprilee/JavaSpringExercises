package it.apuliadigital.noleggioauto.service;

import it.apuliadigital.noleggioauto.model.Veicolo;

import java.util.List;

public interface VeicoloService {
    List<Veicolo> trovaTuttiIVeicoli();
    Veicolo trovaVeicoloPerId(Long id);
    void aggiungiVeicolo(Veicolo veicolo);
    void modificaVeicolo(Veicolo veicolo);
    void eliminaVeicolo(Long id);
}
