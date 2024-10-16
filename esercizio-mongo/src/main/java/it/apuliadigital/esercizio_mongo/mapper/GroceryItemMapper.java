package it.apuliadigital.esercizio_mongo.mapper;

import it.apuliadigital.esercizio_mongo.document.GroceryItemEntity;
import it.apuliadigital.esercizio_mongo.model.GroceryItemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroceryItemMapper {

    GroceryItemEntity dtoToEntity(GroceryItemDTO groceryItemDTO);

    GroceryItemDTO entityToDto(GroceryItemEntity groceryItemEntity);
}
