package it.apuliadigital.petstore.mapper;

import org.mapstruct.Mapper;

import it.apuliadigital.petstore.entity.PetEntity;
import it.apuliadigital.petstore.model.Pet;

@Mapper(componentModel = "spring")
public interface PetMapper {    
    public PetEntity dtoToEntity(Pet pet);
    public Pet entityToDto(PetEntity entity);
}
