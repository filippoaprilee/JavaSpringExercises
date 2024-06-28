package it.apuliadigital.provahtml.service;

import it.apuliadigital.provahtml.model.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> getAllPersone();
    Persona getPersonaById(int id);
    void addPersona(Persona persona);
    void updatePersona(int id, Persona persona);
    void deletePersona(int id);
}
