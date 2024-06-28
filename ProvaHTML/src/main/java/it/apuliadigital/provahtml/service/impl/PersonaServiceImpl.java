package it.apuliadigital.provahtml.service.impl;

import it.apuliadigital.provahtml.model.Persona;
import it.apuliadigital.provahtml.service.PersonaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {
    private List<Persona> persone = new ArrayList<>();
    private int nextId = 0;

    @Override
    public List<Persona> getAllPersone() {
        return persone;
    }

    @Override
    public Persona getPersonaById(int id) {
        Optional<Persona> personaOptional = persone.stream().filter(p -> p.getId() == id).findFirst();
        return personaOptional.orElseThrow(() -> new RuntimeException("Persona non trovata"));
    }

    @Override
    public void addPersona(Persona persona) {
        persona.setId(nextId++);
        persone.add(persona);
    }

    @Override
    public void updatePersona(int id, Persona persona) {
        persone.stream().filter(p -> p.getId() == id).findFirst().ifPresent(p -> {
            p.setNome(persona.getNome());
            p.setCognome(persona.getCognome());
            p.setEta(persona.getEta());
        });
    }

    @Override
    public void deletePersona(int id) {
        persone.removeIf(p -> p.getId() == id);
    }
}
