package it.apuliadigital.Artist.mapper;

import it.apuliadigital.Artist.entity.ArtistEntity;
import it.apuliadigital.Artist.model.Artist;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-13T13:53:25+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class ArtistMapperImpl implements ArtistMapper {

    @Override
    public Artist toDto(ArtistEntity artistEntity) {
        if ( artistEntity == null ) {
            return null;
        }

        Artist artist = new Artist();

        artist.setId( artistEntity.getId() );
        artist.setType( artistEntity.getType() );
        artist.setName( artistEntity.getName() );
        artist.setSurname( artistEntity.getSurname() );
        artist.setStageName( artistEntity.getStageName() );
        artist.setBirthYear( artistEntity.getBirthYear() );
        artist.setBiography( artistEntity.getBiography() );
        artist.setGenre( artistEntity.getGenre() );
        artist.setNationality( artistEntity.getNationality() );

        return artist;
    }

    @Override
    public ArtistEntity toEntity(Artist artistDTO) {
        if ( artistDTO == null ) {
            return null;
        }

        ArtistEntity artistEntity = new ArtistEntity();

        artistEntity.setId( artistDTO.getId() );
        artistEntity.setType( artistDTO.getType() );
        artistEntity.setName( artistDTO.getName() );
        artistEntity.setSurname( artistDTO.getSurname() );
        artistEntity.setStageName( artistDTO.getStageName() );
        artistEntity.setBirthYear( artistDTO.getBirthYear() );
        artistEntity.setBiography( artistDTO.getBiography() );
        artistEntity.setGenre( artistDTO.getGenre() );
        artistEntity.setNationality( artistDTO.getNationality() );

        return artistEntity;
    }
}
