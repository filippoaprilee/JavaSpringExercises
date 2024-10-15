package it.apuliadigital.Museo.mapper;

import it.apuliadigital.Museo.entity.ArtistaEntity;
import it.apuliadigital.Museo.model.Artista;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArtistaMapper {

    // Mappa da Entity a DTO
    Artista toDto(ArtistaEntity artistaEntity);

    // Mappa da DTO a Entity
    ArtistaEntity toEntity(Artista artistaDTO);
}
