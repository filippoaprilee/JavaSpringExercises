package it.apuliadigital.anagrafica.mapper;

import it.apuliadigital.anagrafica.entity.PersonaEntity;
import it.apuliadigital.anagrafica.model.PersonaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaDTO toDto(PersonaEntity personaEntity);

    PersonaEntity toEntity(PersonaDTO personaDTO);
}
