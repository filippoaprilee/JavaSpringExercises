package it.apuliadigital.Artist.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.Artist.api.ArtistsApi;
import it.apuliadigital.Artist.model.Artist;
import it.apuliadigital.Artist.service.ArtistService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistController implements ArtistsApi {

    @Autowired
    private ArtistService artistService;

    Logger logger = LoggerFactory.getLogger(ArtistController.class);

    @Override
    public ResponseEntity<Artist> createArtist(@Parameter(name = "Artist",description = "Data for the new artist",required = true) @RequestBody @Valid Artist artist) {
        try {
            Artist newArtist = artistService.createArtist(artist);
            logger.info("Artist created: " + newArtist); // Questo sarà nel GENERAL_FILE e INFO_FILE
            return new ResponseEntity<>(newArtist, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error creating artist: " + artist, e); // Questo sarà nel ERROR_FILE
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Artist> deleteArtist(@Parameter(name = "artistId",description = "",required = true,in = ParameterIn.PATH) @PathVariable("artistId") Long artistId) {
        try {
            artistService.deleteArtist(artistId);
            logger.info("Deleted artist with ID: " + artistId); // Livello INFO
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error deleting artist with ID: " + artistId, e); // Livello ERROR
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Artist>> getAllArtists() {
        logger.debug("Fetching all artists"); // Livello DEBUG
        List<Artist> artists = artistService.getAllArtists();
        if (artists.isEmpty()) {
            logger.warn("No artists found"); // Livello WARN
        }
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Artist> getArtistById(@Parameter(name = "artistId",description = "",required = true,in = ParameterIn.PATH) @PathVariable("artistId") Long artistId) {
        Artist artist = artistService.getArtistById(artistId);
        return new ResponseEntity<Artist>(artist, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Artist>> getArtistsByNationality(@Parameter(name = "nationality",description = "",required = true,in = ParameterIn.PATH) @PathVariable("nationality") String nationality) {
        List<Artist> artists = artistService.searchArtistsByNationality(nationality);
        return new ResponseEntity<List<Artist>>(artists, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Artist>> getArtistsByYear(@Parameter(name = "year",description = "",required = true,in = ParameterIn.PATH) @PathVariable("year") Integer year) {
        List<Artist> artists = artistService.searchArtistsByBirthYear(year);
        return new ResponseEntity<List<Artist>>(artists, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Artist> updateArtist(@Parameter(name = "artistId",description = "",required = true,in = ParameterIn.PATH) @PathVariable("artistId") Long artistId, @Parameter(name = "Artist",description = "Updated artist data",required = true) @RequestBody @Valid Artist artist) {
        boolean updated = artistService.updateArtist(artistId, artist);
        if (updated) {
            return new ResponseEntity<Artist>(artist, HttpStatus.OK);
        } else {
            return new ResponseEntity<Artist>(HttpStatus.NOT_FOUND);
        }
    }
}
