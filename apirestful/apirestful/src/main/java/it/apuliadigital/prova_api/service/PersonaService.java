package it.apuliadigital.prova_api.service;

import it.apuliadigital.prova_api.model.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> getAllPersone();
    Persona getPersonaById(int id);
    void addPersona(Persona persona);
    void deletePersonaById(int id);
}
