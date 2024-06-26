package it.apuliadigital.prova_api.service;

import it.apuliadigital.prova_api.model.Persona;

import java.util.List;

public interface PersonaService {
    void addPersona(Persona persona);
    List<Persona> getAllPersone();
    Persona getPersonaById(Long id);
    void deletePersona(Long id);
}
