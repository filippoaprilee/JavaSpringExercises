package it.apuliadigital.anagraficaClient.service;

import it.apuliadigital.anagraficaClient.client.model.PersonaClient;

import java.util.List;

public interface PersonaService {

    PersonaClient createPersona(PersonaClient personaDTO);

    boolean deletePersona(Long idPersona);

    List<PersonaClient> getAllPersona();

    boolean updatePersona(Long idPersona, PersonaClient personaDTO);

    PersonaClient getPersonaById(Long idPersona);
}
