package it.apuliadigital.eserciziohtml.controller;

import it.apuliadigital.eserciziohtml.model.Persona;
import it.apuliadigital.eserciziohtml.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/create")
    public Persona createPersona(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @GetMapping("/all")
    public List<Persona> getAllPersonas() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        return personaService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Persona updatePersona(@PathVariable Long id, @RequestBody Persona persona) {
        Persona existingPersona = personaService.findById(id);
        if (existingPersona != null) {
            existingPersona.setNome(persona.getNome());
            existingPersona.setCognome(persona.getCognome());
            return personaService.save(existingPersona);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deletePersona(@PathVariable Long id) {
        personaService.deleteById(id);
    }
}
