package it.apuliadigital.albumApi.controller;

import java.util.List;
import java.util.Map;

import it.apuliadigital.albumApi.entity.AlbumEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.albumApi.api.AlbumApi;
import it.apuliadigital.albumApi.api.ApiUtil;
import it.apuliadigital.albumApi.model.Album;
import it.apuliadigital.albumApi.model.Album.GenereEnum;
import it.apuliadigital.albumApi.service.AlbumService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
public class AlbumController implements AlbumApi {

    @Autowired
    AlbumService albumService;

    @Override
    public ResponseEntity<Album> addBandToAlbum(
            @Parameter(name = "idAlbum", description = "ID of album to return", required = true, in = ParameterIn.PATH) @PathVariable("idAlbum") Long idAlbum,
            @Parameter(name = "request_body", description = "Mette una band nell'album", required = true) @Valid @RequestBody Map<String, String> requestBody) {
                
        return new ResponseEntity<Album>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Album> createAlbum(
            @Parameter(name = "Album", description = "Crea un nuovo album nello store", required = true) @Valid @RequestBody Album album) {
        Album newAlbum = albumService.createAlbum(album);
        return new ResponseEntity<Album>(newAlbum, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Album> deleteAlbum(
            @Parameter(name = "idAlbum", description = "Id dell'album da eliminare", required = true, in = ParameterIn.PATH) @PathVariable("idAlbum") Long idAlbum) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Album>> findAlbumsByGenres(
            @NotNull @Parameter(name = "genre", description = "Valori del genere che devono essere considerate per il filtro", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "genre", required = true, defaultValue = "rock") String genre) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Album> getAlbumById(
            @Parameter(name = "idAlbum", description = "ID of album to return", required = true, in = ParameterIn.PATH) @PathVariable("idAlbum") Long idAlbum
    ) {
        Album album = albumService.getAlbumById(idAlbum);
        return new ResponseEntity<Album>(album, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Album> updateAlbum(
            @Parameter(name = "Album", description = "Aggiorna un album nello store", required = true) @Valid @RequestBody Album album) {
        return new ResponseEntity<Album>(album, HttpStatus.OK);
    }
}
