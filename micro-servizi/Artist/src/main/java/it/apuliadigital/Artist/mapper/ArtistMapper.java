package it.apuliadigital.Artist.mapper;

import it.apuliadigital.Artist.entity.ArtistEntity;
import it.apuliadigital.Artist.model.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArtistMapper {

    // Mappa da Entity a DTO
    Artist toDto(ArtistEntity artistEntity);

    // Mappa da DTO a Entity
    ArtistEntity toEntity(Artist artistDTO);
}
