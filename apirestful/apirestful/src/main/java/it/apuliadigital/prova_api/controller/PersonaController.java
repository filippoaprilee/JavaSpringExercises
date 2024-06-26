package it.apuliadigital.prova_api.controller;

import it.apuliadigital.prova_api.model.Persona;
import it.apuliadigital.prova_api.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persone")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/get")
    public List<Persona> getAllPersone() {
        return personaService.getAllPersone();
    }

    @GetMapping("/get/{id}")
    public Persona getPersonaById(@PathVariable int id) {
        return personaService.getPersonaById(id);
    }

    @PostMapping("/add")
    public void addPersona(@RequestBody Persona persona) {
        personaService.addPersona(persona);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePersonaById(@PathVariable int id) {
        personaService.deletePersonaById(id);
    }
}
