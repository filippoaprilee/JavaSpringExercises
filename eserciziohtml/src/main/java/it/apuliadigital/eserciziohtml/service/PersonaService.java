package it.apuliadigital.eserciziohtml.service;

import it.apuliadigital.eserciziohtml.model.Persona;

import java.util.List;

public interface PersonaService {
    Persona save(Persona persona);
    List<Persona> findAll();
    Persona findById(Long id);
    void deleteById(Long id);
}