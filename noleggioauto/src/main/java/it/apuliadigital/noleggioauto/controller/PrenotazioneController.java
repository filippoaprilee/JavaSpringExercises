package it.apuliadigital.noleggioauto.controller;

import it.apuliadigital.noleggioauto.model.Prenotazione;
import it.apuliadigital.noleggioauto.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping("/get")
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneService.trovaTutteLePrenotazioni();
    }

    @GetMapping("/get/{id}")
    public Prenotazione getPrenotazioneById(@PathVariable Long id) {
        return prenotazioneService.trovaPrenotazionePerId(id);
    }

    @GetMapping("/get/{idUtente}")
    public List<Prenotazione> getPrenotazioniByUtente(@PathVariable Long idUtente) {
        return prenotazioneService.trovaPrenotazioniPerUtente(idUtente);
    }

    @GetMapping("/get/{idVeicolo}")
    public List<Prenotazione> getPrenotazioniByVeicolo(@PathVariable Long idVeicolo) {
        return prenotazioneService.trovaPrenotazioniPerVeicolo(idVeicolo);
    }

    @PostMapping("/add")
    public void addPrenotazione(@RequestBody Prenotazione prenotazione) {
        prenotazioneService.aggiungiPrenotazione(prenotazione);
    }

    @PutMapping("/update/{id}")
    public void updatePrenotazione(@PathVariable Long id, @RequestBody Prenotazione prenotazione) {
        prenotazione.setId(id);
        prenotazioneService.modificaPrenotazione(prenotazione);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePrenotazione(@PathVariable Long id) {
        prenotazioneService.eliminaPrenotazione(id);
    }
}
