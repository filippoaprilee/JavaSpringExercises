package it.apuliadigital.Museo.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.Museo.api.ApiUtil;
import it.apuliadigital.Museo.api.ArtistiApi;
import it.apuliadigital.Museo.model.Artista;
import it.apuliadigital.Museo.service.ArtistaService;
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
public class ArtistaController implements ArtistiApi {

    @Autowired
    private ArtistaService artistaService;

    Logger logger = LoggerFactory.getLogger(ArtistaController.class);

    @Override
    public ResponseEntity<Artista> creaArtista(
            @Parameter(name = "Artista", description = "Dati per il nuovo artista", required = true) @Valid @RequestBody Artista artista
    ) {
        Artista nuovoArtista = artistaService.createArtist(artista);
        logger.info("Artista creato: " + nuovoArtista);
        return new ResponseEntity<Artista>(nuovoArtista, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> eliminaArtista(
            @Parameter(name = "idArtista", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idArtista") Long idArtista
    ) {
        artistaService.deleteArtist(idArtista);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Artista> getArtistaById(
            @Parameter(name = "idArtista", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idArtista") Long idArtista
    ) {
        Artista artista = artistaService.getArtistById(idArtista);
        return new ResponseEntity<Artista>(artista, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Artista>> getTuttiGliArtisti(

    ) {
        List<Artista> artisti = artistaService.getAllArtists();
        return new ResponseEntity<List<Artista>>(artisti, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> aggiornaArtista(
            @Parameter(name = "idArtista", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idArtista") Long idArtista,
            @Parameter(name = "Artista", description = "Dati aggiornati dell'artista", required = true) @Valid @RequestBody Artista artista
    ) {
        boolean aggiornato = artistaService.updateArtist(idArtista, artista);
        if (aggiornato) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
