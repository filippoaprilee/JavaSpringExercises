package it.apuliadigital.anagrafica.service.serviceImpl;

import it.apuliadigital.anagrafica.service.PersonaService;
import it.apuliadigital.anagrafica.repository.PersonaRepository;
import it.apuliadigital.anagrafica.mapper.PersonaMapper;
import it.apuliadigital.anagrafica.entity.PersonaEntity;
import it.apuliadigital.anagrafica.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository repository;

    @Autowired
    private PersonaMapper mapper;

    @Override
    public PersonaDTO getPersonaById(Long idPersona) {
        Optional<PersonaEntity> entity = repository.findById(idPersona);
        return entity.map(mapper::toDto).orElse(null);
    }

    @Override
    public PersonaDTO createPersona(PersonaDTO persona) {
        PersonaEntity entity = mapper.toEntity(persona);
        repository.save(entity);
        persona.setIdAnagrafica(entity.getIdAnagrafica());
        return persona;
    }

    @Override
    public boolean updatePersona(Long id, PersonaDTO persona) {
        if (repository.existsById(id)) {
            PersonaEntity entity = mapper.toEntity(persona);
            entity.setIdAnagrafica(id);
            repository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePersona(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<PersonaDTO> getAllPersone() {
        Iterable<PersonaEntity> entities = repository.findAll();
        List<PersonaDTO> persone = new ArrayList<>();
        for (PersonaEntity entity : entities) {
            PersonaDTO dto = mapper.toDto(entity);
            persone.add(dto);
        }
        return persone;
    }

}
