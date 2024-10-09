package it.apuliadigital.AlbumAPI.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.AlbumAPI.api.AlbumApi;
import it.apuliadigital.AlbumAPI.api.ApiUtil;
import it.apuliadigital.AlbumAPI.model.Album;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AlbumController implements AlbumApi {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Override
    public ResponseEntity<Album> addAlbum(
            @Parameter(name = "Album", description = "Create a new album in the store", required = true) @Valid @RequestBody Album album
    ) {
        // Todo business logic
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

//    @Override
//    public void deleteAlbum() {
//
//    }

    public ResponseEntity<Album> getAlbumById(
            @Parameter(name = "albumId", description = "ID of album to return", required = true, in = ParameterIn.PATH) @PathVariable("albumId") Long albumId
    ) {
        // Todo business logic
        HashMap<String, String> bandMap = new HashMap<>();
        bandMap.put("Chitarra", "David Gilmour");
        bandMap.put("Batteria", "Slayer");
        bandMap.put("Basso", "Megadeth");
        bandMap.put("Voce", "Bruce Dickinson");
        List<Map<String, String>> band = new ArrayList<>();
        band.add(bandMap);

        Album a = new Album();
        a.setTitle("Album title");
        a.setAuthor("Album artist");
        a.setBand(band);
        a.setGenre(Album.GenreEnum.ROCK);
        a.setIdAlbum(1L);
        a.setYear(2021);

        return new ResponseEntity<>(HttpStatus.OK);

    }

//    @Override
//    public void getAlbums() {
//
//    }
//
//    @Override
//    public void updateAlbum() {
//
//    }
}
