package it.apuliadigital.noleggioauto.controller;

import it.apuliadigital.noleggioauto.service.RecensioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import it.apuliadigital.noleggioauto.model.Recensione;
import java.util.List;

@RestController
@RequestMapping("/recensioni")
public class RecensioneController {

    @Autowired
    private RecensioneService recensioneService;

    @GetMapping("/get")
    public List<Recensione> trovaTutteLeRecensioni() {
        return recensioneService.trovaTutteLeRecensioni();
    }

    @GetMapping("/get/{id}")
    public Recensione trovaRecensionePerId(@PathVariable Long id) {
        return recensioneService.trovaRecensionePerId(id);
    }

    @PostMapping("/add")
    public void aggiungiRecensione(@RequestBody Recensione recensione) {
        recensioneService.aggiungiRecensione(recensione);
    }

    @PutMapping("/update/{id}")
    public void modificaRecensione(@PathVariable Long id, @RequestBody Recensione recensione) {
        recensione.setId(id);
        recensioneService.modificaRecensione(recensione);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminaRecensione(@PathVariable Long id) {
        recensioneService.eliminaRecensione(id);
    }

}
