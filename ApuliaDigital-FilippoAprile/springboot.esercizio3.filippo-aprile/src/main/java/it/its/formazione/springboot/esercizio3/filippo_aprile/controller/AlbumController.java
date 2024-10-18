package it.its.formazione.springboot.esercizio3.filippo_aprile.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.its.formazione.springboot.esercizio3.filippo_aprile.server.api.AlbumsApi;
import it.its.formazione.springboot.esercizio3.filippo_aprile.server.api.ApiUtil;
import it.its.formazione.springboot.esercizio3.filippo_aprile.server.model.AlbumDTO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumController implements AlbumsApi {

    Logger log = LoggerFactory.getLogger(ArtistController.class);


    public ResponseEntity<Void> createAlbum(
            @Parameter(name = "Album", description = "Album object that needs to be added", required = true) @Valid @RequestBody AlbumDTO album
    ) {
        log.info("Ingresso nel metodo createAlbum");
        log.info("Uscita dal metodo createAlbum");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<Void> deleteAlbum(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        log.info("Ingresso nel metodo deleteAlbum per l'id: {}", id);
        log.info("Uscita dal metodo deleteAlbum");
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<AlbumDTO> getAlbumById(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        log.info("Ingresso nel metodo getAlbumById per l'id: {}", id);
        log.info("Uscita dal metodo getAlbumById");
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<AlbumDTO>> getAllAlbums(

    ) {
        log.info("Ingresso nel metodo getAllAlbums");
        log.info("Uscita dal metodo getAllAlbums");
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> updateAlbum(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
            @Parameter(name = "Album", description = "Album object that needs to be updated", required = true) @Valid @RequestBody AlbumDTO album
    ) {
        log.info("Ingresso nel metodo updateAlbum per l'id: {}", id);
        log.info("Uscita dal metodo updateAlbum");
        return ResponseEntity.ok().build();
    }
}
