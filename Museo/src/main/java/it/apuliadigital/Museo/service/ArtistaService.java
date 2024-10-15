package it.apuliadigital.Museo.service;

import it.apuliadigital.Museo.model.Artista;

import java.util.List;

public interface ArtistaService {
    List<Artista> getAllArtists();
    Artista getArtistById(Long idArtist);
    Artista createArtist(Artista artist);
    boolean updateArtist(Long id, Artista artist);
    boolean deleteArtist(Long id);
}
