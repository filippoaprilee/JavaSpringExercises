package it.apuliadigital.Portale.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.Portale.api.ApiUtil;
import it.apuliadigital.Portale.api.PortaleApi;
import it.apuliadigital.Portale.model.AlbumDTO;
import it.apuliadigital.Portale.model.AlbumEArtista;
import it.apuliadigital.Portale.model.ArtistaEAlbums;
import it.apuliadigital.Portale.service.PortaleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PortaleController implements PortaleApi {

    @Autowired
    private PortaleService portaleService;

    public ResponseEntity<AlbumEArtista> albumAndArtist(
            @Parameter(name = "idAlbum", description = "ID of the album to return", required = true, in = ParameterIn.PATH) @PathVariable("idAlbum") Long idAlbum
    ) {
        boolean isPresente = portaleService.albumAndArtist(idAlbum) != null;
        return isPresente ? new ResponseEntity<>(portaleService.albumAndArtist(idAlbum), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ArtistaEAlbums> artistAndAlbum(
            @Parameter(name = "idArtista", description = "ID of the artist to return", required = true, in = ParameterIn.PATH) @PathVariable("idArtista") Long idArtista
    ) {
        boolean isPresente = portaleService.artistAndAlbum(idArtista) != null;
        return isPresente ? new ResponseEntity<>(portaleService.artistAndAlbum(idArtista), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<AlbumDTO>> getAlbumsByGenre(
            @NotNull @Parameter(name = "genre", description = "Genre to filter albums", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "genre", required = true) String genre
    ) {
        return new ResponseEntity<>(portaleService.getAlbumsByGenre(genre), HttpStatus.OK);
    }
}
