package it.apuliadigital.Portale.service;

import it.apuliadigital.Portale.model.AlbumDTO;
import it.apuliadigital.Portale.model.AlbumEArtista;
import it.apuliadigital.Portale.model.ArtistaEAlbums;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PortaleService {
    public AlbumEArtista albumAndArtist(Long idAlbum);
    public ArtistaEAlbums artistAndAlbum(Long idArtista);
    public List<AlbumDTO> getAlbumsByGenre(String genre);
}
