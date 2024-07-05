package it.apuliadigital.rubricaprojectpro.controller;

import it.apuliadigital.rubricaprojectpro.entity.ContattoEntity;
import it.apuliadigital.rubricaprojectpro.service.ContattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatti")
public class ContattoController {

    @Autowired
    private ContattoService contattoService;

    @PostMapping
    public ResponseEntity<Integer> aggiungiContatto(@RequestBody ContattoEntity contatto) {
        int id = contattoService.aggiungiContatto(contatto);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> rimuoviContatto(@PathVariable int id) {
        boolean success = contattoService.rimuoviContatto(id);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> aggiornaContatto(@PathVariable int id, @RequestBody ContattoEntity contatto) {
        boolean success = contattoService.aggiornaContatto(id, contatto);
        if (success) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContattoEntity> trovaContatto(@PathVariable int id) {
        ContattoEntity contatto = contattoService.trovaContatto(id);
        if (contatto != null) {
            return ResponseEntity.ok(contatto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ContattoEntity>> trovaContatti() {
        List<ContattoEntity> contatti = contattoService.trovaContatti();
        return ResponseEntity.ok(contatti);
    }

    @GetMapping("/cerca")
    public ResponseEntity<List<ContattoEntity>> cercaContatti(@RequestParam String nome, @RequestParam String cognome) {
        List<ContattoEntity> contatti = contattoService.cercaContatti(nome, cognome);
        return ResponseEntity.ok(contatti);
    }
}
