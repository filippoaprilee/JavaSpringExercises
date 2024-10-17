package it.apuliadigital.Artist.service.impl;

import it.apuliadigital.Artist.entity.ArtistEntity;
import it.apuliadigital.Artist.exception.ArtistNotFoundException;
import it.apuliadigital.Artist.mapper.ArtistMapper;
import it.apuliadigital.Artist.model.Artist;
import it.apuliadigital.Artist.repository.ArtistRepository;
import it.apuliadigital.Artist.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ArtistMapper artistMapper;

    @Override
    public Artist getArtistById(Long idArtist) {
        ArtistEntity entity = artistRepository.findById(idArtist)
                .orElseThrow(() -> new ArtistNotFoundException("Artist with ID " + idArtist + " not found"));
        return artistMapper.toDto(entity);
    }

    @Override
    public Artist createArtist(Artist artist) {
        ArtistEntity entity = artistMapper.toEntity(artist);
        artistRepository.save(entity);
        artist.setId(entity.getId());
        return artist;
    }

    @Override
    public boolean updateArtist(Long id, Artist artist) {
        if (!artistRepository.existsById(id)) {
            throw new ArtistNotFoundException("Artist with ID " + id + " not found");
        }
        ArtistEntity entity = artistMapper.toEntity(artist);
        entity.setId(id);
        artistRepository.save(entity);
        return true;
    }

    @Override
    public boolean deleteArtist(Long id) {
        if (!artistRepository.existsById(id)) {
            throw new ArtistNotFoundException("Artist with ID " + id + " not found");
        }
        artistRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Artist> searchArtistsByNationality(String nationality) {
        List<ArtistEntity> entities = artistRepository.findByNationality(nationality);
        return entities.stream()
                .map(artistMapper::toDto)  // Usa il mapper per la conversione a DTO
                .collect(Collectors.toList());
    }

    @Override
    public List<Artist> searchArtistsByBirthYear(Integer birthYear) {
        List<ArtistEntity> entities = artistRepository.findByBirthYear(birthYear);
        return entities.stream()
                .map(artistMapper::toDto)  // Usa il mapper per la conversione a DTO
                .collect(Collectors.toList());
    }

    @Override
    public List<Artist> getAllArtists() {
        List<ArtistEntity> entities = (List<ArtistEntity>) artistRepository.findAll();
        return entities.stream()
                .map(artistMapper::toDto)  // Usa il mapper per la conversione a DTO
                .collect(Collectors.toList());
    }

}
