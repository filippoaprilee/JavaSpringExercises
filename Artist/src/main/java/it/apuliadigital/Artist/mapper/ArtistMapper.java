package it.apuliadigital.Artist.mapper;

import it.apuliadigital.Artist.entity.ArtistEntity;
import it.apuliadigital.Artist.model.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArtistMapper {
    ArtistMapper INSTANCE = Mappers.getMapper(ArtistMapper.class);

    // Mappa da Entity a DTO
    Artist toDto(ArtistEntity artistEntity);

    // Mappa da DTO a Entity
    ArtistEntity toEntity(Artist artistDTO);
}
