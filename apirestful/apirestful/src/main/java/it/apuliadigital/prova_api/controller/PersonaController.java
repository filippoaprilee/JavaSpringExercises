package it.apuliadigital.prova_api.controller;

import it.apuliadigital.prova_api.model.Persona;
import it.apuliadigital.prova_api.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api/persone")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public RedirectView redirectView() {
        return new RedirectView("index.html");
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllPersone() {
        try {
            List<Persona> persone = personaService.getAllPersone();
            return new ResponseEntity<>(persone, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Errore nella lettura delle persone all'interno del file JSON.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPersonaById(@PathVariable int id) {
        try {
            Persona persona = personaService.getPersonaById(id);
            if (persona == null) {
                return new ResponseEntity<>("Errore: persona con id " + id + " non trovata.", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(persona, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Errore nella lettura della persona con id " + id + " dal file JSON", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPersona(@RequestBody Persona persona) {
        try {
            personaService.addPersona(persona);
            return new ResponseEntity<>(persona + ".\nPersona aggiunta con successo al file JSON.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Errore nell'inserimento di una persona all'interno del file JSON.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePersonaById(@PathVariable int id) {
        try {
            Persona persona = personaService.getPersonaById(id);
            if (persona == null) {
                return new ResponseEntity<>("Errore: persona con id " + id + " non trovata.", HttpStatus.NOT_FOUND);
            }
            personaService.deletePersonaById(id);
            return new ResponseEntity<>("Persona con ID " + id + " eliminata con successo.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Errore nella rimozione di una persona con id " + id + " all'interno del file JSON.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<?> deleteAllPersone() {
        try {
            personaService.deleteAll();
            return new ResponseEntity<>("Tutte le persone sono state eliminate con successo.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Errore nella rimozione di tutte le persone dentro il file JSON.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
