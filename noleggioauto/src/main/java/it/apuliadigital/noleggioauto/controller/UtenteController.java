package it.apuliadigital.noleggioauto.controller;

import it.apuliadigital.noleggioauto.model.Utente;
import it.apuliadigital.noleggioauto.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping("/get")
    public List<Utente> getAllUtenti() {
        return utenteService.trovaTuttiGliUtenti();
    }

    @GetMapping("/get/{id}")
    public Utente getUtenteById(@PathVariable Long id) {
        return utenteService.trovaUtentePerId(id);
    }

    @PostMapping("/add")
    public void addUtente(@RequestBody Utente utente) {
        utenteService.aggiungiUtente(utente);
    }

    @PutMapping("/update/{id}")
    public void updateUtente(@PathVariable Long id, @RequestBody Utente utente) {
        utente.setId(id);
        utenteService.modificaUtente(utente);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUtente(@PathVariable Long id) {
        utenteService.eliminaUtente(id);
    }
}
