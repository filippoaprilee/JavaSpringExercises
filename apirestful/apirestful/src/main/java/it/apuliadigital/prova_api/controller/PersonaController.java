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

    @PostMapping("/add")
    public void addPersona(@RequestBody Persona persona) {
        personaService.addPersona(persona);
    }

    @GetMapping("/all")
    public List<Persona> getAllPersone() {
        return personaService.getAllPersone();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        return personaService.getPersonaById(id);
    }

    @DeleteMapping("/{id}/delete")
    public void deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
    }
}
