package it.apuliadigital.eserciziohtml.service.impl;

import it.apuliadigital.eserciziohtml.model.Persona;
import it.apuliadigital.eserciziohtml.repository.PersonaRepository;
import it.apuliadigital.eserciziohtml.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona findById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }
}