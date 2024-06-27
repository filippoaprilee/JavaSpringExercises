package it.apuliadigital.noleggioauto.controller;

import it.apuliadigital.noleggioauto.model.Veicolo;
import it.apuliadigital.noleggioauto.service.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veicoli")
public class VeicoloController {

    @Autowired
    private VeicoloService veicoloService;

    @GetMapping("/get")
    public List<Veicolo> getAllVeicoli() {
        return veicoloService.trovaTuttiIVeicoli();
    }

    @GetMapping("/get/{id}")
    public Veicolo getVeicoloById(@PathVariable Long id) {
        return veicoloService.trovaVeicoloPerId(id);
    }

    @GetMapping("/get/{targa}")
    public Veicolo getVeicoloByTarga(@PathVariable String targa) {
        return veicoloService.trovaVeicoloPerTarga(targa);
    }

    @PostMapping("/add")
    public void addVeicolo(@RequestBody Veicolo veicolo) {
        veicoloService.aggiungiVeicolo(veicolo);
    }

    @PutMapping("/update/{id}")
    public void updateVeicolo(@PathVariable Long id, @RequestBody Veicolo veicolo) {
        veicolo.setId(id);
        veicoloService.modificaVeicolo(veicolo);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVeicolo(@PathVariable Long id) {
        veicoloService.eliminaVeicolo(id);
    }
}
