package it.apuliadigital.anagraficaClient.service.impl;

import it.apuliadigital.anagraficaClient.client.model.PersonaClient;
import it.apuliadigital.anagraficaClient.service.PersonaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Override
    public PersonaClient createPersona(PersonaClient personaClient) {
        return personaService.createPersona(personaClient);
    }

    @Override
    public boolean deletePersona(Long idPersona) {
        return personaService.deletePersona(idPersona);
    }

    @Override
    public List<PersonaClient> getAllPersona() {
        return personaService.getAllPersona();
    }

    @Override
    public boolean updatePersona(Long idPersona, PersonaClient personaClient) {
        return personaService.updatePersona(idPersona, personaClient);
    }

    @Override
    public PersonaClient getPersonaById(Long idPersona) {
        return personaService.getPersonaById(idPersona);
    }
}
