package it.its.formazione.springboot.esercizio2.filippo_aprile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidBookingDatesException.class)
    public ResponseEntity<ErrorResponse> handleInvalidBookingDatesException(InvalidBookingDatesException ex) {
        ErrorResponse errorResponse = new ErrorResponse("Date di Prenotazione Non Valide", ex.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBookingNotFoundException(BookingNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse("Prenotazione Non Trovata", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(BookingAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleBookingAlreadyExistsException(BookingAlreadyExistsException ex) {
        ErrorResponse errorResponse = new ErrorResponse("Prenotazione Già Esistente", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }
}
