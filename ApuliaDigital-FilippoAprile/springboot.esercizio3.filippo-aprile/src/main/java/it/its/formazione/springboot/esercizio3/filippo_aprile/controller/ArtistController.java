package it.its.formazione.springboot.esercizio3.filippo_aprile.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.its.formazione.springboot.esercizio3.filippo_aprile.server.api.ApiUtil;
import it.its.formazione.springboot.esercizio3.filippo_aprile.server.api.ArtistsApi;
import it.its.formazione.springboot.esercizio3.filippo_aprile.server.model.ArtistDTO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistController implements ArtistsApi {


    Logger log = LoggerFactory.getLogger(ArtistController.class);

    public ResponseEntity<Void> createArtist(
            @Parameter(name = "Artist", description = "Artist object that needs to be added", required = true) @Valid @RequestBody ArtistDTO artist
    ) {
        log.info("Ingresso nel metodo createArtist");
        log.info("Uscita dal metodo createArtist");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<Void> deleteArtist(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        log.info("Ingresso nel metodo deleteArtist per l'id: {}", id);
        log.info("Uscita dal metodo deleteArtist");
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<ArtistDTO>> getAllArtists(

    ) {
        log.info("Ingresso nel metodo getAllArtists");
        log.info("Uscita dal metodo getAllArtists");
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<ArtistDTO> getArtistById(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        log.info("Ingresso nel metodo getArtistById per l'id: {}", id);
        log.info("Uscita dal metodo getArtistById");
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> updateArtist(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
            @Parameter(name = "Artist", description = "Artist object that needs to be updated", required = true) @Valid @RequestBody ArtistDTO artist
    ) {
        log.info("Ingresso nel metodo updateArtist per l'id: {}", id);
        log.info("Uscita dal metodo updateArtist");
        return ResponseEntity.ok().build();
    }
}
