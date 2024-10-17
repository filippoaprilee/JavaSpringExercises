package it.apuliadigital.EsercitazionePetStore.mapper;

import it.apuliadigital.EsercitazionePetStore.entity.AnimaleEntity;
import it.apuliadigital.EsercitazionePetStore.server.model.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimaleMapper {

    // Da dto a entity
    AnimaleEntity toEntity(Pet pet);

    // Da entity a dto
    Pet toDto(AnimaleEntity animaleEntity);
}
