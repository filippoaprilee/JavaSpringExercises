package it.apuliadigital.provahtml.controller;

import it.apuliadigital.provahtml.model.Persona;
import it.apuliadigital.provahtml.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persone")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public ResponseEntity<List<Persona>> getAllPersone() {
        List<Persona> persone = personaService.getAllPersone();
        return ResponseEntity.ok(persone);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable int id) {
        Persona persona = personaService.getPersonaById(id);
        if (persona != null) {
            return ResponseEntity.ok(persona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Void> aggiungiPersona(@RequestBody Persona persona) {
        personaService.addPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")

}
