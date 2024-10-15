package it.apuliadigital.Museo.service.impl;

import it.apuliadigital.Museo.entity.ArtistaEntity;
import it.apuliadigital.Museo.mapper.ArtistaMapper;
import it.apuliadigital.Museo.model.Artista;
import it.apuliadigital.Museo.repository.ArtistaRepository;
import it.apuliadigital.Museo.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistaServiceImpl implements ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private ArtistaMapper artistaMapper;

    @Override
    public Artista getArtistById(Long idArtist) {
        Optional<ArtistaEntity> entity = artistaRepository.findById(idArtist);
        return entity.map(artistaMapper::toDto).orElse(null);
    }

    @Override
    public Artista createArtist(Artista artist) {
        ArtistaEntity entity = artistaMapper.toEntity(artist);
        artistaRepository.save(entity);
        artist.setIdArtista(entity.getIdArtista());
        return artist;
    }

    @Override
    public boolean updateArtist(Long id, Artista artist) {
        if (artistaRepository.existsById(id)) {
            ArtistaEntity entity = artistaMapper.toEntity(artist);  // Usa il mapper per la conversione a Entity
            entity.setIdArtista(id);  // Assicurati che l'ID sia corretto
            artistaRepository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteArtist(Long id) {
        if (artistaRepository.existsById(id)) {
            artistaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Artista> getAllArtists() {
        return artistaRepository.findAll().stream().map(artistaMapper::toDto).collect(Collectors.toList());
    }
}
