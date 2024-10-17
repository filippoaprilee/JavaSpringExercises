package it.apuliadigital.Artist.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ArtistNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleArtistNotFound(ArtistNotFoundException e) {
        logger.warn("Artist not found: " + e.getMessage());
        Map<String, String> response = new HashMap<>();
        response.put("error", e.getMessage()); // Puoi personalizzare la chiave come preferisci
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // Restituisci un oggetto JSON valido
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        logger.error("Unhandled exception: ", e);
        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
