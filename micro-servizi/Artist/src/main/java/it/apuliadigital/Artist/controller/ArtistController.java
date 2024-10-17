package it.apuliadigital.Artist.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.Artist.api.ApiUtil;
import it.apuliadigital.Artist.api.ArtistsApi;
import it.apuliadigital.Artist.exception.ArtistNotFoundException;
import it.apuliadigital.Artist.model.Artist;
import it.apuliadigital.Artist.service.ArtistService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArtistController implements ArtistsApi {

    @Autowired
    private ArtistService artistService;

    Logger logger = LoggerFactory.getLogger(ArtistController.class);

    public ResponseEntity<Artist> createArtist(
            @Parameter(name = "Artist", description = "Data for the new artist", required = true) @Valid @RequestBody Artist artist
    ) {
        try {
            Artist createdArtist = artistService.createArtist(artist);
            return new ResponseEntity<>(createdArtist, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ArtistNotFoundException("Failed to create artist: " + e.getMessage());
        }
    }


    @Override
    public ResponseEntity<Artist> deleteArtist(@Parameter(name = "artistId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("artistId") Long artistId) {
        artistService.deleteArtist(artistId);
        logger.info("Deleted artist with ID: " + artistId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Artist>> getAllArtists() {
        logger.debug("Fetching all artists");
        List<Artist> artists = artistService.getAllArtists();
        if (artists.isEmpty()) {
            logger.warn("No artists found");
        }
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Artist> getArtistById(@Parameter(name = "artistId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("artistId") Long artistId) {
        Artist artist = artistService.getArtistById(artistId); // Questa chiamata lancerà ArtistNotFoundException se l'artista non esiste
        return ResponseEntity.ok(artist); // Restituisce l'artista se trovato
    }


    @Override
    public ResponseEntity<List<Artist>> getArtistsByNationality(@Parameter(name = "nationality", description = "", required = true, in = ParameterIn.PATH) @PathVariable("nationality") String nationality) {
        List<Artist> artists = artistService.searchArtistsByNationality(nationality);
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Artist>> getArtistsByYear(@Parameter(name = "year", description = "", required = true, in = ParameterIn.PATH) @PathVariable("year") Integer year) {
        List<Artist> artists = artistService.searchArtistsByBirthYear(year);
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Artist> updateArtist(@Parameter(name = "artistId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("artistId") Long artistId, @Parameter(name = "Artist", description = "Updated artist data", required = true) @RequestBody @Valid Artist artist) {
        artistService.updateArtist(artistId, artist);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }
}
