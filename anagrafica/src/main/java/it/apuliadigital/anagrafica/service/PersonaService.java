package it.apuliadigital.anagrafica.service;

import it.apuliadigital.anagrafica.model.*;

import java.util.List;

public interface PersonaService {
    PersonaDTO getPersonaById(Long idPersona);
    PersonaDTO createPersona(PersonaDTO persona);
    boolean updatePersona(Long id, PersonaDTO persona);
    boolean deletePersona(Long id);
    List<PersonaDTO> getAllPersone();
}
